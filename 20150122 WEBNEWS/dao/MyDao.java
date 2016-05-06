/*	
 * 	MyDao		 	
 * 	���������� DAO.  ������ � ������� �� Singleton.
 * 	1. ���������� ����������� � ��
 * 	2. ���������� ������� �� ��
 * 
 *  � Copyright		Sergey Buglak		(������ ������) 
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
 * ����� MyDao ����� ������ � ������������ � �� SINGLETON
 */
public class MyDao implements Dao  {
	private static MyDao inst;
	private static Logger myLog = null;
	private Connection connection;
	private String DirWithOptions = ""; 	// ���������� ��� ������ ����������� ����� config.properties, query.properties
	private String nameConfigFile = null; 	// �������� ���� ��������� ���������� ����������� � ��
	private String nameSQLConfig = null;	// �������� ���� ��������� SQL ������� �� ��
	
	/**
	 * �.�. �� SINGLETON �� ����������� ����������� ������ ���� private
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
        	
        	myLog.AddStrToLogFile("���� ��������: "+nameConfigFile);
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
        	myLog.AddStrToLogFile("���� ��������: ���������� !");
        }		
		
        if (driver!=null) {
			try {
				Class.forName(driver); //com.mysql.jdbc.Driver
			} catch (ClassNotFoundException cnfe) {
				myLog.AddStrToLogFile("������ �������� ��������");
				//System.out.println("Error loading driver: " +cnfe);
			}
			
			try {
				connection = DriverManager.getConnection(host, login, password); //jdbc:mysql://localhost:3306/webnews, root, 		
			} catch (SQLException e) {
				myLog.AddStrToLogFile("������ ����������� � ��");
				//e.printStackTrace();
			}		
        }
	}
	
	/**
	 * ��������� ����������� ����� ������������ ������ �� ���� �� �����
	 * ���� ������ ����� ������������ ������������� � ������ �������, ��
	 * ���������� ������ ���������� ����� ������� ����� �������:
	 *   public static synchronized MyDao getDao()
	 * �� ���� ������� ��� ������������� ��������� ������
	 */
	public static synchronized MyDao getDao(String CurDir) {
		if (inst == null) {
			inst = new MyDao(CurDir); 
			myLog.AddStrToLogFile("������ ������ DAO Singleton");
		}
		return inst;
	}

	/**
	 * �������� SQL �� ����� query.properties �� ���������
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
        	myLog.AddStrToLogFile("���� �������� SQL: ���������� !"+e.toString());
        }
		return ret;
	}
	
	/**
	 * �������� ������������ �� E-MAIL
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
				user.setId(Integer.parseInt(rs.getString("id")));		// ������������� ������������
				user.setRole(Integer.parseInt(rs.getString("role")));	// ����� ������� ������������ (1-�������������, 2-������������)
				user.setName(rs.getString("name"));						// ��� ������������
				user.setFam(rs.getString("fam"));						// ������� ������������
				user.setEmail(rs.getString("email"));					// E-Mail ������������
				user.setPassword(rs.getString("password"));				// ������ ������������
				myLog.AddStrToLogFile("������: "+user.toString());
			} else return null;				
		} catch (SQLException e) {
			myLog.AddStrToLogFile("������ SQL "+e.toString());
		}
		return user;
	}

	/**
	 * �������� ������ �������������
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
				user.setId(Integer.parseInt(rs.getString("id")));		// ������������� ������������
				user.setRole(Integer.parseInt(rs.getString("role")));	// ����� ������� ������������ (1-�������������, 2-������������)
				user.setName(rs.getString("name"));						// ��� ������������
				user.setFam(rs.getString("fam"));						// ������� ������������
				user.setEmail(rs.getString("email"));					// E-Mail ������������
				user.setPassword(rs.getString("password"));				// ������ ������������
				array_users.add(user);				
			}
		} catch (SQLException e) {
			myLog.AddStrToLogFile("������ SQL "+e.toString());
		}		
		return array_users;		
	}

	/**
	 * �������� ������� �� ID
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
				news.setId(Integer.parseInt(rs.getString("id")));// ������������� �������				
				news.setCategory(rs.getString("category"));		 // ��������� ������� ��������, ���������, �����, ...
				news.setTitle(rs.getString("title"));			 // ��������� �������
				news.setAnnotation(rs.getString("annotation"));	 // ��������� (������� ��������� �������)
				news.setAuthor(rs.getString("author"));			 // ��� � ������� ������ �������
				news.setAgency(rs.getString("agency"));			 // �������� �������������� �������
				news.setDrelease(rs.getString("drelease"));		 // ���� ������ �������
				news.setDocument(rs.getString("document"));		 // ����� �������				
				myLog.AddStrToLogFile("������: "+news.toString());
			} else return null;				
		} catch (SQLException e) {
			myLog.AddStrToLogFile("������ SQL "+e.toString());
		}
		return news;
	}

	/**
	 * �������� ������ ��������
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
				news.setId(Integer.parseInt(rs.getString("id")));// ������������� �������
				news.setCategory(rs.getString("category"));		// ��������� ������� ��������, ���������, �����, ...
				news.setTitle(rs.getString("title"));			// ��������� �������
				news.setAnnotation(rs.getString("annotation"));	// ��������� (������� ��������� �������)
				news.setAuthor(rs.getString("author"));			// ��� � ������� ������ �������
				news.setAgency(rs.getString("agency"));			// �������� �������������� �������
				news.setDrelease(rs.getString("drelease"));		// ���� ������ �������
				news.setDocument(rs.getString("document"));		// ����� �������				
				array_news.add(news);				
			}
		} catch (SQLException e) {
			myLog.AddStrToLogFile("������ SQL "+e.toString());
		}		
		return array_news;
	}

	/**
	 * �������� ������������ USER
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
			if (ret > 0) myLog.AddStrToLogFile("������������ ��������: "+user.toString());
		} catch (SQLException e) {
			myLog.AddStrToLogFile("������ SQL (���������� user)"+e.toString());
		}		
		return ret;
	}

	/**
	 * ������� ������������ USER (�� ID)
	 */
	@Override
	public int delUser(User user) {
		int ret=0;
		String query=getSQL("SQL_USERS_DEL")+user.getId();		
		myLog.AddStrToLogFile(query);
		try {
			Statement statement = (Statement) connection.createStatement();
			ret = statement.executeUpdate(query);	
			if (ret > 0) myLog.AddStrToLogFile("������������ ������: "+user.toString());
		} catch (SQLException e) {
			myLog.AddStrToLogFile("������ SQL (�������� user)"+e.toString());
		}		
		return ret;		
	}

	/**
	 * �������� ������� NEWS
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
			if (ret > 0) myLog.AddStrToLogFile("������� ���������: "+news.toString());
		} catch (SQLException e) {
			myLog.AddStrToLogFile("������ SQL ����������� news)"+e.toString());
		}		
		return ret;
	}

	/**
	 * ������� ������� NEWS (�� ID)
	 */	
	@Override
	public int delNews(News news) {
		int ret=0;
		String query=getSQL("SQL_NEWS_DEL")+news.getId();		
		myLog.AddStrToLogFile(query);
		try {
			Statement statement = (Statement) connection.createStatement();
			ret = statement.executeUpdate(query);	
			if (ret > 0) myLog.AddStrToLogFile("������� �������: "+news.toString());
		} catch (SQLException e) {
			myLog.AddStrToLogFile("������ SQL (�������� news)"+e.toString());
		}		
		return ret;		
	}
}
