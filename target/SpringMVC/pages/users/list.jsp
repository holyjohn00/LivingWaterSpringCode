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

	<form id="searchUsersForm">
		<table>
			<tr>
				<td>User ID:</td>
				<td><input type="text" name="userId" /></td>
				<td>First Name:</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>Family Name:</td>
				<td><input type="text" name="familyName"></td>
				<td>Email:</td>
				<td><input type="text" name="email" /></td>
			</tr>
		</table>
		<button type="button" onclick="changeFormActionAndSubmit('searchUsersForm','${context}/users/searchUsers','POST')">Search</button>
		<button type="button" onclick="changeFormActionAndSubmit('searchUsersForm','${context}/users/','POST')">Clear</button>
	</form>


	<c:if test="${not empty userList}">

		<form action="${context}/users/deleteUsers" method="POST" id="listUsersForm">
			<table>
				<th></th>
				<th>User Id</th>
				<th>First Name</th>
				<th>Family Name</th>
				<th>Email</th>
				<c:forEach var="user" items="${userList}">
					<tr>
						<td><input type="checkbox" name="userIds" value="${user.userid}" /></td>
						<td><a href="${context}/users/loadUpdate?userId=${user.userid}">${user.userid}</a></td>
						<td>${user.firstName}</td>
						<td>${user.familyName}</td>
						<td>${user.email}</td>
					</tr>
				</c:forEach>
			</table>
			<button type="button" onclick="changeFormActionAndSubmit('listUsersForm','${context}/users/deleteUsers','POST')">Delete</button>
			<button type="button" onclick="changeFormActionAndSubmit('listUsersForm','${context}/users/loadInsert','POST')">Insert User</button>
		</form>
	</c:if>
</body>
</html>