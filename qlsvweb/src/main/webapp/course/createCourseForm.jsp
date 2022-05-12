<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Course</title>
</head>
<body>
	<% 
	int x = 10;
	if (x > 20){
	%>
		<h1>Hello X</h1>
	<% 
	}
	%>
	<h1><%=x%></h1>
	
<form action="/qlsvweb/create-course" method="post">
  <label>ID: </label>
  <br>
  <input type="number" name="cid" value="'" +="" id="" "'"="">
  <br>
  <label>Name: </label>
  <br>
  <input type="text" name="cname" value="'" +="" "'"="">
  <br> <button type="submit">Create</button>
</form>

<% String msg = (String) request.getAttribute("msg");
if(msg != null){
%>
<p> <%=msg %> </p>
<%} %>
<a href=' /qlsvweb/menu-course' > Quay lai </a>
</body>
</html>