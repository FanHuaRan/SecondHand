package com.zml.shsite.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zml.shsite.daos.GoodDAO;
import com.zml.shsite.daos.GoodcollectDAO;
import com.zml.shsite.daos.GoodcommentDAO;
import com.zml.shsite.models.Good;
import com.zml.shsite.services.IGoodService; 
@Service
public  class GoodServiceImpl implements IGoodService {
	@Autowired
	private GoodcollectDAO goodcollectDAO=null;
	@Autowired 
	private GoodcommentDAO goodcommentDAO=null;
	@Autowired
	private GoodDAO goodDao=null;
	@Override
	public Good findById(int id) {
		return goodDao.findById(id);
	}

	@Override
	public List<Good> findAll() {
		return goodDao.findAll();
	}

	@Override
	public List<Good> findTopOrderByTime(int count) {
		return goodDao.findTopNByHQL("from Good order by desTime asc ", 4);
	}

	@Override
	public void removeById(int id) {
		goodcommentDAO.deleteByGoodId(id);
		goodcollectDAO.deleteByGoodId(id);
		goodDao.delete(id);
	}

	@Override
	public void removeAll() {
		goodcollectDAO.deleteAll();
		goodcommentDAO.deleteAll();
		goodDao.deleteAll();
	}

	@Override
	public Good save(Good good) {
		goodDao.save(good);
		return good;
	}

	@Override
	public Good update(Good good) {
		goodDao.update(good);
		return good;
	}

	@Override
	public List<Good> findByGoodType(int goodTypeId) {
		return goodDao.findBygoodTypeId(goodTypeId);
	}

	@Override
	public List<Good> findByUserId(int id) {
		return goodDao.findByShUserId(id);
	}

	@Override
	public List<Good> findByNameKey(String key) {
		String hql="from Good as good where good.goodName like '%"+key+"%'";
		return goodDao.findByHQL(hql);
	}

}
