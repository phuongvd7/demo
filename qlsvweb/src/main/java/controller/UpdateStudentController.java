package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import model.Student;
import service.CourseService;
import service.CourseServiceImpl;
import service.StudentService;
import service.StudentServiceImpl;

@WebServlet(urlPatterns = "/edit-student")
public class UpdateStudentController extends HttpServlet {
//	CourseService courseService = new CourseServiceImpl();
	StudentService studentService = new StudentServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String id = req.getParameter("id");// ben controller sau dau ? la gi thi nhap tuong ung
		String name = req.getParameter("name");

		pw.println("<form action = \"/qlsvweb/student-course\" method =\"post\">\r\n"
				+ "  <label>ID: </label>\r\n"
				+ "  <br>\r\n"
				+ "  <input type=\"number\" name=\"cid\" value=\"'\"  + id + \"'\">\r\n"
				+ "  <br>\r\n"
				+ "  <label>Name: </label>\r\n"
				+ "  <br>\r\n"
				+ "  <input type=\"text\" name=\"cname\" value=\"'\"  + name + \"'\">\r\n"
				+ "  <br> <button type = \"submit\">Create</button>\r\n"
				+ "</form>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String id = req.getParameter("id");// ben controll sau dau
		String name = req.getParameter("name");

		try {
			Student student = new Student();
			studentService.update(student);
			student.setId(Integer.parseInt(id)); // dang de string => patch sang int
			student.setName(name);
			pw.print("<p> them thanh cong</p>");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			pw.println("<p> Sai du lieu  </p>");
		}
		pw.println("<a href=' /qlsvweb/menu-student' > Quay lai </a>");
	}
}
