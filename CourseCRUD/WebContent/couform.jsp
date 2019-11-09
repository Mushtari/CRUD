<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>COURSE</title>
</head>
<body>
<center>
<h1>COURSE</h1>
<h2>
<a href="new">ADD NEW COURSE</a>
&nbsp;&nbsp;&nbsp;
<a href="list">List all COURSES</a>
</h2>
</center>
<div align="center">
<c:if test="${user!=null}">
<form action="update" method="post">
</c:if>
<c:if test="${user==null}">
<form action="insert" method="post">
</c:if>
<table border="1" cellpadding="5">
<caption>
<h2>
<c:if test="${user!=null}">
Edit COURSE
</c:if>
<c:if test="${user==null}">
Add New COURSE
</c:if>
</h2>
</caption>

<c:if test="${user!=null}">
<input type="text" name="id" value="<c:out value='${user.id}'/>"/> 
</c:if>

<tr>
<tr>
<th>COURSE PREREQ:</th>
<td>
<input type="text" name="preq" size="45" value="<c:out value='${user.preq}' />"/> </td></tr>
<tr>
<th>COURSE DURATION:</th>
<td>
<input type="text" name="dur" size="45" value="<c:out value='${user.dur}' />"/> </td></tr>
<tr>
<th>COURSE NAME:</th>
<td>
<input type="text" name="name" size="45" value="<c:out value='${user.name}' />"/> </td></tr>
<tr>
<th>DEPT NO:</th>
<td>
<input type="text" name="deptno" size="45" value="<c:out value='${user.deptno}' />"/> </td></tr>
<tr>
<th>INSTR ID:</th>
<td>
<input type="text" name="instrid" size="45" value="<c:out value='${user.instrid}' />"/> </td></tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="save"/>
</td>
</tr>
</table>
</form>
</div>
</body>
</html>