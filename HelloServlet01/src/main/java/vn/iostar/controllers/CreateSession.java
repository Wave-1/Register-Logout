package vn.iostar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/createsession")
public class CreateSession extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		s.setAttribute("ten", "Tran Trong Tan");
		s.setAttribute("tuoi", new Integer(23));
		
		s.setMaxInactiveInterval(30);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("Xin chao ban session da duoc tao");
		out.close();
	}
}
