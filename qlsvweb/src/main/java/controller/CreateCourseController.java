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
import service.CourseService;
import service.CourseServiceImpl;

@WebServlet(urlPatterns = "/create-course")
public class CreateCourseController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/course/createCourseForm.jsp"); // ham nay de fw cho tk khac xu li
		dispatcher.forward(req, resp); // phai co ham fw moi chuyen dc
		//forward cho 1 thang khac xu li
	}
	CourseService courseService = new CourseServiceImpl();



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/course/createCourseForm.jsp"); // ham nay de fw cho tk khac xu li
//cach de day ham di thi phai set them ham moi o trong ham  Post		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String id = req.getParameter("cid");
		String name = req.getParameter("cname");

		try {
			Course course = new Course();
			courseService.insert(course);
			course.setId(Integer.parseInt(id)); // dang de string => patch sang int
			course.setName(name);
			// set attribute de day log bao thanh cong hay NOK sang JSP, su dung set de khop Key
			// doPost thi phai su dung setAttribute, khong the keo forward sang truc tiep nhu doGet dc => ve thu lai
			req.setAttribute("msg", "them thanh cong");
			pw.print("<p> them thanh cong</p>");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			req.setAttribute("msg", "sai du lieu");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "loi server");

		}
		dispatcher.forward(req, resp);
	//	pw.println("<a href=' /qlsvweb/menu-course' > Quay lai </a>");
	}
}
