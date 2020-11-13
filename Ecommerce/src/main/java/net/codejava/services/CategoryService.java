package net.codejava.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import net.codejava.models.Category;

public interface CategoryService {
	public Iterable<Category> findAll();

	public List<Category> findParentCategories();
	
	public Category find(int id);

	public Category save(Category category);

	public void delete(int id);

	public Category findById(int id);
	
	public List<Category> findParentCategoriesWithStatus(boolean status);
	
	public long count();
}
