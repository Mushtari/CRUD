<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BOOK STORE</title>
</head>
<body>
<center>
<h1>BOOK STORE</h1>
<h2>
<a href="new">ADD NEW CUSTOMERS</a>
&nbsp;&nbsp;&nbsp;
<a href="list">List all users</a>
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
Edit customer
</c:if>
<c:if test="${user==null}">
Add New customer
</c:if>
</h2>
</caption>

<c:if test="${user!=null}">
<input type="text" name="id" value="<c:out value='${user.id}'/>"/> 
</c:if>

<tr>
<tr>
<th>customer fname:</th>
<td>
<input type="text" name="fname" size="45" value="<c:out value='${user.fname}' />"/> </td></tr>
<tr>
<th>last name:</th>
<td>
<input type="text" name="lname" size="45" value="<c:out value='${user.lname}' />"/> </td></tr>
<tr>
<th>address:</th>
<td>
<input type="text" name="address" size="45" value="<c:out value='${user.address}' />"/> </td></tr>
<tr>
<th>city:</th>
<td>
<input type="text" name="city" size="45" value="<c:out value='${user.city}'/>"/>
</td>
</tr>
<tr> 
<th>state:</th>
<td>
<input type="text" name="state" size="15" value="<c:out value='${user.state}' />"/></td></tr>
<tr> 
<th>zipcode:</th>
<td>
<input type="text" name="zipcode" size="15" value="<c:out value='${user.zipcode}' />"/></td></tr>
<tr> 
<th>email:</th>
<td>
<input type="text" name="email" size="15" value="<c:out value='${user.email}' />"/></td></tr>
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