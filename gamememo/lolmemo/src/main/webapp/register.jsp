<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<h2>회원가입</h2>

<!-- 에러 메시지 출력 -->
<% String error = (String) request.getAttribute("error");
    if (error != null) { %>
<p style="color:red;"><%= error %></p>
<% } %>

<form action="/register" method="post">
    <label>아이디: <input type="text" name="username"/></label><br/>
    <label>비밀번호: <input type="password" name="password"/></label><br/>
    <button type="submit">가입하기</button>
</form>

<a href="/login.jsp">이미 계정이 있으신가요? 로그인</a>
</body>
</html>