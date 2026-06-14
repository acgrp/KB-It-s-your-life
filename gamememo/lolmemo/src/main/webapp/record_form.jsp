<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>전적 입력</title>
</head>
<body>
<h2>전적 입력</h2>

<% String error = (String) request.getAttribute("error");
    if (error != null) { %>
<p style="color:red;"><%= error %></p>
<% } %>

<form action="/record/save" method="post">
    <label>챔피언: <input type="text" name="champion"/></label><br/>
    <label>결과:
        <select name="result">
            <option value="WIN">승리</option>
            <option value="LOSE">패배</option>
        </select>
    </label><br/>
    <label>킬: <input type="number" name="kills" value="0"/></label><br/>
    <label>데스: <input type="number" name="deaths" value="0"/></label><br/>
    <label>어시: <input type="number" name="assists" value="0"/></label><br/>
    <label>메모: <input type="text" name="memo"/></label><br/>
    <button type="submit">저장</button>
</form>

<a href="/record/list">전적 목록으로</a>
</body>
</html>