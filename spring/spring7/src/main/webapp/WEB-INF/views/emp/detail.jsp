<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-05-10
  Time: 오후 5:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${isNull}">
        <h3>잘못된 접근입니다.</h3>
    </c:when>
    <c:otherwise>
        <button type="button" onclick="convert()">수정하시겠습니까?</button>
        <form method="post" action="/update">
            <ul id="view" class="detail_mode">
                <li>사원번호 : <input type="text" name="employee_id" value="${emp.employee_id}" readonly></li>
                <li>이름 : <input class="modify" type="text" name="first_name" value="${emp.first_name}" readonly></li>
                <li>입사일 : <input class="modify" type="date" name="hire_date" value="${emp.hire_date}" readonly></li>
                <li>부서번호 : <input class="modify" type="text" name="department_id" value="${emp.department_id}" readonly></li>
            </ul>
            <button type="submit" id="upd" hidden>수정</button>
            <button type="button" onclick="delConfirm(${emp.employee_id})">삭제</button>
        </form>
    </c:otherwise>
</c:choose>
<script>
    const convert = function() {
        document.getElementById("upd").toggleAttribute("hidden");
        const mod_inputs = document.getElementsByClassName("modify");
        for(i=0; i<mod_inputs.length; i++){
            mod_inputs.item(i).toggleAttribute("readonly");
        }
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
