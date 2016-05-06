<%@page import="data.PageData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="pagedata" class="data.PageData" scope="request"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><jsp:getProperty name="pagedata" property="title" /></title>
</head>
<body>
<table width="100%"  cellspacing="0" cellpadding="10">
<tr><td height="100" bgcolor="#99ff99">
<h1>Site Header</h1>
</td></tr>
<tr><td>
<table width="100%">
<tr>
<td width="300" bgcolor="#eeeeee">
<%= request.getAttribute("pagemenu") %>

</td>
<td>
<jsp:getProperty property="maintext" name="pagedata"/>
</td>

</tr>

</table>

</td></tr>

</table>

<%-- 
<%= request.getAttribute("pageid") %>
<%= request.getAttribute("pagedata") %>--%>

</body>
</html>