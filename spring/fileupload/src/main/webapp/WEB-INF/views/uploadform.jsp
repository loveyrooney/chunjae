<%--
  Created by IntelliJ IDEA.
  User: dreamct
  Date: 2024-05-17
  Time: 오후 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <form method="post" action="formresult" enctype="multipart/form-data">
        <label>글내용</label>
        <input type="text" name="title" name="title"><br>
        <label>파일</label><br>
        <input type="file" id="file1" name="files" multiple><br>
      <input type="submit" value="전송"/><br>
   </form>
</body>
</html>
