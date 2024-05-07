<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-05-07
  Time: 오후 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        ul li { list-style: none; padding: 5px 0;}
    </style>
</head>
<body>
  <form method="post" action="resultexam3">
    <ul>
        <li>
            <label for="id">아이디</label>
            <input type="text" name="id" id="id">
        </li>
        <li>
            <label for="pwd">패스워드</label>
            <input type="text" name="pwd" id="pwd">
        </li>
        <li>
            <label for="name">이름</label>
            <input type="text" name="name" id="name"/>
        </li>
        <li>
            <label for="addr">주소</label>
            <select name="addr" id="addr">
                <option value="서울">서울</option>
                <option value="경기">경기</option>
                <option value="강원">강원</option>
            </select>
        </li>
        <li>
            <label>성별</label>
            <input type="radio" name="gender" id="male" value="남자" checked>
            <label for="male">남자</label>
            <input type="radio" name="gender" id="female" value="여자">
            <label for="female">여자</label>
        </li>
        <li>
            <label>좋아하는 음식</label>
            <input type="checkbox" name="food" id="chi" value="치킨">
            <label for="chi">치킨</label>
            <input type="checkbox" name="food" id="piz" value="피자">
            <label for="piz">피자</label>
            <input type="checkbox" name="food" id="sam" value="삼겹살">
            <label for="sam">삼겹살</label>
            <input type="checkbox" name="food" id="jok" value="족발">
            <label for="jok">족발</label>
        </li>
        <li>
            <label for="comment">하고싶은 말</label>
            <textarea name="comment" id="comment" cols="20" rows="5"></textarea>
        </li>
        <li>
            <button type="submit">전송</button>
            <button type="reset">취소</button>
        </li>
    </ul>
  </form>
</body>
</html>
