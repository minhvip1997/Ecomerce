package net.codejava.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import net.codejava.models.Product;

public interface ProductService {
	public Iterable<Product> findAll();

	public Product save(Product product);

	public void delete(int id);

	public Product find(int id);
	
	public List<Product> latestProducts(boolean status,int n);
	
	public List<Product> featuredProducts(boolean status,boolean featured,int n);
	public List<Product> relatedProducts(boolean status,int categoryid,int id,int n);
	public List<Product> searchAll(boolean status,String keyword);
	public List<Product> searchByCategory(boolean status,String keyword, int categoryId);
	public long count();
}
