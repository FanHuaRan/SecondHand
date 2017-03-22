package com.zml.shsite.services;

import java.util.List;

import com.zml.shsite.models.Good;
import com.zml.shsite.viewmodels.GoodViewModel;

public interface ICreateGoodViewModel {
	GoodViewModel create(Good good);
	List<GoodViewModel> create(List<Good> goods);
}
