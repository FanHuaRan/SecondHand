package com.zml.shsite.models;

import java.util.HashSet;
import java.util.Set;

/**
 * Shrole entity. @author MyEclipse Persistence Tools
 */

public class Shrole implements java.io.Serializable {

	// Fields

	private Short shRoleId;
	private String shRoleName;

	// Constructors

	/** default constructor */
	public Shrole() {
	}

	/** minimal constructor */
	public Shrole(Short shRoleId) {
		this.shRoleId = shRoleId;
	}

	/** full constructor */
	public Shrole(Short shRoleId,String shRoleName) {
		this.shRoleName = shRoleName;
		this.shRoleId = shRoleId;
	}

	// Property accessors

	public Short getShRoleId() {
		return this.shRoleId;
	}

	public void setShRoleId(Short shRoleId) {
		this.shRoleId = shRoleId;
	}

	public String getShRoleName() {
		return this.shRoleName;
	}

	public void setShRoleName(String shRoleName) {
		this.shRoleName = shRoleName;
	}
}