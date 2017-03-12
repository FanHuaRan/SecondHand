package com.zml.shsite.services;

import java.util.List;

import com.zml.shsite.models.Good;

public interface IGoodService {
	Good findById(int id);
	List<Good> findAll();
	List<Good> findTopN(int count);
	void removeById(int id);
	void removeAll();
	Good save(Good good);
	Good update(Good good);
}
