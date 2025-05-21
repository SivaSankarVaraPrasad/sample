<%@page import="com.klef.jfsd.springboot.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
	Employee emp = (Employee) session.getAttribute("employee");
	if(emp==null){
		response.sendRedirect("empsessionexpiry");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Home</title>
</head>
<body>
<%@include file="empnavbar.jsp" %>

<h2>welcome <%=emp.getName() %></h2>
</body>
</html>