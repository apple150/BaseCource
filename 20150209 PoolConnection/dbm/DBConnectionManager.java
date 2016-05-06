package dbm;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import log.Logger;

import com.mysql.jdbc.Connection;

public class DBConnectionManager {
	private static DBConnectionManager dbcm = null;
	
	private static String curDir = null;
	private static int countConnection=0;
	private static String driver = null; 	//"com.mysql.jdbc.Driver"; 
	private static String host = null; 		//"jdbc:mysql://localhost:3306/webnews";
	private static String login = null; 	//"root";
	private static String password = null; 	//"";
	private static String nameConfigFile = null; 	//Название фала настройки параметров подключения к БД	
	private List<DBConnection> arrayList = null;

	private static Logger myLog = null; //Выносим объект Logger в глобальную переменную
	
	/**
	 * Т.к. ШП SINGLETON то конструктор обязательно должен быть private
	 */
	private DBConnectionManager(int countConnection) {
		myLog = Logger.getLogger("");
		this.countConnection = countConnection;
		curDir = new File("").getAbsolutePath();
		getConfigProperties();
		downloadConnection();
	}
	
	/**
	 * Создается статический метод возвращающий объект на этот же класс
	 * если объект будет одновременно ипользоваться в разных потоках, то
	 * объявление метода необходими будет сделать таким образом:
	 *   public static synchronized MyDao getDao()
	 * но надо помнить что синхронизация замедляет работу
	 */
	public static synchronized DBConnectionManager getDBConnectionManager(int countConnection) {
		if (dbcm == null) {
			dbcm = new DBConnectionManager(countConnection); 
			myLog.AddStrToLogFile("The object DBConnectionManager was created");
		}
		return dbcm;
	}
	
	
	public void getConfigProperties() {
		if (curDir!=null) {			
			nameConfigFile = curDir+"//src//dbm//config.properties";
			myLog.AddStrToLogFile("Config file adress: "+nameConfigFile);
			FileInputStream fis=null;
			Properties property = new Properties();
			try {
				fis = new FileInputStream(nameConfigFile);
				property.load(fis);
				
	            driver = property.getProperty("driver");
	            host = property.getProperty("host");
	            login = property.getProperty("login");
	            password = property.getProperty("password");
	            
	            myLog.AddStrToLogFile("driver: 	"+driver);
	            myLog.AddStrToLogFile("host: 	"+host);
	            myLog.AddStrToLogFile("login: 	"+login);
	            myLog.AddStrToLogFile("password: "+password);
			} catch (IOException e) {
	        	myLog.AddStrToLogFile("Config file not exist !!!");
	        }				
		}
	}
	
	public void downloadConnection() {
		arrayList = new ArrayList<DBConnection>();
		DBConnection dbcon = null;
		Connection connection = null;
		
		/**
		 * Pack ArrayList with Connection
		 */
		for (int i=0; i<countConnection; i++) {
			dbcon = null; 	dbcon = new DBConnection(driver, host, login, password, i);						
			connection = null; 	connection = dbcon.getConnection();
			if (connection!=null) {
				arrayList.add(dbcon);
				myLog.AddStrToLogFile("Connection is true - "+i);
			} else {
				myLog.AddStrToLogFile("Connection is null");
			}
		}		
	}
	
	/**
	 * Get Coonection from Stack (arrayList<DBConnection>)
	 * @return DBConnection
	 */
	public DBConnection getConnection() {
		DBConnection dbc = null;
		for (int i=0; i<arrayList.size(); i++) {
			if (arrayList.get(i).getFreeConnection()==true) {
				arrayList.get(i).setFreeConnection(false);
				dbc=arrayList.get(i);
				break;
			}
		}
		return dbc;
	}
	
	/**
	 * Return Connection in Stack
	 * @param dbc
	 */
	public void returnConnection(DBConnection dbc) {
		int i=dbc.getNumConnection();
		if (arrayList.get(i)!=null) {
			arrayList.get(i).setFreeConnection(true);
		}
	}
}
