package net.codejava.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.codejava.models.Account;
import net.codejava.models.Category;
import net.codejava.models.Slide;
@Repository
public interface SlideRepository extends CrudRepository<Slide, Integer> {
	@Query("from Slide where Status = :status")
	public List<Slide> findAllWithStatus(@Param("status") boolean status);
}
