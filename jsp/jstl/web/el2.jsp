<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-11
  Time: 오전 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name = "hong gil dong";
    int age = 20;
    // 변수를 곧장 갖다 쓰지는 못하므로 setAttribute 필요. null 이나 선언이 없는 경우에는 공백 출력 (에러 없음)
    pageContext.setAttribute("name",name);
    pageContext.setAttribute("age",age);
    //pageContext.setAttribute("addr",null);
%>
<p>이름 : ${name}</p>
<p>나이 : ${age}</p>
<p>주소 : ${empty addr}</p>
</body>
</html>
