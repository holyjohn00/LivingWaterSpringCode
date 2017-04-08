<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="<c:url value="/resources/js/jquery-1.10.1.min.js" />"></script>
<script src="<c:url value="/resources/js/common.js" />"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	UPDATE
	<form id="updateUserForm">
		<table>
			<input type="hidden" name="userId" value="${user.userid}" />
			<tr>
				<td>User ID:</td>
				<td>${user.userid}</td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName" value="${user.firstName}" /></td>
			</tr>
			<tr>
				<td>Family Name:</td>
				<td><input type="text" name="familyName" value="${user.familyName}" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value="${user.email}" /></td>
			</tr>
		</table>
		<button type="button" onclick="changeFormActionAndSubmit('updateUserForm','${context}/users/updateUser','POST')">Update</button>
		<button type="button" onclick="changeFormActionAndSubmit('updateUserForm','${context}/users/','POST')">Cancel</button>
	</form>
</body>
</html>