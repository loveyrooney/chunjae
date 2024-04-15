<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-15
  Time: 오후 2:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
<c:url var="url" value="download.do">
    <c:param name="file" value="${requestScope.file}"/>
</c:url>
<a href="${url}"></a> 로 써도 된다.
--%>

제목 : ${requestScope.title}<br>
파일 : <a href="download.do?file=${requestScope.file}">${requestScope.file}</a><br>
오리지널 파일 : ${requestScope.originalFile}
</body>
</html>
