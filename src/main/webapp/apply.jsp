<%--
  Created by IntelliJ IDEA.
  User: Alexandra
  Date: 2019-08-23
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>apply</title>
</head>
<body>
<h1>Apply now for our <span>${sessionScope.program}</span> program</h1>
<form action="#">

    <c:if test="${sessionScope.program=='DS'}">
    <label for ="q1">Do you know python?</label>
    <select name="q1" id="q1">
        <option value="0">NO</option>
        <option value="0">Yes</option>
    </select>
    </c:if>
 ${price}



</form>

</body>
</html>
