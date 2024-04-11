<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-11
  Time: 오전 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    El(Expression Language)
    : jstl이 소개 되었을 때 나왔던 것으로 코드 대신 템플릿 코드처럼 사용할 수 있다.
    $ 로 표현, 내용은 \${표현식}
    산술연산 : div, mod
    비교연산 : ==(eq), !=(ne), <(lt), >(gt), >=(ge), <=(le), a>b? a:b
    관계연산 : &&(and), ||(or), !(not)
    공백연산 : empty (값이 null이거나 공백일 경우)
--%>
<table>
    <thead>
        <tr>
            <th>el expression</th>
            <th>result</th>
        </tr>
    </thead>
    <tbody>
        <tr><th colspan="2">산술연산</th></tr>
        <tr>
            <td>\${1}</td>
            <td>${1}</td>
        </tr>
        <tr>
            <td>\${1+2}</td>
            <td>${1+2}</td>
        </tr>
        <tr>
            <td>\${1.2+2.3}, \${1.2E4+2.3}</td>
            <td>${1.2+2.3}, ${1.2E4+2.3}</td>
        </tr>
        <tr>
            <td>\${10/2}, \${10/0}</td>
            <td>${10/2}, ${10/0}</td>
        </tr>
        <tr>
            <td>\${10/3}, \${10 div 3}</td>
            <td>${10/3}, ${10 div 3}</td>
        </tr>
        <tr>
            <td>\${10%3}, \${10 mod 3}</td>
            <td>${10%3}, ${10 mod 3}</td>
        </tr>
        <tr>
            <td>\${(1==2)? 1:2}</td>
            <td>${(1==2)? 1:2}</td>
        </tr>
        <tr><th colspan="2">비교연산</th></tr>
        <tr>
            <td>\${1>2}, \${1 gt 2}</td>
            <td>${1>2}, ${1 gt 2}</td>
        </tr>
        <tr>
            <td>\${1<2}, \${1 lt 2}</td>
            <td>${1<2}, ${1 lt 2}</td>
        </tr>
        <tr>
            <td>\${1>=2}, \${1 ge 2}</td>
            <td>${1>=2}, ${1 ge 2}</td>
        </tr>
        <tr>
            <td>\${1<=2}, \${1 le 2}</td>
            <td>${1<=2}, ${1 le 2}</td>
        </tr>
        <tr>
            <td>\${2 == 2}, \${2 eq 2}</td>
            <td>${2 == 2}, ${2 eq 2}</td>
        </tr>
        <tr>
            <td>\${2 != 2}, \${2 ne 2}</td>
            <td>${2 != 2}, ${2 ne 2}</td>
        </tr>
        <tr><th colspan="2">문자열 연산 : char 단위로 ascii code 비교, 문자열끼리  + 안됨</th></tr>
        <tr>
            <td>\${'a'>'b'}, \${"hello">"happy"}</td>
            <td>${'a'>'b'}, ${"hello">"happy"}</td>
        </tr>
        <tr>
            <td>\${'4'>3}, \${'4'+10}</td>
            <td>${'4'>3}, ${'4'+10}</td>
        </tr>
        <tr><th colspan="2">논리연산</th></tr>
        <tr>
            <td>\${10>20 && 10<20}, \${10>20 and 10<20}</td>
            <td>${10>20 && 10<20}, ${10>20 and 10<20}</td>
        </tr>
        <tr>
            <td>\${10>20 || 10<20}, \${10>20 or 10<20}</td>
            <td>${10>20 || 10<20}, ${10>20 or 10<20}</td>
        </tr>
    </tbody>
</table>
</body>
</html>
