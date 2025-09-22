package vn.iotstar.controllers.Category;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.controllers.Constant;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.services.CategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/admin/category/add" })
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024,
	    maxFileSize = 1024 * 1024 * 10,      // 10MB
	    maxRequestSize = 1024 * 1024 * 50    // 50MB
	)
public class CategoryAddController extends HttpServlet {
	CategoryService cateService = new CategoryServiceImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-category.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("name");
			Part part = req.getPart("image");
			//String realPath = req.getServletContext().getRealPath("/uploads");
			String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			
            File uploadDir = new File(Constant.DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            part.write(Constant.DIR + File.separator + filename);
            
            
			CategoryModel category = new CategoryModel();
			category.setCatename(name);
			category.setIcon(filename);
			cateService.insert(category);
			resp.sendRedirect(req.getContextPath() + "/admin/category/list");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
