<%@ include file="/WEB-INF/jsp/layout/header.jsp" %>

<h1>WAFEPA - Add/Edit user</h1>

<c:url value="/users" var="usersUrl" />

<form:form action="${usersUrl}" method="post" modelAttribute="user">
	<fieldset>
		<form:hidden path="id"/>
		<form:label path="email">Email</form:label>
		<form:input path="email" />
		<br />
		
		<form:label path="password">Password</form:label>
		<form:input path="password" />
		<br />
		
		<form:label path="firstname">First name</form:label>
		<form:input path="firstname" />
		<br />
		
		<form:label path="lastname">Last name</form:label>
		<form:input path="lastname" />
		<br />
	</fieldset>
	<p><button type="submit">Submit</button></p>
</form:form>

<%@ include file="/WEB-INF/jsp/layout/footer.jsp" %>