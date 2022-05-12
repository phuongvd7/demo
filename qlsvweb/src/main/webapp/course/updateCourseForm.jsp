<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		String id = request.getParameter("id");
		String name = request.getParameter("name"); // truyen gia tri cua value tu server vao <%=id% => sau khi an submit thi thang name = cid lai dc truyen di
				// => req ben do post phai nhap la cid va cname
		%>
		
<form action="/qlsvweb/edit-course" method="post">
  <label>ID: </label><br>
  <input type="number" name="cid" value="<%=id%>"><br>
  <label>Name: </label><br>
  <input type="text" name="cname" value="<%=name%>"><br> 
  <button type="submit">Save</button>
</form>
<% String msg = (String) request.getAttribute("msg");
if(msg != null){
%>
<p> <%=msg %> </p>
<%} %>
<a href=' /qlsvweb/menu-course' > Quay lai </a>

</body>
</html>