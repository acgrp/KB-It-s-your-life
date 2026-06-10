<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>getParameterValues 실습</title>
</head>
<body>

<h1>getParameterValues 실습</h1>

  <form action="sports" method="post">

    <fieldset style="width: 300px;">

      <legend>좋아하는 운동 및 성별</legend>
      <br>

      야구 <input type="checkbox" name="sports" value="야구">
      축구 <input type="checkbox" name="sports" value="축구">
      농구 <input type="checkbox" name="sports" value="농구">
      <br>
      남 <input type="radio" name="sex" value="남" checked>
      여 <input type="radio" name="sex" value="여">
      <br>
      <input type="submit" value="전송"></input>
    </fieldset>
  </form>

</body>
</html>
