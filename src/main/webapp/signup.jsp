<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원가입</title>
</head>
<body>

<h2>회원가입</h2>

<form action="${pageContext.request.contextPath}/member/signup" method="post">
  <label for="username">아이디:</label>
  <input type="text" id="username" name="username" required><br>

  <label for="password">비밀번호:</label>
  <input type="password" id="password" name="password" required><br>

  <label for="email">이메일:</label>
  <input type="email" id="email" name="email" required><br>

  <label for="role">역할:</label>
  <select id="role" name="role" required>
    <option value="USER">일반 사용자</option>
    <option value="ADMIN">관리자</option>
  </select><br>

  <button type="submit">가입하기</button>
</form>

</body>
</html>
