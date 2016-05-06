import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Test {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/payments";
			String user="root";
			String pass=""; 
			//pass="1234";
			pass="";
			Connection myConnection = null;
			try {
				myConnection = (Connection) DriverManager.getConnection(dbURL, user, pass);
				Statement statement = (Statement) myConnection.createStatement();
				String query = "";
				int i=8;
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
				String rez="";
				while (result.next()) {
					switch (i) {
						case 1:  rez=rez+result.getString(1)+'\t'+result.getString(2)+'\n'; break;
						case 2:  rez=rez+result.getString(1)+'\t'+result.getString(2)+'\n'; break;
						case 3:  rez=rez+result.getString(1)+'\t'+result.getString(2)+'\n'; break;
						case 4:  rez=rez+result.getString(1)+'\t'+result.getString(2)+'\t'+result.getString(3)+'\t'+result.getString(4)+'\t'+result.getString(5)+'\n'; break;
						case 5:  rez=rez+result.getString(1)+'\t'+result.getString(2)+'\t'+result.getString(3)+'\t'+result.getString(4)+'\t'+result.getString(5)+'\n'; break;
						case 6:  rez=rez+result.getString(1)+'\t'+result.getString(2)+'\n'; break;
						case 7:  rez=rez+result.getString(1)+'\t'+result.getString(2)+'\n'; break;
						case 8:  rez=rez+result.getString(1); break;
					}
				}
				System.out.println("i="+i);
				System.out.println(query);
				System.out.println(rez);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Error "+e);
		}
	}
}