/*	
 * 	MyDao		 	
 * 	Реализация DAO.  Создан с помощью ШП Singleton.
 * 	1. Реализация подключения к БД
 * 	2. Реализация выборок из БД
 * 
 *  © Copyright		Sergey Buglak		(Сергей Буглак) 
 *		e-mail:  	Apple150@mail.ru 
*/

package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import log.Logger;

import com.mysql.jdbc.Statement;

import dto.News;
import dto.User;

/**
 * Класс MyDao будет сделан в соответствии с ШП SINGLETON
 */
public class MyDao implements Dao  {
	private static MyDao inst;
	private static Logger myLog = null;
	private Connection connection;
	private String DirWithOptions = ""; 	// Директорий где искать настроечные файлы config.properties, query.properties
	private String nameConfigFile = null; 	// Название фала настройки параметров подключения к БД
	private String nameSQLConfig = null;	// Название фала настройки SQL выборок из БД
	
	/**
	 * Т.к. ШП SINGLETON то конструктор обязательно должен быть private
	 */
	private MyDao(String CurDir) {
		myLog = Logger.getLogger(CurDir);
		DirWithOptions = CurDir;
		
        String driver=null, host="", login="", password="";
		
		FileInputStream fis;
        Properties property = new Properties();
        try {
        	nameConfigFile = DirWithOptions+"//dao//config.properties";
        	nameSQLConfig  = DirWithOptions+"//dao//query.properties";
        	
        	myLog.AddStrToLogFile("Файл настроек: "+nameConfigFile);
            fis = new FileInputStream(nameConfigFile);
            property.load(fis);
            
            driver = property.getProperty("driver");
            host = property.getProperty("host");
            login = property.getProperty("login");
            password = property.getProperty("password");
            myLog.AddStrToLogFile("DRIVER: "+driver);
            myLog.AddStrToLogFile("HOST:   "+host);
            myLog.AddStrToLogFile("LOGIN:  "+login);
            myLog.AddStrToLogFile("PASSWORD: "+password);
        } catch (IOException e) {
        	myLog.AddStrToLogFile("Файл настроек: отсуствует !");
        }		
		
        if (driver!=null) {
			try {
				Class.forName(driver); //com.mysql.jdbc.Driver
			} catch (ClassNotFoundException cnfe) {
				myLog.AddStrToLogFile("ОШИБКА загрузки драйвера");
				//System.out.println("Error loading driver: " +cnfe);
			}
			
			try {
				connection = DriverManager.getConnection(host, login, password); //jdbc:mysql://localhost:3306/webnews, root, 		
			} catch (SQLException e) {
				myLog.AddStrToLogFile("ОШИБКА подключения к БД");
				//e.printStackTrace();
			}		
        }
	}
	
	/**
	 * Создается статический метод возвращающий объект на этот же класс
	 * если объект будет одновременно ипользоваться в разных потоках, то
	 * объявление метода необходими будет сделать таким образом:
	 *   public static synchronized MyDao getDao()
	 * но надо помнить что синхронизация замедляет работу
	 */
	public static synchronized MyDao getDao(String CurDir) {
		if (inst == null) {
			inst = new MyDao(CurDir); 
			myLog.AddStrToLogFile("Создан объект DAO Singleton");
		}
		return inst;
	}

	/**
	 * Получить SQL из файла query.properties по параметру
	 */	
	public String getSQL(String param) {
		String ret="";
		FileInputStream fis;
        Properties property = new Properties();
		try {
            fis = new FileInputStream(nameSQLConfig);
            property.load(fis);
            ret = property.getProperty(param);
		} catch (IOException e) {
        	myLog.AddStrToLogFile("Файл запросов SQL: отсуствует !"+e.toString());
        }
		return ret;
	}
	
	/**
	 * Получить ПОЛЬЗОВАТЕЛЯ по E-MAIL
	 */
	@Override
	public User getUser(String email) {
		User user = null;
		String query=getSQL("SQL_USERS_EMAIL")+"\""+email+"\"";
		myLog.AddStrToLogFile(query);		
		try {
			Statement statement = (Statement) connection.createStatement();
			//String query="SELECT * FROM users WHERE email="+"\""+email+"\"";
			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {			
				user = new User();
				user.setId(Integer.parseInt(rs.getString("id")));		// Идентификатор Пользователя
				user.setRole(Integer.parseInt(rs.getString("role")));	// Права доступа Пользователя (1-администратор, 2-пользователь)
				user.setName(rs.getString("name"));						// Имя Пользователя
				user.setFam(rs.getString("fam"));						// Фамилия Пользователя
				user.setEmail(rs.getString("email"));					// E-Mail Пользователя
				user.setPassword(rs.getString("password"));				// Пароль Пользователя
				myLog.AddStrToLogFile("ОБЪЕКТ: "+user.toString());
			} else return null;				
		} catch (SQLException e) {
			myLog.AddStrToLogFile("ОШИБКА SQL "+e.toString());
		}
		return user;
	}

	/**
	 * Получить массив ПОЛЬЗОВАТЕЛЕЙ
	 */	
	@Override
	public ArrayList<User> getUsers() {
		ArrayList<User> array_users = new ArrayList<User>();
		String query=getSQL("SQL_USERS_ALL"); // query="SELECT * FROM users"
		myLog.AddStrToLogFile(query);
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery(query);			
			while (rs.next()) {
				User user = new User();			
				user.setId(Integer.parseInt(rs.getString("id")));		// Идентификатор Пользователя
				user.setRole(Integer.parseInt(rs.getString("role")));	// Права доступа Пользователя (1-администратор, 2-пользователь)
				user.setName(rs.getString("name"));						// Имя Пользователя
				user.setFam(rs.getString("fam"));						// Фамилия Пользователя
				user.setEmail(rs.getString("email"));					// E-Mail Пользователя
				user.setPassword(rs.getString("password"));				// Пароль Пользователя
				array_users.add(user);				
			}
		} catch (SQLException e) {
			myLog.AddStrToLogFile("ОШИБКА SQL "+e.toString());
		}		
		return array_users;		
	}

	/**
	 * Получить НОВОСТЬ по ID
	 */	
	@Override
	public News getNews(int num) {
		News news = null;
		String query=getSQL("SQL_NEWS_ID")+num;
		myLog.AddStrToLogFile(query);		
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {			
				news = new News();
				news.setId(Integer.parseInt(rs.getString("id")));// Идентификатор Новости				
				news.setCategory(rs.getString("category"));		 // Категория новости ПОЛИТИКА, ЭКОНОМИКА, СПОРТ, ...
				news.setTitle(rs.getString("title"));			 // Заголовок новости
				news.setAnnotation(rs.getString("annotation"));	 // Аннотация (краткое оприсание Новости)
				news.setAuthor(rs.getString("author"));			 // Имя и Фамилия Автора Новости
				news.setAgency(rs.getString("agency"));			 // Агенство опубликовавшее Новость
				news.setDrelease(rs.getString("drelease"));		 // Дата печати Новости
				news.setDocument(rs.getString("document"));		 // Текст Новости				
				myLog.AddStrToLogFile("ОБЪЕКТ: "+news.toString());
			} else return null;				
		} catch (SQLException e) {
			myLog.AddStrToLogFile("ОШИБКА SQL "+e.toString());
		}
		return news;
	}

	/**
	 * Получить массив НОВОСТЕЙ
	 */		
	@Override
	public ArrayList<News> getNews() {
		ArrayList<News> array_news = new ArrayList<News>();
		String query=getSQL("SQL_NEWS_ALL"); // query="SELECT * FROM news"
		myLog.AddStrToLogFile(query);
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				News news = new News();			
				news.setId(Integer.parseInt(rs.getString("id")));// Идентификатор Новости
				news.setCategory(rs.getString("category"));		// Категория новости ПОЛИТИКА, ЭКОНОМИКА, СПОРТ, ...
				news.setTitle(rs.getString("title"));			// Заголовок новости
				news.setAnnotation(rs.getString("annotation"));	// Аннотация (краткое оприсание Новости)
				news.setAuthor(rs.getString("author"));			// Имя и Фамилия Автора Новости
				news.setAgency(rs.getString("agency"));			// Агенство опубликовавшее Новость
				news.setDrelease(rs.getString("drelease"));		// Дата печати Новости
				news.setDocument(rs.getString("document"));		// Текст Новости				
				array_news.add(news);				
			}
		} catch (SQLException e) {
			myLog.AddStrToLogFile("ОШИБКА SQL "+e.toString());
		}		
		return array_news;
	}

	/**
	 * Добавить пользователя USER
	 */
	@Override
	public int addUser(User user) {
		int ret=0;
		String query=getSQL("SQL_USERS_ADD")+"("+user.getId()+", "+user.getRole()+", \""+user.getName()+"\", \""+
												user.getFam()+"\", \""+user.getEmail()+"\", \""+user.getPassword()+"\")";		
		myLog.AddStrToLogFile(query);
		try {
			Statement statement = (Statement) connection.createStatement();
			ret = statement.executeUpdate(query);	
			if (ret > 0) myLog.AddStrToLogFile("Пользователь добавлен: "+user.toString());
		} catch (SQLException e) {
			myLog.AddStrToLogFile("ОШИБКА SQL (добавление user)"+e.toString());
		}		
		return ret;
	}

	/**
	 * Удалить пользователя USER (по ID)
	 */
	@Override
	public int delUser(User user) {
		int ret=0;
		String query=getSQL("SQL_USERS_DEL")+user.getId();		
		myLog.AddStrToLogFile(query);
		try {
			Statement statement = (Statement) connection.createStatement();
			ret = statement.executeUpdate(query);	
			if (ret > 0) myLog.AddStrToLogFile("Пользователь удален: "+user.toString());
		} catch (SQLException e) {
			myLog.AddStrToLogFile("ОШИБКА SQL (удаление user)"+e.toString());
		}		
		return ret;		
	}

	/**
	 * Добавить новость NEWS
	 */	
	@Override
	public int addNews(News news) {
		int ret=0;
		String query=getSQL("SQL_NEWS_ADD")+"("+news.getId()+", \""+news.getCategory()+"\", \""+news.getTitle()+"\", \""+
				news.getAnnotation()+"\", \""+news.getAuthor()+"\", \""+news.getAgency()+"\", \""+news.getDrelease()+"\", \""+news.getDocument()+"\")";		
		myLog.AddStrToLogFile(query);
		try {
			Statement statement = (Statement) connection.createStatement();
			ret = statement.executeUpdate(query);	
			if (ret > 0) myLog.AddStrToLogFile("Новость добавлена: "+news.toString());
		} catch (SQLException e) {
			myLog.AddStrToLogFile("ОШИБКА SQL дбобавление news)"+e.toString());
		}		
		return ret;
	}

	/**
	 * Удалить новость NEWS (по ID)
	 */	
	@Override
	public int delNews(News news) {
		int ret=0;
		String query=getSQL("SQL_NEWS_DEL")+news.getId();		
		myLog.AddStrToLogFile(query);
		try {
			Statement statement = (Statement) connection.createStatement();
			ret = statement.executeUpdate(query);	
			if (ret > 0) myLog.AddStrToLogFile("Новость удалена: "+news.toString());
		} catch (SQLException e) {
			myLog.AddStrToLogFile("ОШИБКА SQL (удаление news)"+e.toString());
		}		
		return ret;		
	}
}
