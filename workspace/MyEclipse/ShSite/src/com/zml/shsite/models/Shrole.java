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
	private Set authorities = new HashSet(0);

	// Constructors

	/** default constructor */
	public Shrole() {
	}

	/** minimal constructor */
	public Shrole(String shRoleName) {
		this.shRoleName = shRoleName;
	}

	/** full constructor */
	public Shrole(String shRoleName, Set authorities) {
		this.shRoleName = shRoleName;
		this.authorities = authorities;
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

	public Set getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(Set authorities) {
		this.authorities = authorities;
	}

}