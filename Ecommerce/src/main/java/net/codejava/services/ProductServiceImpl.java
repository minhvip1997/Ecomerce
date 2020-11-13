package net.codejava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.models.Product;
import net.codejava.repositories.ProductRepository;

@Transactional
@Service
public class ProductServiceImpl implements ProductService{
@Autowired
private ProductRepository productRepository;
	@Override
	public Iterable<Product> findAll() {
		
		return productRepository.findAll();
	}
	@Override
	public Product save(Product product) {
		
		return productRepository.save(product);
	}
	@Override
	public void delete(int id) {
		productRepository.deleteById(id);
		
	}
	@Override
	public Product find(int id) {
		
		return productRepository.findById(id).get();
	}
	@Override
	public List<Product> latestProducts(boolean status, int n) {
		
		return productRepository.latestProducts(status, n);
	}
	@Override
	public List<Product> featuredProducts(boolean status, boolean featured, int n) {
		
		return productRepository.featuredProducts(status, featured, n);
	}
	@Override
	public List<Product> relatedProducts(boolean status, int categoryid, int id, int n) {
		
		return productRepository.relatedProducts(status, categoryid, id, n);
	}
	@Override
	public List<Product> searchAll(boolean status, String keyword) {
		return productRepository.searchAll(status, keyword);
	}
	@Override
	public List<Product> searchByCategory(boolean status, String keyword, int categoryId) {
		return productRepository.searchByCategory(status, keyword, categoryId);
	}
	@Override
	public long count() {
		return productRepository.count();
	}
	

}
