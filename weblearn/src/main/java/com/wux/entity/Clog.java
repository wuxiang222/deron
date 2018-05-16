package com.wux.entity;

import java.io.Serializable;
import java.util.Date;

public class Clog implements Serializable {
	private String id;
	private String username;
	private String time;
	private String detail;
	private String type;
	public Clog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Clog(String id, String username, String time, String detail,
			String type) {
		super();
		this.id = id;
		this.username = username;
		this.time = time;
		this.detail = detail;
		this.type = type;
	}
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Clog [id=" + id + ", username=" + username + ", time=" + time
				+ ", detail=" + detail + ", type=" + type + "]";
	}
}
