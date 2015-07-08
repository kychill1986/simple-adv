package com.yang.simple.entity;

import com.yang.framework.dal.object.AbstractDO;

public class Users extends AbstractDO {

	/**   */
	private static final long serialVersionUID = -5873691974645631359L;

	private String id;

	private String username;

	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}