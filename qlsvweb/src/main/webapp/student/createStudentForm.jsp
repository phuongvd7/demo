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
	int x = 10000;
	if (x > 20){
	%>
		<h1>Hello student</h1>
	<% 
	}
	%>
	<h1><%=x%></h1>
	
<form action="/qlsvweb/create-student" method="post">
  <label>person_id: </label>
  <br>
  <input type="number" name="cid" value="'" +="" id="" "'"="">
  <br>
  <label>student_code: </label>
  <br>
  <input type="text" name="cname" value="'" +="" "'"="">
  <br> <button type="submit">Create</button>
</form>

<% String msg = (String) request.getAttribute("msg");
if(msg != null){
%>
<p> <%=msg %> </p>
<%} %>
<a href=' /qlsvweb/menu-student' > Quay lai </a>
</body>
</html>