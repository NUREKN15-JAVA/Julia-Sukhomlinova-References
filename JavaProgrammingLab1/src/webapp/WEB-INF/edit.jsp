<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/edit" method="post">
		<input type="hidden" name="id" value="${user.id}"> First name:
		<input name="firstName" value="${user.firstName}"><br>
		Last name: <input name="lastName" value="${user.lastName}"><br>
		Date of birth: <input name="date"
			value="<fmt:formatDate value="${user.date}" type="date" dateStyle="medium"/>"><br>
		<input type="submit" name="okButton" value="Ok">
		<input type="submit" name="cancelButton" value="Cancel">
	</form>
	<c:if test="${requestScope.error != null}">
		<script type="text/javascript">
			alert('${requestScope.error.message}');
		</script>
	</c:if>
</body>
</html>