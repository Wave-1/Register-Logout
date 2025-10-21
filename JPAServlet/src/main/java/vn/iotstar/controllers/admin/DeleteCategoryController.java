package vn.iotstar.controllers.admin;

import java.io.IOException;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.configs.JPAConfig;
import vn.iotstar.entity.Category;

@WebServlet(urlPatterns = { "/admin/delete-category" })
public class DeleteCategoryController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            EntityManager em = JPAConfig.getEntityManager();

            em.getTransaction().begin();
            Category cate = em.find(Category.class, id);
            if (cate != null) {
                em.remove(cate);
            }
            em.getTransaction().commit();
            em.close();

            resp.sendRedirect(req.getContextPath() + "/admin/categories");

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi khi xóa category!");
        }
    }
}
