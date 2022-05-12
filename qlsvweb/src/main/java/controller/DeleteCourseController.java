package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CourseService;
import service.CourseServiceImpl;

@WebServlet(urlPatterns = "/delete-course") 
public class DeleteCourseController extends HttpServlet { 
	
	CourseService courseService = new CourseServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//?id = xxx
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();//de tra ve trang nay
				
		String idStr = req.getParameter("id"); // map giua key va value // ben kia dang dung ? id ==> ben nay doc tham so id map dung ben kia, neu ben truyen di la x thif trong ngoac sua la x
		// muon truyen cai gi len thi cung doi ve string het 
		try {
		courseService.delete(Integer.parseInt(idStr));
		pw.println("<p> xoa thanh cong course id : " + idStr + "</p>");
		} catch(NumberFormatException e) {
			e.printStackTrace();
			pw.println("<p> Sai du lieu id </p>");
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("<p> loi server </p>");
		}
		pw.println("<a href=' /qlsvweb/menu-course' > Quay lai </a>");
		
		
	}
}
