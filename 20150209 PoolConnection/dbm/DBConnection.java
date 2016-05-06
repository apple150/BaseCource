package dbm;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConnection {
	private Connection connection=null;
	private int numConnection=0;
	private boolean freeConnection=true;
		
	public DBConnection(String driver, String host, String login, String password, int num) {
        if (driver!=null) {        	
			try {
				Class.forName(driver); //com.mysql.jdbc.Driver
			} catch (ClassNotFoundException cnfe) {
				//myLog.AddStrToLogFile("ОШИБКА загрузки драйвера");
				System.out.println("Error loading driver: " +cnfe.toString());
			}
			
			try {
				setConnection((Connection) DriverManager.getConnection(host, login, password)); 
				setNumConnection(num);
				setFreeConnection(true);
			} catch (SQLException e) {
				//myLog.AddStrToLogFile("ОШИБКА подключения к БД");
				System.out.println("Error loading driver: " +e.toString());
			}		
        }		
	}

	public Connection getConnection() {
		return connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	

	public int getNumConnection() {
		return numConnection;
	}

	public void setNumConnection(int numConnection) {
		this.numConnection = numConnection;
	}

	public boolean getFreeConnection() {
		return freeConnection;
	}

	public void setFreeConnection(boolean freeConnection) {
		this.freeConnection = freeConnection;
	}

}
