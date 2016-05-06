package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.PageData;

public class pageDao {
	
	private Connection connection;
   // private Statement statement;
	
	private pageDao() 
	{
		try {			
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error loading driver: " +cnfe); // log4j
		}
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysite","root","1234");
			System.out.println("Good connection");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//MyLogger.getLogger().write("Ошибка подключения к базе!"); log4j
		}
		
	}
	private static pageDao thisDao; 
	
	public static  pageDao getDao()
	{
		if(thisDao == null)
			thisDao = new pageDao();
		return thisDao;
	}
	
	public PageData getPage(String id)
	{
		PageData data = null;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from pages where id='"+id+"'");
			if(rs.next())
			{
				data = new PageData();
				data.setId(rs.getString("id"));
				data.setParentid(rs.getString("parentid"));
				data.setTitle(rs.getString("title"));
				data.setTitle4menu(rs.getString("title4menu"));
				data.setKeywords(rs.getString("keywords"));
				data.setDescription(rs.getString("description"));
				data.setMaintext(rs.getString("maintext"));
			}
			else 
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	public List<PageData> getPagesByParent(String parentid)
	{
		ArrayList<PageData> pages = new ArrayList<PageData>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from pages where parentid='"+parentid+"'");
			while(rs.next())
			{
				PageData data = new PageData();
			
				data.setId(rs.getString("id"));
				data.setParentid(rs.getString("parentid"));
				data.setTitle(rs.getString("title"));
				data.setTitle4menu(rs.getString("title4menu"));
				data.setKeywords(rs.getString("keywords"));
				data.setDescription(rs.getString("description"));
				data.setMaintext(rs.getString("maintext"));
				pages.add(data);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return pages;
	}
	public int addPage(PageData p)
	{
		return 1;
	}
}