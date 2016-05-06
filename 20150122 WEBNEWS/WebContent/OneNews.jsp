<%@page import="dto.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="mynews" class="dto.News" scope="session"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
<title>One Been News</title>
</head>
<body>
<%
response.setCharacterEncoding("Cp1251");
%>
<H2>НОВОСТНОЙ ПОРТАЛ News.by</H2>

<%= session.getAttribute("mynews") %>

<TABLE border="1" cellspacing="0" cellpadding="5">
	<TR>
		<TD><%--<jsp:getProperty name="mynews" property="id">--%></TD>
		<TD><%--<jsp:getProperty name="mynews" property="category">--%></TD>
		<TD><%--<jsp:getProperty name="mynews" property="title">--%></TD>
		<TD><%--<jsp:getProperty name="mynews" property="title">--%></TD>	
	<TR>
</TABLE>
</body>
</html>