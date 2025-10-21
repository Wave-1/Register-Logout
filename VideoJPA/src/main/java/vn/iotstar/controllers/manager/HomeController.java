package vn.iotstar.controllers.manager;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.Dao.impl.VideoDao;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Video;
import vn.iotstar.service.ICategoryService;
import vn.iotstar.service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = {"/manager/home"})
public class HomeController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	ICategoryService categoryService = new CategoryServiceImpl();


	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			//lấy tất cả video

			VideoDao dao = new VideoDao();

			List<Video> list = dao.findAll();

			req.setAttribute("videos", list);

			//lấy tất cả category

			// khai báo danh sách và gọi hàm findAll() trong dao

			List<Category> listc = categoryService.findAll();

			// thông báo

			req.setAttribute("categorys", listc);

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", e.getMessage());

		}

		findAll(req, resp);

		RequestDispatcher rq = req.getRequestDispatcher("/views/web/home.jsp");

		rq.forward(req, resp);

	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {

			// khởi tạo DAO

			VideoDao dao = new VideoDao();

			// khai báo danh sách và gọi hàm findAll() trong dao

			List<Video> list = dao.findAll();

			// thông báo

			request.setAttribute("listP", list);

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}

	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//doGet(req, resp);

	}
}
