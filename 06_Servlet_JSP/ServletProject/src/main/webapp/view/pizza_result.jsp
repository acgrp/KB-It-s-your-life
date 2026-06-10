<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--

<%@ %> : 지시자 태그(페이지 정의)
	"charset=UTF-8" : 현재 문서가 UTF-8 문자 인코딩 형식으로 작성되어 있음
	pageEncoding="UTF-8" : 현재 문서를 해석할 때 UTF-8 문자 인코딩을 이용해서 해석

	<% %> : 스크립틀릿(scriptlet) : JSP에서 자바 코드를 작성할 수 있는 영역
	-> JSTL 라이브러리를 이용해서 태그 형식으로 변경

	<%= %> : 표현식(Expression) : 자바 코드의 값을 HTML 형식으로 표현(출력)
	-> EL(Expression Language)을 이용해서 간단하게 값을 출력

--%>

<% // 자바 코드 작성 영역(scriptlet, 스크립틀릿)
    String pizza = request.getParameter("pizza");
    String size = request.getParameter("size");
    int amount = Integer.parseInt(request.getParameter("amount"));

    // JSP에서 만든 변수 꺼내기

    String pizzaName = (String) request.getAttribute("pizzaName");
    int price = (int) request.getAttribute("price");
%>
<html>
<head>
    <title>피자 주문 결과</title>
</head>
<body>

<h1>피자 주문 결과</h1>
<ul>
    <li>피자 : <%= pizzaName %>
    </li>
    <li>사이즈 : <%= size.equals("L") ? "라지" : "레귤러"%>
    </li>
    <li>수량 : <%= amount %>
    </li>
    <li>합계 : <%= price %>원</li>
</ul>

</body>
</html>
