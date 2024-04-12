<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-12
  Time: 오후 3:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../template.css">
</head>
<body>
<%--
    include directive (<%@ include file=""%>)
    template.java 에다가 file 로 추가한 jsp 파일들의 내용을 복사해서 한번에 보여준다.
    runtime 시에 각각의 jsp 파일들이 모두 java 파일로 변환되지 않고 template.jsp 만 변환된다.
    _jspx_dependants(Map 타입) 에 각각의 jsp 파일들 추가하고,
    _jspService() 에서 template.jsp + 추가된 각각의 jsp 파일 전체를 한번에 html 태그로 그려준다.
    정적 자료일 때 주로 쓴다.

    include action (<%@ include page=""%>)
    runtime 시에 template 및 각각의 jsp 파일은 모두 java 파일로 변환된다.
    _jspService() 에서 해당되는 라인에
    org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "top.jsp", out, false);
    동적 자료일 때 주로 쓴다.
    dispacher.include()가 이에 해당한다.
--%>
<%@ include file="top.jsp" %>
<div class="left"><%@ include file="left.jsp"%></div>
<div class="right"><%@ include file="center.jsp"%></div>
<div class="bottom"><%@ include file="bottom.jsp"%></div>
</body>
</html>
