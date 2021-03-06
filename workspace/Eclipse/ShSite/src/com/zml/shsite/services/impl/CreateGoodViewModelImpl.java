package com.zml.shsite.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zml.shsite.daos.CommonStatistics;
import com.zml.shsite.models.Good;
import com.zml.shsite.services.ICreateGoodViewModel;
import com.zml.shsite.viewmodels.GoodViewModel;
/**
 * GoodViewModel服务，也就是根据商品信息，
 * 查询其评论数和收藏数，从而包装为GoodViewModel
 * @author zml
 *
 */
@Service
public class CreateGoodViewModelImpl implements ICreateGoodViewModel {
	@Autowired
	private CommonStatistics commonStatistics=null;
	@Override
	public GoodViewModel create(Good good) {
		int id=good.getGoodId();
		long collectCount=(long)commonStatistics.statisUniqueResult("select count(*) from Goodcollect where goodId =?",id);
		long commentCount=(long)commonStatistics.statisUniqueResult("select count(*) from Goodcomment where goodId =?",id);
		GoodViewModel goodViewModel=new GoodViewModel(good);
		goodViewModel.setCollectCount(collectCount);
		goodViewModel.setCommentCount(commentCount);
		return goodViewModel;
	}

	@Override
	public List<GoodViewModel> create(List<Good> goods) {
		final List<GoodViewModel> goodViewModels=new ArrayList<>();
		goods.forEach(good->goodViewModels.add(create(good)));
		return goodViewModels;
	}

}
