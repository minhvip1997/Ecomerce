package net.codejava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.models.Category;
import net.codejava.repositories.CategoryRepository;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
 @Autowired
 private CategoryRepository categoryRepository;
	@Override
	public Iterable<Category> findAll() {
		
		return categoryRepository.findAll();
	}
	@Override
	public List<Category> findParentCategories() {
		
		return categoryRepository.findParentCategories();
	}
	@Override
	public Category save(Category category) {
		
		return categoryRepository.save(category);
	}
	@Override
	public void delete(int id) {
		categoryRepository.deleteById(id);
	}
	@Override
	public Category findById(int id) {
		
		return categoryRepository.findById(id).get();
	}
	@Override
	public List<Category> findParentCategoriesWithStatus(boolean status) {
		
		return categoryRepository.findParentCategoriesWithStatus(status);
	}
	@Override
	public Category find(int id) {
	return categoryRepository.findById(id).get();
	}
	@Override
	public long count() {
		return categoryRepository.count();
	}

}
