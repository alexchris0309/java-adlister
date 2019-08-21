<%--
  Created by IntelliJ IDEA.
  User: Alexandra
  Date: 2019-08-21
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%--<%! Boolean test=true; %>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<% response.sendRedirect("/profile.jsp"); %>

<c:if test="${param.Username =='admin' && param.Password =='password'}">
    <% response.sendRedirect("/profile.jsp"); %>
    <h1>hello</h1>
</c:if>


<form action="../login.jsp" method="post">

    <label for ="Username">User Name</label>
    <input id="Username" name="Username" type="text" placeholder="Enter Username">
    <label for ="Password">Password</label>
    <input id="Password" name="Password" type="Password" placeholder="Password">
    <button type="submit" id="loginSubmit">Login</button>
</form>
