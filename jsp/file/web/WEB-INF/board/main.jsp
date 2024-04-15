<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-15
  Time: 오후 5:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <jsp:include page="templates/home.jsp"/>
    <c:choose>
        <c:when test="${param.page == 'imgList.jsp'}">
            <a href="upload.do">업로드</a>
        </c:when>
    </c:choose>
</header>
<div id="wrap">
    <jsp:include page="${param.page}"/>
</div>
<footer>
    <jsp:include page="templates/footer.jsp"/>
</footer>
</body>
</html>
