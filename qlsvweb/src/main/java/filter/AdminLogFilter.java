package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/admin/*" })
public class AdminLogFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// cho di qua
		// chain.doFilter(request, response);
		HttpServletResponse resp = (HttpServletResponse) response;// ep kieu xuong de su dung ham cua thang con
		
		String username = request.getParameter("username");
		
		if(username.equals("admin")) {
	//		chain.doFilter(request, response);
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			
			session.setAttribute("uname", username);
			System.out.println(session.getId());
			chain.doFilter(request, response);
	} else {
		resp.sendRedirect("qlsv/menu-course");
	}
}
}
