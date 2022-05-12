<%@page import="java.util.List"%>
<%@page import="model.Student"%>
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
	<a href='/qlsvweb/create-student'>1. Create Student </a>
	<%
	List<Student> studentList = (List<Student>) request.getAttribute("studentList");

	for (Student c : studentList) {
	%>
	<p>----------------</p>
	<p>
		Person_id:
		<%=c.getPerson_id()%></p>
	<p>
		Student_code:
		<%=c.getStudentCode()%></p>
	<a href='/qlsvweb/delete-student?id=<%=c.getPerson_id()%>'>Delete Student </a>
	<a href='/qlsvweb/edit-student?id=<%=c.getPerson_id()%>&student_code=<%=c.getStudentCode()%>'>Edit Student </a>
	<%
	}
	%>
</body>
</html>