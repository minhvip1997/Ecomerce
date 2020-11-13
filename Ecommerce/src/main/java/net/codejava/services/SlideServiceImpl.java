package net.codejava.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.codejava.models.Slide;
import net.codejava.repositories.SlideRepository;
@Service
@Transactional
public class SlideServiceImpl implements SlideService{

	@Autowired
	private SlideRepository slideRepository;
	@Override
	public Iterable<Slide> findAll() {
		return slideRepository.findAll();
	}
	@Override
	public Slide save(Slide slide) {
		return slideRepository.save(slide);
	}
	@Override
	public void delete(int id) {
		slideRepository.deleteById(id);
		
	}
	@Override
	public Slide find(int id) {
		return slideRepository.findById(id).get();
	}
	@Override
	public List<Slide> findAllWithStatus(boolean status) {
		return slideRepository.findAllWithStatus(status);
	}

}
