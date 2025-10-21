package vn.iotstar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/show"})
public class ShowSession extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		String ten = "";
				
		HttpSession s = req.getSession();
		Object obj = s.getAttribute("ten");
		
		if(obj != null) {
			ten = String.valueOf(obj);
		}else {
			resp.sendRedirect("/HelloServlet/create");
		}
		
		int tuoi = (Integer)s.getAttribute("tuoi");
		
		out.println("Xin chao ban " + ten + "tuoi " + tuoi);
		out.close();
	}
}
