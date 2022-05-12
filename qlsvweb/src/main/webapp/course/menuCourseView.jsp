<%@page import="java.util.List"%>
<%@page import="model.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu Course</title>
</head>
<body>
	<h1>Menu Course</h1>
	<a href='/qlsvweb/create-course'>1. Create Course </a>
	<%
	if(request.getAttribute("courseList")!=null){ // phai check null hay not null thi moi ra dc
	List<Course> courseList = (List<Course>) request.getAttribute("courseList");
	
	for (Course c : courseList) {
	%>
	<p>----------------</p>
	<p>
		ID:
		<%=c.getId()%></p>
	<p>
		Name:
		<%=c.getName()%></p>
	<a href='/qlsvweb/delete-course?id=<%=c.getId()%>'>Delete Course </a>
	<a href='/qlsvweb/edit-course?id=<%=c.getId()%>&name=<%=c.getName()%>'>Edit Course </a> //id cua thang nay sau dau ? la phai bang thang 
	<%
	}}
	%>
</body>
</html>