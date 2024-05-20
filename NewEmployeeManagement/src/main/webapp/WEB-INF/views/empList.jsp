<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Page</title>
<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;margin-left: auto;
  margin-right: auto; border-radius:10px;}
		.tg td{text-align:center; font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:gray;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:gray;}
	
		body {background-color:olive;}
		h4 a {font-family:Arial, sans-serif;font-size:18px; color:#F21035 ;font-weight:normal; }
		h1,h3 {font-family:Arial, sans-serif;}
	</style>
</head>
<body>
<h1 align="center">Employee List</h1>


<h4 align="left"><a href="addEmployee">Add new Employee</a></h4>

<hr>




<c:if test="${!empty listEmployee}">
<h3 align="center">Employee List</h3>
	<table class="tg">
	
	<tr>
		<th width="80">Employee ID</th>
		<th width="120">Employee Name</th>
		<th width="120">Employee Address</th>
		<th width="120">Employee Phone</th>
		<th width="120">Employee Salary</th>
		<th width="60">Update</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listEmployee}" var="employee">
		<tr>
			<td>${employee.id}</td>
			<td>${employee.name}</td>
			<td>${employee.address}</td>
			<td>${employee.phone}</td>
			<td>${employee.salary}</td>
			<td><a href="<c:url value='/employee/edit/${employee.id}' />" >Update</a></td>
            <td><a href="<c:url value='/employee/remove/${employee.id}' />" >Delete</a></td>

		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>