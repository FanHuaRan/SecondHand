package com.zml.shsite.services;

import java.util.List;

import com.zml.shsite.models.Goodcomment;

public interface IGoodCommentService {
	List<Goodcomment> findGoodCommentByUserId(int id);
	List<Goodcomment> findGoodCommentByGoodId(int id);
	Goodcomment save(Goodcomment goodcomment);
}
