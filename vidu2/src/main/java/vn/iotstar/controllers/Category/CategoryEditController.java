package vn.iotstar.controllers.Category;

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

@WebServlet(urlPatterns = { "/admin/category/edit" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class CategoryEditController extends HttpServlet {

	CategoryService cateService = new CategoryServiceImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		CategoryModel category = cateService.get(Integer.parseInt(id));
		req.setAttribute("category", category);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/edit-category.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");

            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            Part part = req.getPart("image");

            String realPath = Constant.DIR;
            Files.createDirectories(Paths.get(realPath));

            String filename = null;
            if (part != null) {
                String submittedFileName = part.getSubmittedFileName();
                if (submittedFileName != null && !submittedFileName.isEmpty()) {
                    filename = Paths.get(submittedFileName).getFileName().toString();
                    part.write(realPath + "/" + filename);
                }
            }

            CategoryModel old = cateService.get(id);

            CategoryModel category = new CategoryModel();
            category.setCateid(id);
            category.setCatename(name);

            if (filename != null) {
                category.setIcon(filename);
            } else if (old != null) {
                category.setIcon(old.getIcon());
            }

            cateService.update(category);
            resp.sendRedirect(req.getContextPath() + "/admin/category/list");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
