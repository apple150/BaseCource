import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class MyDao implements Dao  {
	private static MyDao inst;
	
	public String dbURL = "jdbc:mysql://localhost:3306/payments";
	public String user="root";
	public String pass=""; 
	//public String pass="1234";
	
	
	//public ResultSet result=null;
	
	public static MyDao getDao() {
		if (inst == null) {
			inst = new MyDao(); 
		}
		return inst;
	}
	
	@Override
	public Receiver getReceiver(int num) {
		Receiver oneReceiver = null;
		ResultSet result=null;
		String query="SELECT * FROM receivers WHERE num="+num;		
		result=GetQuery(query);
		if (result != null) {
			oneReceiver = AddResultSetToReceiver(result);
		}
		return oneReceiver;
	}
	
	/**
	 * Получает значения массива Receiver (Получателей или Магазинов)
	 */
	@Override
	public ArrayList<Receiver> getReceivers() {
		ArrayList<Receiver> mas = null;
		ResultSet result=null;
		String query="SELECT * FROM receivers";		
		result=GetQuery(query);
		if (result != null) {
			mas = AddResultSetToArrayReceiver(result);
		}
		return mas;
	}
	
	/**
	 * Показывает массив Receiver (Получателей или Магазинов)
	 * @param mas
	 */
	public void ShowArrayListReceiver(ArrayList<Receiver> mas) {
		if (mas != null) {
			for(int i=0; i<mas.size(); i++) {
				System.out.println(mas.get(i).toString());			
			}		
		}
	}

	@Override
	public Expense getExpense(int num) {
		Expense oneExpense = null;
		ResultSet result=null;
		String query="SELECT * FROM expenses WHERE num="+num;		
		result=GetQuery(query);
		if (result != null) {
			oneExpense = AddResultSetToExpense(result);
		}
		return oneExpense;		
	}
	
	/**
	 * Получает значения массива Expense (Всех Платежей)
	 */		
	@Override
	public ArrayList<Expense> getExpenses() {
		ArrayList<Expense> mas = null;
		ResultSet result=null;
		String query="SELECT * FROM expenses";		
		result=GetQuery(query);
		if (result != null) {
			mas = AddResultSetToArrayExpense(result);
		}
		return mas;
	}

	/**
	 * Показывает массив Receiver (Получателей или Магазинов)
	 * @param mas
	 */
	public void ShowArrayListExpense(ArrayList<Expense> mas) {
		if (mas != null) {
			for(int i=0; i<mas.size(); i++) {
				System.out.println(mas.get(i).toString());			
			}		
		}
	}
	
	@Override
	public int addReceiver(Receiver receiver) {
		int ret = 0;
		ResultSet result=null;		
		String query="SELECT MAX(num) AS max FROM receivers";		
		result=GetQuery(query);
		int i=0;
		if (result != null) {
			i = GetPrimaryKey(result);
		}
		if (i!=0) {
			i++;
			receiver.setNum(i);
		}
		String queryAdd="INSERT INTO receivers VALUE("+receiver.getNum()+", '"+receiver.getName()+"')";
		ret = ChangeQuery(queryAdd);
		//System.out.println(receiver.toString());
		return ret;
	}
	
	public int GetPrimaryKey(ResultSet result) {
		int ret=0;
		if (result!= null) {			
			try {			
				while (result.next()) {					
					ret=Integer.parseInt(result.getString(1));
				}			
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}		
		return ret;
	}

	@Override
	public int addExpense(Expense expense) {
		int ret = 0;
		ResultSet result=null;		
		String query="SELECT MAX(num) AS max FROM expenses";		
		result=GetQuery(query);
		int i=0;
		if (result != null) {
			i = GetPrimaryKey(result);
		}
		if (i!=0) {
			i++;
			expense.setNum(i);
		}
		String queryAdd="INSERT INTO expenses VALUE("+expense.getNum()+", '"+expense.getPaydate()+"', "+expense.getReceiver()+", "+expense.getValue()+")";
		ret = ChangeQuery(queryAdd);
		//System.out.println(expense.toString());
		return ret;		
	}
	
	/** 
	 * Процедура выводит ResultSet на консоль
	 * @return Resultset
	 */	
	public void OutResult(ResultSet result) {
		if (result!=null) {
			try {
				String rez="";			
				while (result.next()) {
					rez=rez+result.getString(1)+'\t'+result.getString(2); break;
				}
				System.out.println(rez);			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/** 
	 * Процедура отрабатывает переданный SQL (по изменению) и возвращает ResultSet
	 * @return Resultset
	 */
	public int ChangeQuery(String query) {
		int result=0;
		System.out.println("\t SQL:\t"+query);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/*
			String dbURL = "jdbc:mysql://localhost:3306/payments";
			String user="root";
			String pass=""; 
			//pass="1234";			
			pass="";
			 */
			Connection myConnection = null;
			try {
				myConnection = (Connection) DriverManager.getConnection(dbURL, user, pass);
				Statement statement = (Statement) myConnection.createStatement();
				result = statement.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;		
	}
	
	/** 
	 * Процедура отрабатывает переданный SQL (по чтению) и возвращает ResultSet
	 * @return Resultset
	 */
	public ResultSet GetQuery(String query) {
		System.out.println("\t SQL:\t"+query);
		ResultSet result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/*
			String dbURL = "jdbc:mysql://localhost:3306/payments";
			String user="root";
			String pass=""; 
			//pass="1234";
			pass="";
			*/
			Connection myConnection = null;
			try {
				myConnection = (Connection) DriverManager.getConnection(dbURL, user, pass);
				Statement statement = (Statement) myConnection.createStatement();
				result = statement.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;		
	}
	
	/** 
	 * Процедура заполняет объект класса Receiver (Получатели или Магазины) данными из ResultSet
	 * @return Receiver
	 */	
	public Receiver AddResultSetToReceiver(ResultSet result) {
		Receiver oneReceiver = null;
		if (result!= null) {			
			try {
				//String rez="";			
				while (result.next()) {
					oneReceiver = new Receiver(); //Создание нового объекта
					oneReceiver.setNum(Integer.parseInt(result.getString("num")));
					oneReceiver.setName(result.getString("name"));
					//rez=rez+result.getString(1)+'\t'+result.getString(2); break;
				}
				//System.out.println(rez);			
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return oneReceiver;
	}

	
	public ArrayList<Receiver> AddResultSetToArrayReceiver(ResultSet result) {
		ArrayList<Receiver> mas= new ArrayList<Receiver>();
		if (result!=null) {
			try {			
				while (result.next()) {
					Receiver oneReceiver = new Receiver(); //Создание нового объекта
					oneReceiver.setNum(Integer.parseInt(result.getString("num")));
					oneReceiver.setName(result.getString("name"));
					mas.add(oneReceiver);
				}			
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return mas;
	}
		
	/** 
	 * Процедура заполняет объект класса Expense (Платежи) данными из ResultSet
	 * @return Expense
	 */		
	public Expense AddResultSetToExpense(ResultSet result) {
		Expense oneExpense = null;
		if (result!= null) {			
			try {			
				while (result.next()) {
					oneExpense = new Expense(); //Создание нового объекта
					oneExpense.setNum(Integer.parseInt(result.getString("num")));
					oneExpense.setPaydate(result.getString("paydate"));
					oneExpense.setReceiver(Integer.parseInt(result.getString("receiver")));
					oneExpense.setValue(Integer.parseInt(result.getString("value")));					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return oneExpense;
	}
	
	public ArrayList<Expense> AddResultSetToArrayExpense(ResultSet result) {
		ArrayList<Expense> mas= new ArrayList<Expense>();
		if (result!=null) {
			try {			
				while (result.next()) {
					Expense oneExpense = new Expense(); //Создание нового объекта
					oneExpense.setNum(Integer.parseInt(result.getString("num")));
					oneExpense.setPaydate(result.getString("paydate"));
					oneExpense.setReceiver(Integer.parseInt(result.getString("receiver")));
					oneExpense.setValue(Integer.parseInt(result.getString("value")));					
					mas.add(oneExpense);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return mas;
	}

	@Override
	public int delReceiver(Receiver receiver) {		
		int ret = 0;
		String queryAdd="DELETE FROM receivers WHERE name='"+receiver.getName()+"'";
		ret = ChangeQuery(queryAdd);
		System.out.println(receiver.toString());
		return ret;
	}

	@Override
	public int delExpense(Expense expense) {
		int ret = 0;
		String queryAdd="DELETE FROM expenses WHERE value="+expense.getValue();
		ret = ChangeQuery(queryAdd);
		System.out.println(expense.toString());
		return ret;
	}
	
}
