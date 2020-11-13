package net.codejava.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.codejava.models.Account;
import net.codejava.models.Category;

public interface AccountRepository extends CrudRepository<Account, Integer> {
	public Account findByUsername(String username);

	@Query("from Account where role.id = :roleId")
	public List<Account> findAllCustomer(@Param("roleId") int roleId);
	
	@Query("select count(id)from Account where role.id = 2")
	public Long countCustomer();
}
