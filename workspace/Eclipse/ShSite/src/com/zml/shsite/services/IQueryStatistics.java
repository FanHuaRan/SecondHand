package com.zml.shsite.services;

import java.util.List;

import com.zml.shsite.models.Good;

public interface IQueryStatistics {
	 List<Integer> statisGoodCommentCount(List<Good> goods);
	 List<Integer> statisGoodCollectCount(List<Good> goods);
}
