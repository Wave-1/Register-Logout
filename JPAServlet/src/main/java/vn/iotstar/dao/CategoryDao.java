package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.entity.Category;

public interface CategoryDao {
	List<Category> findAll();

	void insert(Category category);

	void update(Category category);

	Category edit(Category category);

	void delete(int id);

	Category get(int id);

	Category get(String name);

	List<Category> findByName(String keyword);

}
