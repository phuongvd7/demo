package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

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

@WebServlet(urlPatterns = "/menu-student") // thu vien trong java ho tro viet code web
public class StudentController extends HttpServlet { 

	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}


	PersonService personService = new PersonServiceImpl();
	StudentService studentService = new StudentServiceImpl();

	// method: get , post , put ,delete // co nhung ham doget dopost, doput,....
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html");
//		PrintWriter pw = resp.getWriter();
//		pw.print("<h1>MENU STUDENT </h1>");
//		pw.print("<a href='/qlsvweb/create-student'>1. Create Student  </a>");
//		pw.print("<h2>2. Edit Student </h2>");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/course/menuStudentView.jsp"); 

		try {
			List<Student> studentList = studentService.getAll();

	//		studentList.forEach(c -> {
//				pw.println("<p>----------------</p>");
//				pw.println("<p>person_id: " + c.getPerson_id());
//				pw.println("Student_code: " + c.getStudentCode());
//				pw.println("<a href='/qlsvweb/delete-student?id=" + c.getPerson_id() + " '>Delete Student </a>"); //trong html nhay don nhay doi nhu nhau, de nhay don cho de phan biet
//				pw.println("<a href='/qlsvweb/edit-student?id=" + c.getPerson_id() + "&student_code=" + c.getStudentCode()+ "'>Edit Student </a>");
				//mac dinh se chui vao doGet

//			});
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "Xay ra loi");
		}
		dispatcher.forward(req, resp);


	}
}
