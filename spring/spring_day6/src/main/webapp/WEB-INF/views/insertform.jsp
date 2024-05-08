<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-05-08
  Time: 오후 4:50
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
  <c:when test="${isUpdate}">
    <form method="post" action="/update_result">
  </c:when>
    <c:otherwise>
      <form method="post" action="/insert_result">
    </c:otherwise>
</c:choose>
    <ul>
      <li>
        <label for="eid">사원번호</label>
        <c:choose>
          <c:when test="${isUpdate}">
            <input type="text" name="employee_id" id="eid" readonly/>
          </c:when>
          <c:otherwise>
            <input type="text" name="employee_id" id="eid"/>
          </c:otherwise>
        </c:choose>
      </li>
      <li>
        <label for="first">이름</label>
        <input type="text" name="first_name" id="first"/>
      </li>
      <li>
        <label for="hd">입사일</label>
        <input type="date" name="hire_date" id="hd"/>
      </li>
      <li>
        <label for="sal">급여</label>
        <input type="text" name="salary" id="sal"/>
      </li>
      <li>
        <label for="did">부서번호</label>
        <input type="text" name="department_id" id="did"/>
      </li>
      <li>
        <button type="submit">전송</button>
        <button type="reset">취소</button>
      </li>
    </ul>
  </form>
</body>
</html>
