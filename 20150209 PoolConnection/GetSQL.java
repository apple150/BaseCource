
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.locks.Lock;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import dbm.DBConnection;
import dbm.DBConnectionManager;
import dto.News;
import log.Logger;


public class GetSQL extends Thread {
	private int npp; 		 //НОМЕР по порядку
	private static String nameSQL ="";  //SQL
	
	private Lock lock=null;
	private static DBConnectionManager dbcm = null;
	private static Logger myLog = null;
	
	private static Statement statement = null;
	private static ResultSet rs = null;
	
	

	public GetSQL(int npp, String nameSQL, Lock lock, DBConnectionManager dbcm, Logger myLog) {
		this.nameSQL = nameSQL;
		this.npp = npp;
		this.lock = lock;
		this.dbcm = dbcm;
		this.myLog = myLog;
		
		myLog = Logger.getLogger("");		
	}
	
	@Override
	public void run()  {  //Функция синхронизирована
		lock.lock(); //БЛОКИРОВКА		
		//DBConnection dbc = dbcm.getConnection();
		//Connection connection = dbc.getConnection();
		getNews();
		lock.unlock(); //РАЗБЛОКИРОВКА 
	}
	
	/**
	 * Получить НОВОСТЬ по ID
	 */	
	public static News getNews() {
		News news = null;
		//String query="SELECT * FROM news WHERE id ="+num;
		//myLog.AddStrToLogFile(query);		
		try {
			DBConnection dbc = dbcm.getConnection();
			Connection connection = dbc.getConnection();
			statement = (Statement) connection.createStatement();
			rs = statement.executeQuery(nameSQL);
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
				myLog.AddStrToLogFile("News: "+news.toStringNew());
			} else return null;				
		} catch (SQLException e) {
			myLog.AddStrToLogFile("ОШИБКА SQL "+e.toString());
		}
		return news;
	}
	
}
