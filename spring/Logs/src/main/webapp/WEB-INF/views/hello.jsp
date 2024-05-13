<%--
  Created by IntelliJ IDEA.
  User: FULL8-011
  Date: 2024-05-13
  Time: 오후 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/result">
    <label for="su1">수1</label>
    <input type="text" name="su1" id="su1"><br>
    <label for="su2">수2</label>
    <input type="text" name="su2" id="su2"><br>
    <button type="submit">계산하기</button>
    <button type="reset">취소</button>
</form>
<button type="button" id="btn">body3</button>
<script>
    document.getElementById("btn").onclick=function (){
        fetch("/body3",{ method : "get" ,headers : { "Accept" : "text/json" }
        }).then(data=>{
            console.log(data);
        });
    }
</script>
</body>
</html>
