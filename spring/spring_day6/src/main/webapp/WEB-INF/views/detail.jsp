<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-05-08
  Time: 오후 5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .detail_mode input {
            border-style: hidden;
        }
        .update_mode input {
            border-style: inset;
        }
    </style>
</head>
<body>
<a href="/list">HOME</a>
<c:choose>
    <c:when test="${isNull}">
        <h1>잘못된 접근입니다.</h1>
    </c:when>
    <c:otherwise>
        <button type="button" onclick="convert()">수정하시겠습니까?</button>
        <form method="post" action="/update_result">
            <ul id="view" class="detail_mode">
                <li>사원번호 : <input type="text" name="employee_id" value="${dto.employee_id}" readonly></li>
                <li>이름 : <input type="text" name="first_name" value="${dto.first_name}"></li>
                <li>입사일 : <input type="date" name="hire_date" value="${dto.hire_date}"></li>
                <li>급여 : <input type="text" name="salary" value="${dto.salary}"></li>
                <li>부서번호 : <input type="text" name="department_id" value="${dto.department_id}"></li>
            </ul>
            <button type="submit" id="upd" hidden>수정</button>
            <button type="button" id="del" onclick="delConfirm(${dto.employee_id})">삭제</button>
        </form>
    </c:otherwise>
</c:choose>
<script>
    const convert = function() {
        document.getElementById("upd").toggleAttribute("hidden");
        const view = document.getElementById("view");
        if(view.className === "detail_mode")
            view.setAttribute("class","update_mode");
        else
            view.setAttribute("class","detail_mode");
    }
    const delConfirm = function(eid) {
        if(window.confirm("정말 삭제하시겠습니까?")){
            location.href="/del/"+eid;
        }
    }
</script>
</body>
</html>
