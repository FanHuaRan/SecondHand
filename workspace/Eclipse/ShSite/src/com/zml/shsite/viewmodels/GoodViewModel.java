package com.zml.shsite.viewmodels;

import com.zml.shsite.models.Good;

public class GoodViewModel{
	private Good good;
	private int commentCount;
	private int collectCount;
	public GoodViewModel(Good good){
		this.setGood(good);
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public int getCollectCount() {
		return collectCount;
	}
	public void setCollectCount(int collectCount) {
		this.collectCount = collectCount;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	
}
