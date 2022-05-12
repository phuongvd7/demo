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

import model.Clazz;
import model.Course;
import service.ClazzService;
import service.ClazzServiceImpl;
import service.CourseService;
import service.CourseServiceImpl;

@WebServlet(urlPatterns = "/create-clazz")
public class CreateClazzController extends HttpServlet {
	CourseService courseService = new CourseServiceImpl();
	ClazzService clazzService = new ClazzServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/clazz/createClazzForm.jsp"); // ham nay de fw cho tk
																								// khac xu li

		try { // lay tat ca course
			List<Course> courseList = courseService.getAll();
			req.setAttribute("courseList", courseList);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "Xay ra loi");
		}
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/clazz/createClazzForm.jsp"); // ham nay de fw cho tk
																								// khac xu li
//cach de day ham di thi phai set them ham moi o trong ham  Post		
		String id = req.getParameter("cid");
		String name = req.getParameter("cname");
		String courseId = req.getParameter("courseId");
		try {
			Clazz clazz = new Clazz();
			clazz.setId(Integer.parseInt(id));
			clazz.setName(name);

			Course course = new Course();
			course.setId(Integer.parseInt(courseId)); // dang de string => patch sang int

			clazz.setCourse(course);
			clazzService.insert(clazz);
// 
			// set attribute de day log bao thanh cong hay NOK sang JSP, su dung set de khop
			// Key
			// doPost thi phai su dung setAttribute, khong the keo forward sang truc tiep
			// nhu doGet dc => ve thu lai
			req.setAttribute("msg", "them thanh cong");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			req.setAttribute("msg", "sai du lieu");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "loi server");

		}
//		try { // lay tat ca course
//			List<Course> courseList = courseService.getAll();
//			req.setAttribute("courseList", courseList);   // van phai lay courselist day qua
//		} catch (Exception e) {
//			e.printStackTrace();
//			req.setAttribute("msg", "Xay ra loi");
//
//			// pw.println("<a href=' /qlsvweb/menu-course' > Quay lai </a>");
//		}
//		dispatcher.forward(req, resp);
		doGet(req, resp);
	
}
}
