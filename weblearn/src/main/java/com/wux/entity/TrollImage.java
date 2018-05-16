package com.wux.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.alibaba.fastjson.annotation.JSONField;
@XmlRootElement(name="header")
public class TrollImage implements Serializable {
	private String id;
	private String realname;
	private String uuidname;
	private String imgurl;
	private String description;
	private Boolean onstatus;
	private Boolean issave;
//	@JSONField(format="yyyy-MM-dd")
	private Date uptime;
	public TrollImage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TrollImage(String id, String realname, String uuidname,
			String imgurl, String description, Boolean onstatus,
			Boolean issave, Date uptime) {
		super();
		this.id = id;
		this.realname = realname;
		this.uuidname = uuidname;
		this.imgurl = imgurl;
		this.description = description;
		this.onstatus = onstatus;
		this.issave = issave;
		this.uptime = uptime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getUuidname() {
		return uuidname;
	}
	public void setUuidname(String uuidname) {
		this.uuidname = uuidname;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getOnstatus() {
		return onstatus;
	}
	public void setOnstatus(Boolean onstatus) {
		this.onstatus = onstatus;
	}
	public Boolean getIssave() {
		return issave;
	}
	public void setIssave(Boolean issave) {
		this.issave = issave;
	}
	public Date getUptime() {
		return uptime;
	}
	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}
	@Override
	public String toString() {
		return "TrollImage [id=" + id + ", realname=" + realname
				+ ", uuidname=" + uuidname + ", imgurl=" + imgurl
				+ ", description=" + description + ", onstatus=" + onstatus
				+ ", issave=" + issave + ", uptime=" + uptime + "]";
	}
}
