<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<% String jdkj="jkdshfjkdh"; %>
<%= jdkj%>

<!--declare variable  -->
<c:set var="name" value="Aphay"></c:set>
<c:out value="${name}"></c:out>


<c:set var="age" value="17"></c:set>

<c:out value="${age}"></c:out>


<!-- one way condition  -->
<c:if test="${age>=18}">
Adult
</c:if>


<!-- two way conditions -->
<c:choose>
 <c:when test="${age<=17 }">You are still young.</c:when>
</c:choose>
</body>
</html>