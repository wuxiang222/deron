package com.wux.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.wux.annotation.Comment;
import com.wux.entity.Voice;

public interface VoiceService {
	//添加
	@Comment("增加音频")
	public void addVoice(MultipartFile file, HttpServletRequest req, HttpSession session, Voice v);
	//删除
	@Comment("删除音频")
	public void dropVoiceById(HttpSession session, String id);
	//修改
	@Comment("修改音频")
	public void changeVoiceById(Voice v);
	//单查
	@Comment("查询音频")
	public Voice queryById(String id);
	//根据外键查
	@Comment("查询专辑所有音频")
	public List<Voice> queryBySpecialID(String specialID);
}
