<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: holyb
  Date: 09.05.2019
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Department</title>
</head>
<body>
<c:forEach items="${departments}" var="d">
    <h3>Department name: <a href="<c:url value="/departmentInfo?headOfDepart=${d.headOfDepart}"/>"><c:out
            value="${d.departName}"/></a></h3>
</c:forEach>
<br/>

<form action="<c:url value ="/department/search"/>">
    <input type="text" name="name" placeholder="Enter Name to Search">
    <button>Find</button>
</form>
<br/>
<c:forEach items="${search}" var="s">
    <h3>Lectors name: <c:out value="${s}"/></h3>
</c:forEach>
</body>
</html>
