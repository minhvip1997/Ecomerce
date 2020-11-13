package net.codejava.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


import net.codejava.models.InvoiceDetails;
import net.codejava.models.InvoiceDetailsId;

@Repository
public interface InvoiceDetailsRepository extends CrudRepository<InvoiceDetails, InvoiceDetailsId> {
	
}
