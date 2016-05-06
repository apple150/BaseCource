<%@page import="java.sql.ResultSet"%> 
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>

<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="com.mysql.jdbc.Statement"%>

<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=windows-1251"
    pageEncoding="windows-1251" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
<title>This is FirstDBJSP</title>
</head>
<body>
<H1>This is Servlet with JSP</H1>
	
<%
response.setCharacterEncoding("Cp1251");
%>

<TABLE border="1" cellspacing="0" cellpadding="5">
<%
ArrayList<String> array = (ArrayList<String>)request.getAttribute("myArray");
for (int i=0; i<array.size(); i++) {
	%>
	<TR>
		<TD><%= array.get(i) %></TD>							
	<TR>
	<%		
}
%>
</TABLE>

</body>
</html>