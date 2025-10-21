package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		if(user.equals("tan") && pass.equals("123")) {
			Cookie cookie = new Cookie("username", user);
			cookie.setMaxAge(30);
			resp.addCookie(cookie);
			resp.sendRedirect("/HelloServlet/hello");
		}else {
			resp.sendRedirect("/HelloServlet/login");
		}
	}
}
