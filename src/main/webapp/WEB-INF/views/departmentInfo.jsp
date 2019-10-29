<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: holyb
  Date: 09.05.2019
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Department info</title>
</head>
<body>
    <h3>Head of ${department.departName} department is ${department.headOfDepart}</h3>
    <h3>${department.departName} statistic assistant = ${assistCount}</h3>
    <h3>${department.departName} statistic associate professor = ${associateProfCount}</h3>
    <h3>${department.departName} statistic professors = ${professorsCount}</h3>
    <h3>The average salary of ${department.departName} is ${avgSalary}</h3>
    <h3>Count of employee for ${department.departName} = ${departCount}</h3>
</body>
</html>
