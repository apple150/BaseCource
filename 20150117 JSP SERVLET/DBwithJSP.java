

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class DBwithJSP
 */

/**
* @WebServlet("/DBwithJSP")
*/

public class DBwithJSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection connection=null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("Hello!!!");
		config = getServletConfig();
		String dbURL = config.getInitParameter("dbURL");
		String user = config.getInitParameter("user");
		String password = config.getInitParameter("password");
		//System.out.println(dbURL+",  "+user+",  "+password);
		try {
			Class.forName("com.mysql.jdbc.Driver");			
			connection = (Connection) DriverManager.getConnection(dbURL, user, password);			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}			
	}
	
    /**
     * Default constructor. 
     */
    public DBwithJSP() {
    	// TODO Auto-generated method stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Statement statement = (Statement) connection.createStatement();
			String query = "";
			int i=6;
			switch (i) {
				//1  Вывести список получателей платежей и сумму платежей по каждому из них
				case 1: query = "SELECT name, (SELECT SUM(value) FROM expenses WHERE receiver=rs.num) FROM receivers rs GROUP BY name"; break;
				//2  Вывести сумму платежей за тот день когда был наибольший платеж
				case 2: query = "SELECT SUM(value) AS sum, paydate FROM expenses WHERE paydate = "
						+ "(SELECT paydate FROM expenses WHERE value = (SELECT MAX(value) FROM expenses))"; break;
				//3  Вывести наибольший платеж за тот день когда сумма платежей была наибольшей
				case 3: query = "SELECT MAX(value) AS max, paydate FROM expenses WHERE paydate = "
						+ "(SELECT paydate FROM (SELECT paydate, SUM(value) AS sum FROM expenses GROUP BY paydate) q1 WHERE sum = "
						+ "(SELECT MAX(sum) FROM (SELECT SUM(value) AS sum FROM expenses GROUP BY paydate) q2))"; break;
				//4  Показать все что есть в базе
				case 4: query ="SELECT ex.num, paydate, value, receiver, name FROM expenses ex, receivers rs WHERE receiver=rs.num"; break;
				//5  Показать платежи за конкретную дату
				case 5: query="SELECT ex.num, paydate, value, receiver, name FROM expenses ex, receivers rs WHERE receiver=rs.num AND paydate='2015-01-06'"; break;
				//6  Показать все магазины
				case 6: query="SELECT * FROM receivers"; break;
				case 7: query="SELECT * FROM receivers WHERE num=5"; break;
				//Показывает максимальное значение первичного ключа в таблице 
				case 8: query="SELECT MAX(num) AS max FROM receivers"; break;
			}
			ResultSet result = statement.executeQuery(query);
			ArrayList<String> array = new ArrayList<String>();
			if (result!=null) {
				//ArrayList<String> array = new ArrayList<String>();
				String temp="";
				while (result.next()) {
					temp="";
					temp=result.getString(1)+","+result.getString(2);
					array.add(temp);					
				}				
			}	
			ServletContext context  = getServletContext();
			RequestDispatcher dispatcher  = context.getRequestDispatcher("/Second.jsp");
			request.setAttribute("myArray", array);
			dispatcher.forward(request, response);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
