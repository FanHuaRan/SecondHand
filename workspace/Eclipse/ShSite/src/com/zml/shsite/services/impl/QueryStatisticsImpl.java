package com.zml.shsite.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zml.shsite.daos.CommonStatistics;
import com.zml.shsite.models.Good;
import com.zml.shsite.services.IQueryStatistics;
@Service
public class QueryStatisticsImpl implements IQueryStatistics {
	@Autowired
	private CommonStatistics commonStatistics=null;
	@Override
	public List<Integer> statisGoodCommentCount(List<Good> goods) {
		List<Integer> results=new ArrayList<>();
		goods.forEach(good->{
			String hql="select ";
		});
		return null;
	}

	@Override
	public List<Integer> statisGoodCollectCount(List<Good> goods) {
		// TODO Auto-generated method stub
		return null;
	}

}