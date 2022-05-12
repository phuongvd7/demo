package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import model.Student;
import service.CourseService;
import service.CourseServiceImpl;
import service.PersonService;
import service.PersonServiceImpl;
import service.StudentService;
import service.StudentServiceImpl;

@WebServlet(urlPatterns = "/create-student")
public class CreateStudentController extends HttpServlet {
	PersonService personService = new PersonServiceImpl();
	StudentService studentService = new StudentServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/student/createStudentForm.jsp");
		dispatcher.forward(req, resp);
//		resp.setContentType("text/html");
//		PrintWriter pw = resp.getWriter();
//
//		pw.println("<form action = \"/qlsvweb/create-student\" method =\"post\">\r\n"
//				+ "  <label>ID: </label>\r\n"
//				+ "  <br>\r\n"
//				+ "  <input type=\"number\" name=\"person_id\" value=\"\"> \r\n"
//				+ "  <br>\r\n"
//				+ "  <label>student_code: </label>\r\n"
//				+ "  <br>\r\n"
//				+ "  <input type=\"text\" name=\"student_code\" value=\"\">\r\n"
//				+ "  <br> <button type = \"submit\">Create</button>\r\n"
//				+ "</form>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/student/createStudentForm.jsp");
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String id = req.getParameter("person_id");
		String name = req.getParameter("student_code");

		try {
			Student student = new Student();
			studentService.insert(student);
			student.setId(Integer.parseInt(id)); // dang de string => patch sang int
			student.setName(name);
			req.setAttribute("msg", "them st thanh cong");
			pw.print("<p> them thanh cong</p>");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			req.setAttribute("msg", "sai du lieu");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "loi server");

		}
		dispatcher.forward(req, resp);
	//	pw.println("<a href=' /qlsvweb/menu-student' > Quay lai </a>");
	}
}
