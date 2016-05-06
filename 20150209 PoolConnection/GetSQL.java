
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
	private int npp; 		 //����� �� �������
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
	public void run()  {  //������� ����������������
		lock.lock(); //����������		
		//DBConnection dbc = dbcm.getConnection();
		//Connection connection = dbc.getConnection();
		getNews();
		lock.unlock(); //������������� 
	}
	
	/**
	 * �������� ������� �� ID
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
				news.setId(Integer.parseInt(rs.getString("id")));// ������������� �������				
				news.setCategory(rs.getString("category"));		 // ��������� ������� ��������, ���������, �����, ...
				news.setTitle(rs.getString("title"));			 // ��������� �������
				news.setAnnotation(rs.getString("annotation"));	 // ��������� (������� ��������� �������)
				news.setAuthor(rs.getString("author"));			 // ��� � ������� ������ �������
				news.setAgency(rs.getString("agency"));			 // �������� �������������� �������
				news.setDrelease(rs.getString("drelease"));		 // ���� ������ �������
				news.setDocument(rs.getString("document"));		 // ����� �������				
				myLog.AddStrToLogFile("News: "+news.toStringNew());
			} else return null;				
		} catch (SQLException e) {
			myLog.AddStrToLogFile("������ SQL "+e.toString());
		}
		return news;
	}
	
}
