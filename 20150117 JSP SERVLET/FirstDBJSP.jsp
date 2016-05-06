<%@page import="java.sql.ResultSet"%> 
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>

<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="com.mysql.jdbc.Statement"%>

<%@ page language="java" contentType="text/html; charset=windows-1251"
    pageEncoding="windows-1251" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
<title>This is FirstDBJSP</title>
</head>
<body>
<H1>This is FirstDBJSP</H1>
<%!
public Connection connection=null;
public void jspInit() {
	try {
		String dbURL = "jdbc:mysql://localhost:3306/payments";
		String user="root";
		String password="1234";		
		Class.forName("com.mysql.jdbc.Driver");			
		connection = (Connection) DriverManager.getConnection(dbURL, user, password);
		//System.out.println("Connection ok");
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
%>
	
<%
response.setCharacterEncoding("Cp1251");
%>

<TABLE border="1" cellspacing="0" cellpadding="5">
<%
	try {
		Statement statement = (Statement) connection.createStatement();
		String query = "";
		query="SELECT * FROM receivers";
		ResultSet result = statement.executeQuery(query);
		if (result!=null) {
			while (result.next()) {
				%>
				<TR>
					<TD><%= result.getString(1) %></TD>
					<TD><%= result.getString(2) %></TD>					
				<TR>
				<%	
			}		
		}
	} catch (SQLException e) {	
		e.printStackTrace();
	}
%>
</TABLE>

</body>
</html>