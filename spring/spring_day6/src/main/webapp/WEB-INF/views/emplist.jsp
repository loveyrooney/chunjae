<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
</head>
<body>
<a href="/insert">추가</a>
<ul>
    <c:forEach var="item" items="${list}">
        <li><a href="/detail/${item.employee_id}">${item.employee_id}</a><c:out value=" ${item.first_name} ${item.hire_date}"/></li>
    </c:forEach>
</ul>
</body>
</html>
