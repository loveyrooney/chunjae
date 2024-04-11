<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Hashtable" %>
<%@ page import="t.Member" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-11
  Time: 오전 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArrayList<String> arr = new ArrayList<>();
    arr.add("hong");
    arr.add("park");
    arr.add("kim");
    arr.add("lee");

    pageContext.setAttribute("arr",arr);
%>
arr 출력(EL 사용) : ${arr[0]}, ${arr[1]}, ${arr[2]}, ${arr[3]}<br>
<%--
    JSTL core library : 변수(set/remove), 흐름제어, 조건문(if/choose), 반복문(forEach), url 처리
--%>
arr 출력(JSTL 사용) :
<c:forEach var="item" items="${arr}" varStatus="idx">
    <c:out value="${idx.index}"/>
    <c:out value="${item}"/>,
</c:forEach>
<hr>
for문 출력(JSTL) : sum 변수는 scope를 page 로 지정, forEach 내의 변수는 forEach 태그 내이다.
<c:set var="sum" value="0" scope="page"/>
<c:forEach var="i" begin="1" end="10" step="1">
    <c:out value="${i}"/>
    <c:set var="sum" value="${sum+i}"/>
</c:forEach>
, result : <c:out value="${sum}"/><br>
arr2 선언 및 출력(JSTL) :
<c:set var="arr2" value="han,gang,cho"/>
<c:forEach var="items" items="${arr2}" varStatus="idx">
    <c:out value="${idx.index}"/>
    <c:out value="${items}"/>,
</c:forEach>
<hr>
for문 출력 exam<br>
<c:set var="tot" value="0"/>
<c:forEach var="i" begin="1" end="9" step="2">
    ${i}
    <c:set var="tot" value="${tot+i}"/>
</c:forEach><br>
합계 : ${tot}
<hr>
<%
    ArrayList<Member> arr3 = new ArrayList<>();
    arr3.add(new Member("hong",20));
    arr3.add(new Member("kim",20));
    arr3.add(new Member("lee",20));
    pageContext.setAttribute("arr3",arr3);
%>
<p>ArrayList 출력(JSTL) :
<c:forEach var="m" items="${arr3}">
    <c:out value="${m.name}"/>  <%-- m.getName()을 이렇게 쓸수 있다. --%>
    <c:out value="${m.age}"/>,
</c:forEach></p>
<%
    Hashtable<String,String> ht = new Hashtable<>();
    ht.put("park","jisung");
    ht.put("son","heungmin");
    ht.put("harry","potter");
    pageContext.setAttribute("ht",ht);
%>
<p>HashTable 출력(JSTL) :
<c:forEach var="s" items="${ht}">
    <c:out value="${s.key}"/> :
    <c:out value="${s.value}"/>,
</c:forEach></p>
<p>HashTable keySet(), values() (EL) :<br>
${ht.keySet()}, ${ht.values()}
</p>
<%
    HashMap<String, String> hm = new HashMap<>();
    hm.put("cha","duri");
    hm.put("wayne","rooney");
    pageContext.setAttribute("hm",hm);
%>
<p>HashMap(String,String) get(key), keySet(), values() (EL) :<br>
${hm.cha}, ${hm.wayne}, ${hm.keySet()}, ${hm.values()}<br>
    HashTable은 FIFO, HashMap은 LIFO 순이 된다</p>
<%
    ArrayList<String> al = new ArrayList<>();
    al.add("야구");
    al.add("축구");
    HashMap<String, List> hm2 = new HashMap<>();
    hm2.put("sports",al);
    pageContext.setAttribute("hm2",hm2);
%>
<p>HashMap(String,List) get(key) (EL):
${hm2.sports[0]}</p>
<hr>
forTokens 출력 :
<c:set var="names" value="hong,lee,park"/>
<c:forTokens var="n" items="${names}" delims=",">
<c:out value="${n}"/>
</c:forTokens>

</body>
</html>
