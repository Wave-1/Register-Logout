package vn.iotstar.controllers.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import jakarta.persistence.EntityManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.configs.JPAConfig;
import vn.iotstar.entity.Category;

@WebServlet(urlPatterns = { "/admin/edit-category" })
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,  // 2MB
        maxFileSize = 1024 * 1024 * 10,       // 10MB
        maxRequestSize = 1024 * 1024 * 50     // 50MB
)
public class EditCategoryController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIR = "D:/uploads";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        EntityManager em = JPAConfig.getEntityManager();
        Category category = em.find(Category.class, id);
        em.close();

        req.setAttribute("category", category);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/edit-category.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Part part = req.getPart("image");

        EntityManager em = JPAConfig.getEntityManager();
        em.getTransaction().begin();

        Category category = em.find(Category.class, id);
        if (category != null) {
            category.setName(name);

            // nếu có upload hình mới thì cập nhật lại
            if (part != null && part.getSize() > 0) {
                Files.createDirectories(Paths.get(UPLOAD_DIR));
                String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                part.write(UPLOAD_DIR + "/" + filename);
                category.setImages(filename);
            }
        }

        em.getTransaction().commit();
        em.close();

        resp.sendRedirect(req.getContextPath() + "/admin/categories");
    }
}
