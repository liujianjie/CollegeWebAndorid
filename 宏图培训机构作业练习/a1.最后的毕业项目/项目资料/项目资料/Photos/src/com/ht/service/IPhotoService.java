package com.ht.service;

import java.util.List;

import com.ht.vo.Photos;

public interface IPhotoService {
	public List list();
	public boolean add(Photos ph);
}
