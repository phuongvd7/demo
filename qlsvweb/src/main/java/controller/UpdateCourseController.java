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

@WebServlet(urlPatterns = "/edit-course")
public class UpdateCourseController extends HttpServlet {
	CourseService courseService = new CourseServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/course/updateCourseForm.jsp"); 
		dispatcher.forward(req, resp);
//		resp.setContentType("text/html");
//		PrintWriter pw = resp.getWriter();
		
//		String id = req.getParameter("id");// ben controller sau dau ? la gi thi nhap tuong ung
//		String name = req.getParameter("name");

//		pw.println("<form action = \"/qlsvweb/edit-course\" method =\"post\">\r\n"
//				+ "  <label>ID: </label>\r\n"
//				+ "  <br>\r\n"
//				+ "  <input type=\"number\" name=\"cid\" value=\"'\"  + id + \"'\">\r\n"
//				+ "  <br>\r\n"
//				+ "  <label>Name: </label>\r\n"
//				+ "  <br>\r\n"
//				+ "  <input type=\"text\" name=\"cname\" value=\"'\"  + name + \"'\">\r\n"
//				+ "  <br> <button type = \"submit\">Create</button>\r\n"
//				+ "</form>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/course/updateCourseForm.jsp");
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String id = req.getParameter("cid");// ben update controller sau dau ? phai tuong ung voi thang nay, ben kia id => ben nay = id
		// con thang name="cname thi phai giong thang
		String name = req.getParameter("cname");

		try {
			Course course = new Course();
 			course.setId(Integer.parseInt(id)); // dang de string => patch sang int
			course.setName(name);
			courseService.update(course);
			req.setAttribute("msg", "update thanh cong");
			pw.print("<p> them thanh cong</p>");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			req.setAttribute("msg", "sai du lieu");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "loi server");
		}
		dispatcher.forward(req, resp); // fw thi ham ben duoi van chay => nhung da fw sang 1 thang khac roi thi ko nen co code ben duoi
		//pw.println("<a href=' /qlsvweb/menu-course' > Quay lai </a>");
	}
}
