<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="dto.GameRecordDto" %>
<%@ page import="dto.UserDto" %>
<!DOCTYPE html>
<html>
<head>
    <title>전적 목록</title>
</head>
<body>
<%
    UserDto loginUser = (UserDto) request.getAttribute("loginUser");
%>
<h2><%= loginUser.getUsername() %>님의 전적 목록</h2>

<a href="/record/save">+ 전적 추가</a> |
<a href="/logout">로그아웃</a>

<hr/>

<%
    List<GameRecordDto> records = (List<GameRecordDto>) request.getAttribute("records");
    if (records == null || records.isEmpty()) {
%>
<p>아직 기록된 전적이 없습니다.</p>
<% } else { %>
<table border="1">
    <tr>
        <th>챔피언</th>
        <th>결과</th>
        <th>킬</th>
        <th>데스</th>
        <th>어시</th>
        <th>메모</th>
        <th>날짜</th>
        <th>삭제</th>
    </tr>
    <%
        for (GameRecordDto record : records) {
    %>
    <tr>
        <td><%= record.getChampion() %></td>
        <td><%= record.getResult() %></td>
        <td><%= record.getKills() %></td>
        <td><%= record.getDeaths() %></td>
        <td><%= record.getAssists() %></td>
        <td><%= record.getMemo() %></td>
        <td><%= record.getPlayedAt() %></td>
        <td>
            <form action="/record/delete" method="post">
                <input type="hidden" name="recordId" value="<%= record.getId() %>"/>
                <button type="submit">삭제</button>
            </form>
        </td>
    </tr>
    <% } %>
</table>
<% } %>
</body>
</html>