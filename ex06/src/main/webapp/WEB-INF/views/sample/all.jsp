<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>All</h1>

<sec:authorize access="isAnonymous()">
	<a href="/customLogin">Login</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<a href="/customLogout">Logout</a>
</sec:authorize>
</body>
</html>