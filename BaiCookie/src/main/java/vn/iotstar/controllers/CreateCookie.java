package vn.iotstar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/cookie")
public class CreateCookie extends HttpServlet{

	private static final long serialVersionUID = 1L;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String ten = req.getParameter("ten");
			String ho = req.getParameter("ho");
			
			Cookie fstName = new Cookie("ten", ten);
			Cookie lstName = new Cookie("ho", ho);
			
			fstName.setMaxAge(60*60*24);
			lstName.setMaxAge(60*60*24);
			
			resp.addCookie(fstName);
			resp.addCookie(fstName);
			
			PrintWriter out = resp.getWriter();
			out.println("<b>Ho: <b>" + lstName.getValue() + "Ten:" + fstName.getValue());
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		}
}
