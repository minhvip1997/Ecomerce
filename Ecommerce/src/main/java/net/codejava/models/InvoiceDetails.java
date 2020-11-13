package net.codejava.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "invoice_details")
public class InvoiceDetails {
	@EmbeddedId
private InvoiceDetailsId id;
private double price;
private int quantity;
@ManyToOne
@JoinColumn(name="invoice_id",insertable=false, updatable=false)
private Invoice invoice;
@ManyToOne
@JoinColumn(name="product_id",insertable=false, updatable=false)
private Product products;
public InvoiceDetails() {
	super();
}
public InvoiceDetails(InvoiceDetailsId id, double price, int quantity, Invoice invoice, Product products) {
	super();
	this.id = id;
	this.price = price;
	this.quantity = quantity;
	this.invoice = invoice;
	this.products = products;
}
public InvoiceDetailsId getId() {
	return id;
}
public void setId(InvoiceDetailsId id) {
	this.id = id;
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
public Invoice getInvoice() {
	return invoice;
}
public void setInvoice(Invoice invoice) {
	this.invoice = invoice;
}
public Product getProducts() {
	return products;
}
public void setProducts(Product products) {
	this.products = products;
}

}
