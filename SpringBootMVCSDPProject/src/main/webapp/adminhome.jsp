<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
</head>
<body>
<%@include file="adminnavbar.jsp" %>
<h2>welcome <c:out value="${a.username}"/></h2>
<p>no of employees <c:out value="${count}"/> </p>


</body>
</html>