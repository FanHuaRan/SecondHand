package com.zml.shsite.models;

/**
 * Goodcollect entity. @author MyEclipse Persistence Tools
 */

public class Goodcollect implements java.io.Serializable {

	// Fields

	private Integer goodCollectId;
	private Integer shUserId;
	private Integer goodId;
	private Shuser shuser;
	private Good good;

	// Constructors

	/** default constructor */
	public Goodcollect() {
	}

	/** full constructor */
	public Goodcollect(Integer shUserId,Integer goodId){
		this.setShUserId(shUserId);
		this.setGoodId(goodId);
	}
	public Goodcollect(Shuser shuser, Good good) {
		this.shuser = shuser;
		this.good = good;
	}

	// Property accessors

	public Integer getGoodCollectId() {
		return this.goodCollectId;
	}

	public void setGoodCollectId(Integer goodCollectId) {
		this.goodCollectId = goodCollectId;
	}

	public Shuser getShuser() {
		return this.shuser;
	}

	public void setShuser(Shuser shuser) {
		this.shuser = shuser;
	}

	public Good getGood() {
		return this.good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public Integer getShUserId() {
		return shUserId;
	}

	public void setShUserId(Integer shUserId) {
		this.shUserId = shUserId;
	}

	public Integer getGoodId() {
		return goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

}