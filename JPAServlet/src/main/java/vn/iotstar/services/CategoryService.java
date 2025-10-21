package vn.iotstar.services;

import java.util.List;

import vn.iotstar.entity.*;

public interface CategoryService {
	void insert(Category category);

	void update(Category category);
	Category edit(Category category);

	void delete(int id);

	Category get(int id);

	Category get(String name);

	List<Category> findAll();
	List<Category> findByName(String keyword);

}
