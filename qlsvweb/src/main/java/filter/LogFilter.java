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

@WebFilter(urlPatterns = {"/*"})
public class LogFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("IP:" + request.getRemoteAddr());
		// cho di qua
		chain.doFilter(request, response);
		HttpServletResponse resp = (HttpServletResponse) response;//ep kieu xuong de su dung ham cua thang con
//		PrintWriter pw = resp.getWriter();
//		pw.println("STOPP");
//		pw.close();
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		String s = (String) session.getAttribute("uname");
		System.out.println("SESSION " + session.getId());
		System.out.println(s);
	}
}
