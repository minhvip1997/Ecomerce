package net.codejava.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import net.codejava.models.Category;
import net.codejava.models.Invoice;

public interface InvoiceService {
	

	public Invoice save(Invoice invoice);

	public List<Invoice> findAllWithOrder(String username);
	
	public Invoice findById(int id);
	
	public List<Invoice> findAllWithOrder();
	
	public Long countNewInvoices(String status);
}
