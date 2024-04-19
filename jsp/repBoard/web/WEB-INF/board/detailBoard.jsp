<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-18
  Time: 오전 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/writeBoard.css">
    <script defer src="js/detailBoard.js"></script>
</head>
<body>
<c:set var="board" value="${requestScope.dto}"/>
<a href="boardlist.do">HOME</a>
<ul>
    <c:choose>
        <c:when test="${empty board || empty board.boardno}">
            <li>해당 정보를 찾을 수 없습니다.</li>
        </c:when>
        <c:otherwise>
            <li>No. ${board.boardno}</li>
            <li>제목 | ${board.boardtitle}</li>
            <li>내용 | ${board.boardcontent}</li>
        </c:otherwise>
    </c:choose>
</ul>
<hr>
<form method="post", action="writeRep.do" id="repForm">
    <ul>
        <li><input type="text" name="boardno" value="${board.boardno}" hidden></li>
        <li><label for="writer">작성자</label>
            <input type="text" name="writer" id="writer">
        </li>
        <li>
            <label for="subcon">내용</label>
            <textarea rows="2" cols="30" name="subcontent" id="subcon"></textarea>
        </li>
        <li>
            <button type="submit" id="repmod" hidden>수정</button>
            <button type="submit" id="repbtn">댓글</button>
            <button type="reset">취소</button>
        </li>
    </ul>
</form>
<ul id="reply"></ul>
<script>
    fetch(`replylist?bno=${board.boardno}`,{
        method : "get"
        ,headers : {"Content-Type" : "application/x-www-form-urlencoded" ,"Accept" : "text/json"}
    }).then(res=>res.json())
        .then((data)=>{
            data.forEach(d=>{
                console.log(d);
                let ele_li = document.createElement("li");
                let ele_span1 = document.createElement("span");
                let ele_span2 = document.createElement("span");
                let writer = document.createTextNode(d.writer);
                let subcon = document.createTextNode(d.subcontent);
                ele_span1.appendChild(writer);
                ele_span2.appendChild(subcon);
                ele_li.appendChild(ele_span1);
                ele_li.appendChild(ele_span2);
                let delbtn = document.createElement("button");
                delbtn.setAttribute("type","button");
                delbtn.appendChild(document.createTextNode("삭제"));
                ele_li.appendChild(delbtn);
                delbtn.addEventListener("click",function () {
                    location.href = "deleteRep.do?subno="+d.subno+`&bno=${board.boardno}`;
                });
                let modbtn = document.createElement("button");
                modbtn.setAttribute("type","button");
                modbtn.appendChild(document.createTextNode("수정"));
                ele_li.appendChild(modbtn);
                modbtn.addEventListener("click",function () {
                    document.getElementsByName("writer")[0].value = d.writer;
                    document.getElementsByName("subcontent")[0].value = d.subcontent;
                    document.getElementById("repmod").toggleAttribute("hidden");
                    document.getElementById("repbtn").toggleAttribute("hidden");
                    document.getElementById("repForm").setAttribute("action","modifyRep.do?subno="+d.subno);
                });
                document.getElementById("reply").appendChild(ele_li);
            });
        }).catch(error=>{
        console.log("error: ",error);
    }).finally(()=>{});
</script>
</body>
</html>
