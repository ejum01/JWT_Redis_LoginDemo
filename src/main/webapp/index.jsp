<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
</head>
<body>

<h1>Welcome to My Website</h1>

<div>
    <h2>회원가입 및 로그인</h2>
    <button type="button" class="index-button btn btn-primary mt-4" onclick="location.href='${pageContext.request.contextPath}/member/signup';">회원가입</button>
    <button type="button" class="index-button btn btn-primary mt-4" onclick="location.href='${pageContext.request.contextPath}/member/login';">로그인</button>
</div>

</body>
</html>
