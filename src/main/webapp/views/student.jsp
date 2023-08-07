<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: tiepd
  Date: 07/08/2023
  Time: 8:18 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="10" cellspacing="10" cellpadding="10">
    <thead>
    <tr>
        <th>studentId</th>
        <th>studentName</th>
        <th>age</th>
        <th>birthDate</th>
        <th>studentStatus</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items="${listStudent}" var="st">
    <tr>
        <td>${st.studentId}</td>
        <td>${st.studentName}</td>
        <td>${st.age}</td>
        <td><fmt:formatDate value="${st.birthDate}" pattern="dd-MM-yyyy"></fmt:formatDate></td>
        <td>${st.studentStatus ? "Hoat động" : "không hoạt động"}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<a href="views/newStudent.jsp">create</a>
</body>
</html>
