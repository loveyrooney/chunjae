<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-15
  Time: 오후 1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="upload_result.do" enctype="multipart/form-data">
    <ul>
        <li>
            <label for="title">제목</label>
            <input type="text" name="title" id="title">
        </li>
        <li>
            <label for="cont">내용</label>
            <textarea name="content" id="cont" rows="10" cols="30"></textarea>
        </li>
        <li>
            <label for="file">파일</label>
            <input type="file" name="uploadfile" id="file">
        </li>
        <li>
            <button type="submit">submit</button>
            <button type="reset">reset</button>
        </li>
    </ul>
</form>
</body>
</html>
