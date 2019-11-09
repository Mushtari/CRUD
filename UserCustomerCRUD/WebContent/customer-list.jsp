<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title> BOOK STORE</title>
</head>
<body>
<center>
<h1>BOOK STORE</h1>
<h2>
<a href="new">ADD NEW CUSTOMER</a>
&nbsp;&nbsp;&nbsp;
<a href="list">List all CUSTOMERS</a>
</h2>
</center>
<div align="center">
<table border="1" cellpadding="5">
<caption><h2>List of CUSTOMERS</h2></caption>
<tr>
<th>cust ID</th>
<th>fname</th>
<th>lanme</th>

<th>address</th>

<th>city</th>

<th>state</th>
<th>zipcode</th>
<th>email</th>

<th>Actions</th>
</tr>
<c:forEach var="user" items='${listuser}'>
<tr>
<td><c:out value="${user.id}"/></td>
<td><c:out value="${user.fname}"/></td>
<td><c:out value="${user.lname}"/></td>
<td><c:out value="${user.address}"/></td>
<td><c:out value="${user.city}"/></td>
<td><c:out value="${user.state}"/></td>
<td><c:out value="${user.zipcode}"/></td>
<td><c:out value="${user.email}"/></td>
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