<%@ page import="ra.controller.StudentServlet" %><%--
  Created by IntelliJ IDEA.
  User: tiepd
  Date: 07/08/2023
  Time: 8:19 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/styles.css">
</head>
<body>
<form action="<%=request.getContextPath()%>/StudentServlet" method="post">
    <table>
        <tr>
            <td>ID</td>
            <td><input type="text" name="studentId"></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="studentName"></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><input type="number" name="age"></td>
        </tr>
        <tr>
            <td>birthDate</td>
            <td><input type="date" name="birthDate"></td>
        </tr>
        <tr>
            <td>studentStatus</td>
            <td><input type="radio" name="studentStatus" id="active" value="true" checked/>
                <label for="active">Hoạt động </label>
                <input type="radio" name="studentStatus" id="inactive" value="false"/>
                <label for="inactive">không Hoạt động </label>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="create" name="action"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
