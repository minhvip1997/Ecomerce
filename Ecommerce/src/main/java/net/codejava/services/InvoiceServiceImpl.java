package net.codejava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.models.Category;
import net.codejava.models.Invoice;
import net.codejava.repositories.CategoryRepository;
import net.codejava.repositories.InvoiceRepository;
@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService{
 @Autowired
 private InvoiceRepository invoiceRepository;

@Override
public Invoice save(Invoice invoice) {
	return invoiceRepository.save(invoice);
}

@Override
public List<Invoice> findAllWithOrder(String username) {
	return invoiceRepository.findAllWithOrder(username);
}

@Override
public Invoice findById(int id) {
	return invoiceRepository.findById(id).get();
}

@Override
public List<Invoice> findAllWithOrder() {
	
	return invoiceRepository.findAllWithOrder();
}

@Override
public Long countNewInvoices(String status) {
	return invoiceRepository.countNewInvoices(status);
}
	
}
