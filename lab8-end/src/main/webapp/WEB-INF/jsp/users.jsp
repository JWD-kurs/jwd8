<%@ include file="/WEB-INF/jsp/layout/header.jsp" %>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>ID</th>
			<th>Email</th>
			<th>Password</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${usersModel}" var="user">
			<tr>	
				<td><c:out value="${user.id}" /></td>				
				<td><c:out value="${user.email}" /></td>
				<td><c:out value="${user.password}" /></td>
				<td><c:out value="${user.firstname}" /></td>
				<td><c:out value="${user.lastname}" /></td>
				<td>
					<a href="users/remove/${user.id}">remove</a>
					<a href="users/edit/${user.id}">edit</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<a href="users/add">Add user</a>

<%@ include file="/WEB-INF/jsp/layout/footer.jsp" %>