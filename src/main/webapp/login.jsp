<%--
  Created by IntelliJ IDEA.
  User: Alexandra
  Date: 2019-08-21
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>login</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--java example--%>
<%--<% --%>
<%--    String username=request.getParameter("username");--%>
<%--    String password=request.getParameter("password");--%>
<%--    --%>
<%--    if(username.equalsIgnoreCase("admin")&& password.equals("password")){--%>
<%--    response.sendRedirect("/profile.jsp");--%>
<%--    }--%>
<%--    %>--%>



<form action="./login.jsp" method="post">
    <label for="userId">Username</label>
    <input id="userId" type="text" name="username" placeholder="enter username"/>
    <br>
    <label for="userPass">Password:</label>
    <input id="userPass" type="password" name="userpass" placeholder="enter password"/>
    <br>
    <input type="submit" value ="submit">
</form>

<c:if test="${param.username=='admin' && param.userpass=='password'}">
    <%response.sendRedirect("/profile.jsp");%>
</c:if>


<%--</body>--%>
<%--</html>--%>
