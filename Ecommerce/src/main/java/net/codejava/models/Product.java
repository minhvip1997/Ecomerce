package net.codejava.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String name;
	private double price;
	private int quantity;
	private String description;
	private String details;
	private boolean status;
	private boolean featured;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category categorys;
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	private List<Photo> photos = new ArrayList<Photo>(0);
	
	@OneToMany(mappedBy = "products", fetch = FetchType.EAGER)
	private Set<InvoiceDetails> invoicedetails =new HashSet<InvoiceDetails>(0);
	
	public Product(int id, String name, double price, int quantity, String description, String details, boolean status,
			boolean featured, Category categorys, List<Photo> photos, Set<InvoiceDetails> invoicedetails) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.details = details;
		this.status = status;
		this.featured = featured;
		this.categorys = categorys;
		this.photos = photos;
		this.invoicedetails = invoicedetails;
	}
	public Product() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isFeatured() {
		return featured;
	}
	public void setFeatured(boolean featured) {
		this.featured = featured;
	}
	public Category getCategorys() {
		return categorys;
	}
	public void setCategorys(Category categorys) {
		this.categorys = categorys;
	}
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	public Set<InvoiceDetails> getInvoicedetails() {
		return invoicedetails;
	}
	public void setInvoicedetails(Set<InvoiceDetails> invoicedetails) {
		this.invoicedetails = invoicedetails;
	}
	
	
	
}
