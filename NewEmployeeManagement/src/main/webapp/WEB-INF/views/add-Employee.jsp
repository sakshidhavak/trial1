<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <style type ="text/css">
    body {
	background-color: olive;
}
h1{
font-family:cursive, sans-serif;
}
    
    </style>
    <title>Add Employee</title>
</head>
<body>
    <h1>Add New Employee</h1>
    <form:form action="${pageContext.request.contextPath}/employee/processAddEmployee" method="post" modelAttribute="employee">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" placeholder="Enter name" required><br><br>
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" placeholder="Enter address" required><br><br>
        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" placeholder="Enter phone no." required><br><br>
        <label for="salary">Salary:</label>
        <input type="number" id="salary" name="salary" placeholder="Enter salary" required><br><br>
        <input type="submit" value="Submit">
    </form:form>
</body>
</html>