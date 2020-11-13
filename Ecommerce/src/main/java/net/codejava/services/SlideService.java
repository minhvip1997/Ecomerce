package net.codejava.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.codejava.models.Account;
import net.codejava.models.Slide;

public interface SlideService  {
	public Iterable<Slide> findAll();
	
	public Slide save(Slide slide);
	public void delete(int id);
	public Slide find(int id);
	public List<Slide> findAllWithStatus(boolean status);
}
