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
                <li class="modify">이름 : <input type="text" name="first_name" value="${emp.first_name}" readonly></li>
                <li class="modify">입사일 : <input type="text" name="hire_date" value="${emp.hire_date}" readonly></li>
                <li class="modify">부서번호 : <input type="text" name="department_id" value="${emp.department_id}" readonly></li>
            </ul>
            <button type="submit" id="upd" hidden>수정</button>
            <button type="button" onclick="delConfirm(${emp.employee_id})">삭제</button>
        </form>
    </c:otherwise>
</c:choose>
<script>
    const convert = function() {
        // 인풋들 리드온리 토글처리 추가 
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
