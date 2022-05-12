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
import service.CourseService;
import service.CourseServiceImpl;

@WebServlet(urlPatterns = "/menu-course") // thu vien trong java ho tro viet code web
public class CourseController extends HttpServlet { 

	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	CourseService courseService = new CourseServiceImpl();
	// method: get , post , put ,delete // co nhung ham doget dopost, doput,....
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html");
//		PrintWriter pw = resp.getWriter();
//		pw.print("<h1>MENU COURSE </h1>");
//		pw.print("<a href='/qlsvweb/create-course'>1. Create Course </a>");
//		pw.print("<h2>2. Edit Course </h2>");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/course/menuCourseView.jsp"); // ham nay de fw cho tk khac xu li

		try {
			List<Course> courseList = courseService.getAll();
			
			req.setAttribute("courseList", courseList);
//			courseList.forEach(c -> {
//				pw.println("<p>----------------</p>");
//				pw.println("<p>ID: " + c.getId());
//				pw.println("Name: " + c.getName());
//				pw.println("<a href='/qlsvweb/delete-course?id=" + c.getId() + " '>Delete Course </a>"); //trong html nhay don nhay doi nhu nhau, de nhay don cho de phan biet
//				pw.println("<a href='/qlsvweb/edit-course?id=" + c.getId() + "&name=" + c.getName()+ "'>Edit Course </a>");
//				//mac dinh se chui vao doGet
//				pw.println("----------------");
//			});
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "Xay ra loi");
		}
		dispatcher.forward(req, resp);

	}
}
