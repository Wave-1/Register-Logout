package vn.iotstar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ReadCookie extends HttpServlet{
	@SuppressWarnings("unused")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = null;
		Cookie[] cookies = null;
		
		cookies = req.getCookies();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		if(cookie != null) {
			out.println("<h2>Found Cookie Name and Value</h2>");
			for(int i = 0; i < cookies.length; i++ ) {
				cookie = cookies[i];
				out.println("Name: " + cookie.getName() + ", ");
				out.println("Value: " + cookie.getValue() + "</br>");
			}
		}else {
			out.println("<h2>No cookies founds</h2>");
		}
		out.close();
	}
}
