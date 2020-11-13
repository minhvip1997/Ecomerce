package net.codejava.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import net.codejava.models.Category;
import net.codejava.models.Invoice;
import net.codejava.models.InvoiceDetails;

public interface InvoiceDetailsService {
	

	public InvoiceDetails save(InvoiceDetails invoiceDetails);

	
}
