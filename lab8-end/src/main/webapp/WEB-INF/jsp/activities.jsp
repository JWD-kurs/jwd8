<%@ include file="/WEB-INF/jsp/layout/header.jsp"%>
<h1>Activities</h1>

<table class="table table-bordered">
	<thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${activitiesModel}" var="activity">
			<tr>
				<td><c:out value="${activity.id}" /></td>
				<td><c:out value="${activity.name}" /></td>
				<td><a href="activities/edit/${activity.id}">edit</a> <a
					href="activities/remove/${activity.id}">remove</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<a href="activities/add">Add activity</a>

<%@ include file="/WEB-INF/jsp/layout/footer.jsp"%>