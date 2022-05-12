<%@page import="java.util.List"%>
<%@page import="model.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Clazz</title>
</head>
<body>
	<% 		List<Course> courseList = (List<Course>) request.getAttribute("courseList");		
	%>
<form action="/qlsvweb/create-clazz" method="post">
  <label>ID: </label>  <br>
  <input type="number" name="cid" value=""> 
  <br> <label>Name: </label> 
  <br> <input type="text" name="cname" value=""><br>
   <br> <label>Course: </label> <br>
  <br><select name="courseId" >
  		<% for ( Course c2 : courseList) { // muon xu li sau khi update van hien ve thang nhu cu
  			if(c2.getId() == Integer.parseInt(request.getParameter("courseId"))){
  				%><option selected value="<%=c2.getId()%>"> <%=c2.getName() %> </option>
  				<%
  			}else{
  				%>
  			<option value="<%=c2.getId()%>"> <%=c2.getName() %> </option>
  				<%
  		}
  		%>
  		</select>
  
  <br> <button type="submit">Create</button>
</form>

<% String msg = (String) request.getAttribute("msg");
if(msg != null){
%>
<p> <%=msg%> </p>
<%} %>

<a href=' /qlsvweb/menu-course' > Quay lai </a>
</body>
</html>