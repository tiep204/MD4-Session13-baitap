<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>CRUD CỦA TIỆP CÒI</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<style>
    /* Tạo kiểu cho phần tử active */
    .page-item a.active {
        background-color: #007bff;
        color: #fff;
    }
</style>
<body style="padding: 100px;">
<h1 style="text-align: center">CRUD CỦA TIỆP CÒI</h1>
<form style="text-align: center" class="search-container" role="search">
    <input style="width: 500px;border-radius: 5px" class="search-input" type="search" name="studentName"
           placeholder="Mày điền vào đây">
    <button style="background-color: #007bff;color: white;border: none;border-radius: 5px" class="search-button"
            name="action" type="submit" value="search">Search
    </button>
</form>
<a style="background-color:white;color: black;border-color: black" class="btn btn-primary" role="button"
   href="views/newStudent.jsp">create</a>
<div class="btn-group">
    <button type="button" class="btn btn-danger">Sắp Xếp</button>
    <button type="button" class="btn btn-danger dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown"
            aria-expanded="false">
        <span class="visually-hidden">Toggle Dropdown</span>
    </button>
    <ul class="dropdown-menu">
        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/StudentServlet?action=sort&sortDirection=asc">Thứ
            tự tăng dần</a></li>
        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/StudentServlet?action=sort&sortDirection=desc">Thứ
            tự giảm dần</a></li>
    </ul>
</div>

<table border="10" cellspacing="10" cellpadding="10" class="table table-hover">
    <thead>
    <tr>
        <th>studentId</th>
        <th>studentName</th>
        <th>age</th>
        <th>birthDate</th>
        <th>studentStatus</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listStudent}" var="st">
        <tr>
            <td>${st.studentId}</td>
            <td>${st.studentName}</td>
            <td>${st.age}</td>
            <td><fmt:formatDate value="${st.birthDate}" pattern="dd-MM-yyyy" /></td>
            <td>${st.studentStatus ? "Hoat động" : "không hoạt động"}</td>
            <td>
                <a onclick="return confirm('Bạn có chắc chắn muốn xóa không?')"
                   href="<%=request.getContextPath()%>/StudentServlet?studentId=${st.studentId}&amp;action=delete">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3"
                         viewBox="0 0 16 16">
                        <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"></path>
                    </svg>
                </a>
                <a href="<%=request.getContextPath()%>/StudentServlet?studentId=${st.studentId}&amp;action=update">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                         class="bi bi-pencil-square" viewBox="0 0 16 16">
                        <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"></path>
                        <path fill-rule="evenodd"
                              d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"></path>
                    </svg>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
        <c:forEach begin="1" end="${endP}" var="i">
            <li class="page-item"><a class="page-link ${tag == i ? 'active' : ''}"
                                     href="<%=request.getContextPath()%>/StudentServlet?indexs=${i}">${i}</a></li>
        </c:forEach>
        <li class="page-item"><a class="page-link" href="#">Next</a></li>
    </ul>
</nav>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>
