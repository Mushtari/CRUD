<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>STUDENT</title>
</head>
<body>
<center>
<h1>STUDENT</h1>
<h2>
<a href="new">ADD NEW STUDENT</a>
&nbsp;&nbsp;&nbsp;
<a href="list">List all STUDENTS</a>
</h2>
</center>
<div align="center">
<table border="1" cellpadding="5">
<caption><h2>List of STUDENTS</h2></caption>
<tr>
<th>ID</th>
<th>NAME</th>
<th>DOB</th>
<th>COURSEID</th>
<th>DEPTNO</th>

<th>ACTION</th>
</tr>
<c:forEach var="user" items='${listuser}'>
<tr>
<td><c:out value="${user.id}"/></td>
<td><c:out value="${user.studname}"/></td>
<td><c:out value="${user.studdob}"/></td>
<td><c:out value="${user.courseid}"/></td>
<td><c:out value="${user.deptno}"/></td>
<td>
<a href="edit?id=<c:out value='${user.id}'/>">Edit</a>
&nbsp;&nbsp;&nbsp;
<a href="delete?id=<c:out value='${user.id}'/>">delete</a>
</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>