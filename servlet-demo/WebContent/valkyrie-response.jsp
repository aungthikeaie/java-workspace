<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
     <%@ page import="com.code2.Hero" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>${param.name}</p>
<p>${param.email}</p>

<p>${Vname }</p>

<!--  <p>request.getAttribute("heroList")</p>-->

<p>${heroList}</p>

<ul>
<c:forEach var="tempList" items="${heroList}">
 <li>${tempList.name}</li>
 <li>${tempList.email}</li>

</c:forEach>
</ul>




</body>
</html>