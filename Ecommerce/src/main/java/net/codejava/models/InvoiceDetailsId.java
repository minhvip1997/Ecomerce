package net.codejava.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InvoiceDetailsId implements java.io.Serializable {
	@Column(name = "invoice_id")
	private int invoiceId;
	@Column(name = "product_id")
	private int productId;

	public InvoiceDetailsId() {
		super();
	}

	public InvoiceDetailsId(int invoiceId, int productId) {
		super();
		this.invoiceId = invoiceId;
		this.productId = productId;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}
