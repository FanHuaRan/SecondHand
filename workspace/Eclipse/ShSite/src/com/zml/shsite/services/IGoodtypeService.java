package com.zml.shsite.services;

import java.util.List;

import com.zml.shsite.models.Goodtype;

public interface IGoodtypeService {
	Goodtype findById(int id);
	List<Goodtype> findAll();
}
