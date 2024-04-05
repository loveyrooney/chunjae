<%@ page import="dto.StudentDTO" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-05
  Time: 오후 4:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    /* 객체 scope : 객체마다 동작하는 범위
    1. pageContext : 객체가 생성됐을때 해당 페이지에서만 인식 (페이지를 벗어나는 순간 불가)
    2. request : 요청을 하는 곳까지 해당 객체를 인식 (forward 가 연결된 모든 페이지가 해당함)
    3. session : 세션 생성 후 종료시까지 객체를 인식 (페이지의 연결 여부와 관계 없음)
    4. application : 전체 application 내에서 객체를 인식
    */
    StudentDTO dto = new StudentDTO("hong",20);
    // get, set, remove Attribute 메서드를 통해 객체를 각 스코프에 등록하고 삭제하고 조회할 수 있다.
    //pageContext.setAttribute("dto",dto);
    request.setAttribute("dto",dto);
%>
<%--<%=pageContext.getAttribute("dto")%><br>--%>
<%
//    // dto 객체는 해당 페이지에서는 볼 수 있다.
//    StudentDTO pageconDTO = (StudentDTO) pageContext.getAttribute("dto");
//    out.print(pageconDTO.getName());
//    // sendRedirect / forward 를 해서 page2 에서는 볼 수 없다.
//    response.sendRedirect("page2.jsp");
%>
<%
    StudentDTO reqDTO = (StudentDTO) request.getAttribute("dto");
    // forward 를 하는 경우 최종 응답하는 페이지 까지가 요청의 범위이기 때문에 page2에서 볼 수 있지만,
    // sendRedirect 를 하는 경우 이미 page1에 대한 요청과 응답이 끝난 후이기 때문에 안됨.
    response.sendRedirect("page2.jsp");
%>
<%=request.getAttribute("dto")%><br>
<%--<jsp:forward page="/scope/page2.jsp"></jsp:forward>--%>
</body>
</html>
