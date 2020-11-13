package net.codejava.services;

import net.codejava.models.Photo;

public interface PhotoService {
	public Photo save(Photo photo);
	public void delete(int id);
	public Photo find(int id);
}
