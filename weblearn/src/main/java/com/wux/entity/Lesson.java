package com.wux.entity;

import java.io.Serializable;

public class Lesson implements Serializable {
	private Integer lesson_id;
	private String lesson_name;
	private String lesson_type;
	private String user_id;
	public Lesson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lesson(Integer lesson_id, String lesson_name, String lesson_type,
			String user_id) {
		super();
		this.lesson_id = lesson_id;
		this.lesson_name = lesson_name;
		this.lesson_type = lesson_type;
		this.user_id = user_id;
	}
	public Integer getLesson_id() {
		return lesson_id;
	}
	public void setLesson_id(Integer lesson_id) {
		this.lesson_id = lesson_id;
	}
	public String getLesson_name() {
		return lesson_name;
	}
	public void setLesson_name(String lesson_name) {
		this.lesson_name = lesson_name;
	}
	public String getLesson_type() {
		return lesson_type;
	}
	public void setLesson_type(String lesson_type) {
		this.lesson_type = lesson_type;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Lesson [lesson_id=" + lesson_id + ", lesson_name="
				+ lesson_name + ", lesson_type=" + lesson_type + ", user_id="
				+ user_id + "]";
	}
}
