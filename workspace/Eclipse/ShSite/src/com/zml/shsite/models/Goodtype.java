package com.zml.shsite.models;

import java.util.HashSet;
import java.util.Set;

/**
 * Goodtype entity. @author MyEclipse Persistence Tools
 */

public class Goodtype implements java.io.Serializable {

	// Fields

	private Integer goodTypeId;
	private String goodTypeName;

	// Constructors

	/** default constructor */
	public Goodtype() {
	}

	/** minimal constructor */
	public Goodtype(Integer goodTypeId) {
		this.goodTypeId = goodTypeId;
	}

	/** full constructor */
	public Goodtype(Integer goodTypeId,String goodTypeName) {
		this.goodTypeId = goodTypeId;
		this.goodTypeName = goodTypeName;
	}

	// Property accessors

	public Integer getGoodTypeId() {
		return this.goodTypeId;
	}

	public void setGoodTypeId(Integer goodTypeId) {
		this.goodTypeId = goodTypeId;
	}

	public String getGoodTypeName() {
		return this.goodTypeName;
	}

	public void setGoodTypeName(String goodTypeName) {
		this.goodTypeName = goodTypeName;
	}
}