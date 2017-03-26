package com.zml.shsite.viewmodels;

import com.zml.shsite.models.Good;

public class GoodViewModel{
	private Good good;
	private long commentCount;
	private long collectCount;
	public GoodViewModel(Good good){
		this.setGood(good);
	}
	public long getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(long commentCount) {
		this.commentCount = commentCount;
	}
	public long getCollectCount() {
		return collectCount;
	}
	public void setCollectCount(long collectCount) {
		this.collectCount = collectCount;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	
}
