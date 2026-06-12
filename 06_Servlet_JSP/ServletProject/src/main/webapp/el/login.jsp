<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 26. 6. 12.
  Time: 오후 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>EL(Expression Language)</h1>
<pre>
		- JSP에서 표현식을 간단하고 효율적으로 작성할 수 있도록 고안된 언어
		  (JSP 기본 내장)

		- Java 값을 HTML 형식으로 표시(출력) 언어

		- 기본 작성 형식 : \${ key }
	</pre>

<hr>

<h3>EL 특징 1 : get이라는 단어를 사용하지 않음</h3>
<pre>
		- 출력 용도의 언어이기 때문에 set이라는 개념이 존재하지 않음
		-> 반대되는 get만 남는데 생략하여 사용
	</pre>

<ul>
    <li>JSP 표현식 : <%= request.getParameter("userid") %></li>
    <li>EL : ${ param.userid }</li>
</ul>

<h1>EL 실습</h1>

    사용자 아이디 : ${param.userid} / ${id}<br>
    사용자 비밀번호 : ${param.passwd} / ${pw}
</body>
</html>
