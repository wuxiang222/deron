package com.wux.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class Special implements Serializable{

	private String id;
	private String name;
	private String realname;
	private String type;
	private String url;
	private String author;
	private String broadcast;
	private String level;
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss:SSS")
//	@JSONField(format="yyyy-MM-dd HH:mm:ss:SSS")
	private Date publish;
	private Boolean status;
	private String guru_id;
	private String content;
	private List<Voice> children;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBroadcast() {
		return broadcast;
	}
	public void setBroadcast(String broadcast) {
		this.broadcast = broadcast;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Date getPublish() {
		return publish;
	}
	public void setPublish(Date publish) {
		this.publish = publish;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Voice> getChildren() {
		return children;
	}
	public void setChildren(List<Voice> children) {
		this.children = children;
	}
	public String getGuru_id() {
		return guru_id;
	}
	public void setGuru_id(String guru_id) {
		this.guru_id = guru_id;
	}
	@Override
	public String toString() {
		return "Special [id=" + id + ", name=" + name + ", realname="
				+ realname + ", type=" + type + ", url=" + url + ", author="
				+ author + ", broadcast=" + broadcast + ", level=" + level
				+ ", publish=" + publish + ", status=" + status + ", guru_id="
				+ guru_id + ", content=" + content + ", children=" + children
				+ "]";
	}
	
	
}
