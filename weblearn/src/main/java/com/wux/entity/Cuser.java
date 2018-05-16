package com.wux.entity;

import java.io.Serializable;

public class Cuser implements Serializable {
	private String user_id;
	private String cmanage_id;
	private String username;
	private String password;
	public Cuser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cuser(String user_id, String cmanage_id, String username,
			String password) {
		super();
		this.user_id = user_id;
		this.cmanage_id = cmanage_id;
		this.username = username;
		this.password = password;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCmanage_id() {
		return cmanage_id;
	}
	public void setCmanage_id(String cmanage_id) {
		this.cmanage_id = cmanage_id;
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
		return "Cuser [user_id=" + user_id + ", cmanage_id=" + cmanage_id
				+ ", username=" + username + ", password=" + password + "]";
	}
	
}
