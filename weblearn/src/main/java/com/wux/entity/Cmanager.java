package com.wux.entity;

import java.io.Serializable;

public class Cmanager implements Serializable {
	private String cmanager_id;
	private String username;
	private String password;
	private String salt;
	private Boolean  isblock;
	private String portrait;
	private String fname;
	public Cmanager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cmanager(String cmanager_id, String username, String password,
					String salt, Boolean isblock, String portrait, String fname) {
		super();
		this.cmanager_id = cmanager_id;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.isblock = isblock;
		this.portrait = portrait;
		this.fname = fname;
	}
	public String getCmanager_id() {
		return cmanager_id;
	}
	public void setCmanager_id(String cmanager_id) {
		this.cmanager_id = cmanager_id;
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
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Boolean getIsblock() {
		return isblock;
	}
	public void setIsblock(Boolean isblock) {
		this.isblock = isblock;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	@Override
	public String toString() {
		return "Cmanage [cmanager_id=" + cmanager_id + ", username=" + username
				+ ", password=" + password + ", salt=" + salt + ", isblock="
				+ isblock + ", portrait=" + portrait + ", fname=" + fname + "]";
	}
}
