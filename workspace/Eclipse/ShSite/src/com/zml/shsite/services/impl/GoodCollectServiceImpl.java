package com.zml.shsite.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zml.shsite.daos.GoodcollectDAO;
import com.zml.shsite.models.Goodcollect;
import com.zml.shsite.services.IGoodCollectService;
@Service
public class GoodCollectServiceImpl implements IGoodCollectService{
	@Autowired
	private GoodcollectDAO goodcollectDAO=null;
	@Override
	public List<Goodcollect> findGoodCollectsByUserId(Integer userId) {
		return goodcollectDAO.findByShUserId(userId);
	}

	@Override
	public Goodcollect saveGoodCollect(Goodcollect goodcollect) {
		goodcollectDAO.save(goodcollect);
		return goodcollect;
	}

	@Override
	public void remove(int id) {
		goodcollectDAO.delete(id);
	}

	@Override
	public boolean isCollect(int goodId, int userId) {
		 return !goodcollectDAO.findByHQL("from Goodcollect where goodId=? and shUserId=? ",goodId,userId).isEmpty();
	}

}
