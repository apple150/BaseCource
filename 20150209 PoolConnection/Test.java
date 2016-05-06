import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import log.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import dbm.DBConnection;
import dbm.DBConnectionManager;
import dto.News;

public class Test {

	private static Statement statement = null;
	private static ResultSet rs = null;
	private static Connection connection = null;
	
	private static Logger myLog = null; //������� ������ Logger � ���������� ����������
	private static DBConnectionManager dbcm = null;
	
	public static void main(String[] args) {
		String CurDir = new File("").getAbsolutePath();
		myLog = Logger.getLogger(CurDir);
		myLog.AddStrToLogFile("		*** ������ ��������� ***");
		
		Lock lock = new ReentrantLock();
		List<GetSQL> arrayGetSQL = new ArrayList<GetSQL>();
		DBConnectionManager dbcm = DBConnectionManager.getDBConnectionManager(5);
		
		String [][] arraySQL = null;
		int count=0;
		
		for (int i=0; i<count; i++) {
			arraySQL[0][i]="query-i";
		}
		
		int num=0;
		for (int i=0; i<count; i++) {	
			num++;
			arraySQL[1][i]="SELECT * FROM news WHERE id ="+num;
			if (num==10) num=0;
		}
		
		/**
		 * Create DBConnectionManager design pattern - SINGLETON
		 */
		
		/*
		DBConnectionManager dbcm = DBConnectionManager.getDBConnectionManager(5);
		DBConnection dbc = null;
		News news = null;
		//for (int z=1; z<100; z++) {
			for (int i=1; i<11; i++) {			
				dbc = dbcm.getConnection();
				//System.out.println("Connection  � "+dbc.getNumConnection());
				//myLog.AddStrToLogFile("Connection  � "+dbc.getNumConnection());
				connection = dbc.getConnection();
				news = getNews(i);
				myLog.AddStrToLogFile("Connection: "+dbc.getNumConnection()+" News: "+news.toStringNew());
				//System.out.println("News  � "+news.toStringNew());
				//if (i==10) i=0;
				dbcm.returnConnection(dbc);			
			}		
		//}
		 * 
		 * 
		 */
	}
	
	/**
	 * �������� ������� �� ID
	 */	
	public static News getNews(int num) {
		News news = null;
		String query="SELECT * FROM news WHERE id ="+num;
		//myLog.AddStrToLogFile(query);		
		try {
			statement = (Statement) connection.createStatement();
			rs = statement.executeQuery(query);
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
				//myLog.AddStrToLogFile("News: "+news.toStringNew());
			} else return null;				
		} catch (SQLException e) {
			myLog.AddStrToLogFile("������ SQL "+e.toString());
		}
		return news;
	}
	 
	 
}
