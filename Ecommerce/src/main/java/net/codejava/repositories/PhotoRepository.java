package net.codejava.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.codejava.models.Photo;
@Repository
public interface PhotoRepository extends CrudRepository<Photo, Integer>{

}
