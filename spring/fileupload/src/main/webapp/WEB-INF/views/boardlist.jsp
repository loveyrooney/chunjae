<%--
  Created by IntelliJ IDEA.
  User: dreamct
  Date: 2024-05-18
  Time: 오후 5:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/hello.css">
    <script src="/resources/js/hello.js"></script>
</head>
<body>
 <img src="/resources/image/download.jpg">
 <ul>
     <c:forEach var="item" items="${list}">
         <li>${item.infotitle}</li>
         <li>
             <ul>
               <c:forTokens var="list" items="${item.filenames}" delims=",">
                  <img src="/getImage/${list}"/>
                 <a href="/download/${list}">다운로드</a>
               </c:forTokens>
             </ul>
          </li>
     </c:forEach>
 </ul>

</body>
</html>
