package net.codejava.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_id")
	private Category category;
	private String name;
	private boolean status;
	@OneToMany(mappedBy = "category",fetch=FetchType.LAZY)
	private List<Category> categories = new ArrayList<Category>();
	@OneToMany(mappedBy = "categorys",fetch=FetchType.LAZY)
	private List<Product> products = new ArrayList<Product>();
	public Category() {
		super();
	}
	
	public Category(int id) {
		super();
		this.id = id;
	}

	public Category(int id, Category category, String name, boolean status, List<Category> categories) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.status = status;
		this.categories = categories;
	}
	

	public Category(int id, Category category, String name, boolean status, List<Category> categories,
			List<Product> products) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.status = status;
		this.categories = categories;
		this.products = products;
	}

	public Category(String name, boolean status) {
		super();
		this.name = name;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	

}
