<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope 내장 객체와 범위</title>
</head>
<body>

<h1>Servlet/JSP 내장 객체와 범위</h1>
<pre>
		Servlet/JSP에는 4종류 범위를 나타내는 내장 객체가 존재한다!
		-> 각 종류마다 영향을 끼치는 범위가 달라짐

		<h4>1. page : 현재 페이지</h4>
		-> 현재 JSP에서만 사용 가능한 객체(Servlet X)

		<h4>2. request</h4>
		-> 요청 받은 페이지(Servlet/JSP)와
		   위임 받은 페이지(Servlet/JSP)에서 유지되는 객체

		<h4>3. session</h4>
		- session : 서버에 접속한 클라이언트를 나타내거나,
					관련 정보를 get/set 할 수 있는 객체
					(session 객체는 서버에서 관리함)

		- [중요] session은 브라우저 마다 하나씩 생성된다!

		-> 유지범위 : 사이트 접속 ~ 브라우저 종료 | 세션 만료

		<h4>4. application</h4>
		- 하나의 웹 애플리케이션 마다 1개만 생성되는 객체
		  (Server를 키면 1개만 생성되는 객체)

		- application 객체는 어디서든 사용 가능

		-> 유지 범위 : 서버 실행 ~ 서버 종료
	</pre>

<hr>

<% // 스크립틀릿 : JSP에서 Java 코드를 작성하는 영역
	pageContext.setAttribute("pageMessage", "pagescope입니다.");
	String requestMessage = (String) request.getAttribute("requestMessage");
	String sessionMessage = (String) session.getAttribute("sessionMessage");
	String applicationMessage = (String) application.getAttribute("applicationMessage");

%>

<h1>내장 객체 확인</h1>

<ul>

	<li>page : ${pageMessage}</li>
<%--	<li>request : <%= requestMessage %></li>--%>
	<%-- el 표현식으로 작성 ---%>
	<li>request : ${requestScope}</li>
	<li>session : <%= sessionMessage %></li>
	<li>application : <%= applicationMessage %></li>
	<li><a href="scopeCheck">scope 확인하기</a> </li>

</ul>

</body>
</html>