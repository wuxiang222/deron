package com.wux.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class Voice implements Serializable{

	private String id;
	private String name;
	private String realname;
	private String type;
	private String url;
	private Boolean status;
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss:SSS")
//	@JSONField(format="yyyy-MM-dd HH:mm:ss:SSS")
	private Date publish;
	private String specialID;
	private Special special;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Date getPublish() {
		return publish;
	}
	public void setPublish(Date publish) {
		this.publish = publish;
	}
	public String getSpecialID() {
		return specialID;
	}
	public void setSpecialID(String specialID) {
		this.specialID = specialID;
	}
	public Special getSpecial() {
		return special;
	}
	public void setSpecial(Special special) {
		this.special = special;
	}
	@Override
	public String toString() {
		return "Voice [id=" + id + ", name=" + name + ", realname=" + realname
				+ ", type=" + type + ", url=" + url + ", status=" + status
				+ ", publish=" + publish + ", specialID=" + specialID
				+ ", special=" + special + "]";
	}
	
	
}
