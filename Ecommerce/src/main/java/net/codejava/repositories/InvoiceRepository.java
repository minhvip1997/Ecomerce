package net.codejava.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.codejava.models.Category;
import net.codejava.models.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {
	@Query("from Invoice where account.username =:username order by id desc")
	public List<Invoice> findAllWithOrder(@Param("username") String username);
	
	@Query("from Invoice  order by id desc")
	public List<Invoice> findAllWithOrder();
	
	@Query("select count(id) from Invoice where status = :status")
	public Long countNewInvoices(@Param("status") String status);
}
