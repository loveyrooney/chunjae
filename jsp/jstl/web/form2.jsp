<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-11
  Time: 오전 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    param: request.getParameter("aa"); ${param.aa}
    paramValues(배열로 받는다): request.getParameterVaues("aa"); ${paramValues.aa[i]}
    header : request.getHeader('t'); ${Header.t}
--%>
<form method="post" action="result2.jsp">
  <label for="id">아이디</label>
  <input type="text" id="id", name="id"><br>
  <label for="pwd">패스워드</label>
  <input type="password" id="pwd", name="pwd"><br>
  <label for="name">이름</label>
  <input type="text" id="name", name="name"><br>
  <label for="addr">주소</label>
  <select name="addr" id="addr">
    <option value="서울">서울</option>
    <option value="경기">경기</option>
    <option value="강원">강원</option>
  </select><br>
  <label>성별</label>
  <input type="radio" id="female" name="gender" value="여자" checked>
  <label for="female">여자</label>
  <input type="radio" id="male" name="gender" value="남자">
  <label for="male">남자</label><br>
  <label>좋아하는 음식</label>
  <input type="checkbox" id="piz", name="favorite" value="피자">
  <label for="piz">피자</label>
  <input type="checkbox" id="dduk", name="favorite" value="떡볶이">
  <label for="dduk">떡볶이</label>
  <input type="checkbox" id="chick", name="favorite" value="치킨">
  <label for="chick">치킨</label>
  <input type="checkbox" id="sam", name="favorite" value="삼겹살">
  <label for="sam">삼겹살</label><br>
  <label>하고싶은 말</label>
  <textarea name="comment" row="3" cols="30"></textarea><br>
  <button type="submit">submit</button>
  <button type="reset">reset</button>
</form>
</body>
</html>
