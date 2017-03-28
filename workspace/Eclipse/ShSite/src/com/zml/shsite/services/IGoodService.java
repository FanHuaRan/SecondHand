package com.zml.shsite.services;

import java.util.List;

import com.zml.shsite.models.Good;

public interface IGoodService {
	Good findById(int id);
	List<Good> findByNameKey(String key);
	List<Good> findAll();
	List<Good> findByGoodType(int goodTypeId);
	List<Good> findTopOrderByTime(int count);
	List<Good> findByUserId(int id);
	void removeById(int id);
	void removeAll();
	Good save(Good good);
	Good update(Good good);
}
