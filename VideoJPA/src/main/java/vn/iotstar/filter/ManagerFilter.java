package vn.iotstar.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.entity.User;

@WebFilter(urlPatterns = "/manager/*")
public class ManagerFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resq = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		Object object = session.getAttribute("account");
		User user = (User) object;
		
		if (user != null && user.getRoleid() == 3) {
			chain.doFilter(request, response);
			return;
		}else {
			resq.sendRedirect(req.getContextPath() + "/logout");
		}
		
	}

}
