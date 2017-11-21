<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>User management/Browse</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/browse" method="post">
		<table id=”userTable” border=”1”>
			<tr>
				<th></th>
				<th>First name</th>
				<th>Last name</th>
				<th>Date of birth</th>
			</tr>
			<c:forEach var="user" items="${SessionScope.users}">
				<tr>
					<td><input type=”radio” name=”id” id=”id” value="${user.id}"></td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td><fmt:formatDate value="${user.date}" type="date" dateStyle="medium" /></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" name="addButton" value="Add"> <input
			type="submit" name="editButton" value=Edit> <input
			type="submit" name="deleteButton" value="Delete"> <input
			type="submit" name="detailsButton" value="Details">
	</form>
	<c:if test="${requestScope.error != null}">
		<script type="text/javascript">
			alert('${requestScope.error.message}');
		</script>
	</c:if>
</body>
</html>