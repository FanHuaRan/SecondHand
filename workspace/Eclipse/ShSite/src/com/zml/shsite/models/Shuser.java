package com.zml.shsite.models;

import java.util.HashSet;
import java.util.Set;

/**
 * Shuser entity. @author MyEclipse Persistence Tools
 */

public class Shuser implements java.io.Serializable {

	// Fields

	private Integer shUserId;
	private String shUserName;
	private String password;
	private Short gender;
	private String introduce;
	private String phone;
	private String address;
	private Set goods = new HashSet(0);
	private Set goodcollects = new HashSet(0);
	private Set authorities = new HashSet(0);
	private Set goodcomments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Shuser() {
	}

	/** minimal constructor */
	public Shuser(String shUserName, String password, Short gender, String introduce, String phone, String address) {
		this.shUserName = shUserName;
		this.password = password;
		this.gender = gender;
		this.introduce = introduce;
		this.phone = phone;
		this.address = address;
	}

	/** full constructor */
	public Shuser(String shUserName, String password, Short gender, String introduce, String phone, String address,
			Set goods, Set goodcollects, Set authorities, Set goodcomments) {
		this.shUserName = shUserName;
		this.password = password;
		this.gender = gender;
		this.introduce = introduce;
		this.phone = phone;
		this.address = address;
		this.goods = goods;
		this.goodcollects = goodcollects;
		this.authorities = authorities;
		this.goodcomments = goodcomments;
	}

	// Property accessors

	public Integer getShUserId() {
		return this.shUserId;
	}

	public void setShUserId(Integer shUserId) {
		this.shUserId = shUserId;
	}

	public String getShUserName() {
		return this.shUserName;
	}

	public void setShUserName(String shUserName) {
		this.shUserName = shUserName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Short getGender() {
		return this.gender;
	}

	public void setGender(Short gender) {
		this.gender = gender;
	}

	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set getGoods() {
		return this.goods;
	}

	public void setGoods(Set goods) {
		this.goods = goods;
	}

	public Set getGoodcollects() {
		return this.goodcollects;
	}

	public void setGoodcollects(Set goodcollects) {
		this.goodcollects = goodcollects;
	}

	public Set getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(Set authorities) {
		this.authorities = authorities;
	}

	public Set getGoodcomments() {
		return this.goodcomments;
	}

	public void setGoodcomments(Set goodcomments) {
		this.goodcomments = goodcomments;
	}

}