<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${role eq 'ADMIN'}">
    <p>관리자</p>
</c:if>

<c:if test="${role ne ADMIN}
${requestScope.members}
</body>
</html>
</jsp:root>