<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Expression Example</title>
</head>
<body>
	Current time : <%= new Date() %> <br>
	Random number : <%= Math.random() %> <br>
	Your hostname : <%= request.getRemoteHost() %> <br>
	Your parameter : <%= request.getParameter("yourParameter") %> <br>
	Server : <%= application.getServerInfo() %> <br>
	Session ID : <%= session.getId() %> <br>
</body>
</html>