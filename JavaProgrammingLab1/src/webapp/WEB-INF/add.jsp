<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Add</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/add" method="post">
		First name: <input name="firstName"><br> 
		Last name: <input name="lastName"><br> 
		Date of birth: <input name="date" />"><br>
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