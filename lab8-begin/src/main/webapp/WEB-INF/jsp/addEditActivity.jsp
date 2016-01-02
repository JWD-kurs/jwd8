<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WAFEPA - Add/edit activity</title>
</head>
<body>
	<h1>WAFEPA - Add/edit activity</h1>
	
	<form:form action="/activities" method="post" modelAttribute="activity">
		<form:hidden path="id" />
		
		<label>Name</label>
		<form:input path="name" />
		<button type="submit">Save</button>
	</form:form>
</body>
</html>