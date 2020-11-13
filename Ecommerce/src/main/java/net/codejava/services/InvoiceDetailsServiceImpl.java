package net.codejava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.models.Category;
import net.codejava.models.Invoice;
import net.codejava.models.InvoiceDetails;
import net.codejava.repositories.CategoryRepository;
import net.codejava.repositories.InvoiceDetailsRepository;
import net.codejava.repositories.InvoiceRepository;

@Service
@Transactional
public class InvoiceDetailsServiceImpl implements InvoiceDetailsService {
	@Autowired
	private InvoiceDetailsRepository invoiceDetailsRepository;

	@Override
	public InvoiceDetails save(InvoiceDetails invoiceDetails) {
		
		return invoiceDetailsRepository.save(invoiceDetails);
	}

	
}

