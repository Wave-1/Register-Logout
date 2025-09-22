package vn.iotstar.services.impl;

import java.io.File;
import java.util.List;

import vn.iotstar.daos.CategoryDao;
import vn.iotstar.daos.impl.CategoryDAOImpl;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.services.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryDao categoryDao = new CategoryDAOImpl();

	@Override
	public void insert(CategoryModel category) {
		categoryDao.insert(category);

	}
	

	@Override
	public void edit(CategoryModel newCategory) {
		CategoryModel oldCate = categoryDao.get(newCategory.getCateid());
		oldCate.setCatename(newCategory.getCatename());
		if (newCategory.getIcon() != null) {
			// XOA ANH CU DI
			String fileName = oldCate.getIcon();
			final String dir = "E:\\upload";
			File file = new File(dir + "/category" + fileName);
			if (file.exists()) {
				file.delete();
			}
			oldCate.setIcon(newCategory.getIcon());
		}

		categoryDao.edit(oldCate);

	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);
	}

	@Override
	public CategoryModel get(int id) {
		return categoryDao.get(id);

	}

	@Override
	public CategoryModel get(String name) {
		return categoryDao.get(name);
	}

	@Override
	public List<CategoryModel> getAll() {
		return categoryDao.getAll();
	}

	@Override
	public List<CategoryModel> search(String catename) {
		return categoryDao.search(catename);
	}


	@Override
	public void update(CategoryModel category) {
		categoryDao.update(category);
		
	}

}
