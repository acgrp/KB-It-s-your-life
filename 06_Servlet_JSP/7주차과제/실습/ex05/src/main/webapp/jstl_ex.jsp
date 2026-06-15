<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 1. JSTL 필수 선언 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL 테스트</title>
</head>
<body>

<h2>JSTL 테스트</h2>
<p>오늘 날짜: <fmt:formatDate value="${today}" pattern="yyyy-MM-dd" /></p>

<%-- 2. 2024. 6. 18. --%>
<fmt:formatDate value="${today}" type="date" /><br>

<%-- 3. 오후 2:16:31 --%>
<fmt:formatDate value="${today}" type="time" /><br>

<%-- 4. 2024. 6. 18. 오후 2:16:31 --%>
<fmt:formatDate value="${today}" type="both" /><br>

<%-- 5. 24. 6. 18. 오후 2시 16분 31초 KST --%>
<fmt:formatDate value="${today}" type="both" dateStyle="short" timeStyle="full" /><br>

<%-- 6. 2024년 6월 18일 오후 2:16 --%>
<fmt:formatDate value="${today}" type="both" dateStyle="long" timeStyle="short" /><br>

<%-- 7. 2024-06-18 14:16:31 (24시간제 정석 포맷) --%>
<fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm:ss" /><br>

<%-- 8. 2024-06-18 오후 02:16:31 (오전/오후 분리 포맷) --%>
<fmt:formatDate value="${today}" pattern="yyyy-MM-dd a hh:mm:ss" /><br>

<c:choose>
    <c:when test="${role eq 'ADMIN'}">
        <p>관리자</p>
    </c:when>
    <c:otherwise>
        <p>일반 회원</p>
    </c:otherwise>
</c:choose>

<table>
    <c:forEach var="member" items="${members}" varStatus="status">
        <tr>
            <td>${status.index}</td>
            <td>${member.name}</td>
            <td>${member.id}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>