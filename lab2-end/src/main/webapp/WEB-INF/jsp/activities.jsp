<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WAFEPA - Activities</title>
</head>
<body>
	<h1>WAFEPA - Activities</h1>
	<c:out value="${activitiesCount}"></c:out>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${activitiesModel}" var="activity">
			<tr>
				<td><c:out value="${activity.id}"></c:out></td>
				<td><c:out value="${activity.name}"></c:out></td>
				<td></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>