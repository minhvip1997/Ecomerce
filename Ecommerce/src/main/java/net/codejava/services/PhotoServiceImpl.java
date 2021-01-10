package net.codejava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.models.Photo;
import net.codejava.repositories.PhotoRepository;

@Transactional
@Service
public class PhotoServiceImpl implements PhotoService{

	@Autowired
	private PhotoRepository photoRepository;
	
	@Override
	public Photo save(Photo photo) {
		
		return photoRepository.save(photo);
	}

	@Override
	public void delete(int id) {
		photoRepository.deleteById(id);
        System.out.println("minh dep trai so 2");
        System.out.println("ai dam nhan minh 4 ai dam nhan minh 1");
        System.out.println("pull: Lấy nội dung của remote repository");
	}

	@Override
	public Photo find(int id) {
		
		return photoRepository.findById(id).get();
	}

}
