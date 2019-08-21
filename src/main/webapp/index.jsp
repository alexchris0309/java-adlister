<%--
  Created by IntelliJ IDEA.
  User: Alexandra
  Date: 2019-08-21
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! int counter = 0; %>
<% counter += 1; %>
<html>
<jsp:include page="Partials/header.jsp"/>
<body>
<h1>The current count is <%= counter %>.</h1>

View the page source!

<%-- this is a JSP comment, you will *not* see this in the html --%>

<!-- this is an HTML comment, you *will* see this in the html -->

<h1>Welcome To The Site!</h1>
<p>Path: <%= request.getRequestURL() %></p>
<p>Query String: <%= request.getQueryString() %></p>

<p>"name" parameter:</p>  ${param.name!= null ? param.name: "no result"};

<p>"color" parameter: <%= request.getParameter("color") %></p>

<p>User-Agent header: <%= request.getHeader("user-agent") %></p>



<jsp:include page="Partials/scripts.jsp"/>
</body>
</html>
