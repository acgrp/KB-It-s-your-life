<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1> index라는 이름이 붙은 파일은 메인 페이지 역할을 한다.</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<hr>

<pre>
    form 태그 : 내부에 작성된 input 태그의 값을 지정된 서버 또는 페이지로 제출(전달)하는 역할
    </pre>

<form action="/example1" method="get">

    이름 : <input type="text" name="name"> <br>
    나이 : <input type="text" name="age"> <br>

    <button type="submit">서버로 제출하기</button>
</form>
</body>
</html>