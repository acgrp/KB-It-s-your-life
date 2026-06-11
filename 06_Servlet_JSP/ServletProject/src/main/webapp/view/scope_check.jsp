<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<% // 스크립틀릿 : JSP에서 Java 코드를 작성하는 영역
  String requestMessage = (String) request.getAttribute("requestMessage");
  String sessionMessage = (String) session.getAttribute("sessionMessage");
  String applicationMessage = (String) application.getAttribute("applicationMessage");

%>

<h1>내장 객체 확인</h1>

<ul>

  <li>page : </li>
  <li>request : <%= requestMessage %></li>
  <li>session : <%= sessionMessage %></li>
  <li>application : <%= applicationMessage %></li>

</ul>
</body>
</html>
