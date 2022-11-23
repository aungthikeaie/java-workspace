<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
String name = "mama";
out.println("<h1>"+name+"</h1>");%>

<%= name %>
<ul>
<%
	String[] fruits = {"apple","orange","banana"};

	for(String tempfru:fruits){
		out.println("<li>"+tempfru+"</li>");
	}
%>
</ul>

<%! public String getStudent(){
	String name = "koko";
	return name;
}%>

<% String method = getStudent();
out.println(method);
%>


</body>
</html>