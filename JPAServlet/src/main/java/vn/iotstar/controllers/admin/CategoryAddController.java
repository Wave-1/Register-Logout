package vn.iotstar.controllers.admin;

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
import vn.iotstar.entity.Category;
import vn.iotstar.services.CategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/admin/category/add" })
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	maxFileSize = 1024 * 1024 * 10,     // 10MB
	maxRequestSize = 1024 * 1024 * 50   // 50MB
)
public class CategoryAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "D:/uploads"; // nơi lưu ảnh

	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-category.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");

			String name = req.getParameter("name");
			Part part = req.getPart("image");
			String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();

			// Tạo thư mục upload nếu chưa tồn tại
			File uploadDir = new File(UPLOAD_DIR);
			if (!uploadDir.exists()) {
				uploadDir.mkdirs();
			}

			// Lưu file lên ổ đĩa
			if (!fileName.isEmpty()) {
				part.write(UPLOAD_DIR + File.separator + fileName);
			}

			// Tạo đối tượng Category và lưu vào DB
			Category cate = new Category();
			cate.setName(name);
			cate.setImages(fileName);

			cateService.insert(cate);

			resp.sendRedirect(req.getContextPath() + "/admin/categories");

		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("<h3 style='color:red'>❌ Lỗi khi thêm danh mục: " + e.getMessage() + "</h3>");
		}
	}
}
