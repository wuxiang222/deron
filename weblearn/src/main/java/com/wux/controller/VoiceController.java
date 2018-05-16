package com.wux.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wux.service.VoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wux.entity.Voice;
import com.wux.service.VoiceService;

@Controller
@RequestMapping("/voice")
public class VoiceController {
	
	@Autowired
	private VoiceService vs;
	
	@RequestMapping("/queryById")
	@ResponseBody
	public Voice queryById(String id){
		Voice voice = vs.queryById(id);
		return voice;
	}

	@RequestMapping("/del")
	@ResponseBody
	public void del(HttpSession session, String id){
		vs.dropVoiceById(session, id);
	}
	
	@RequestMapping("/change")
	@ResponseBody
	public void change(Voice v){
		vs.changeVoiceById(v);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public void addSpecial(MultipartHttpServletRequest mreq, HttpSession session, HttpServletRequest req,Voice v){
		List<MultipartFile> files = mreq.getFiles("file");
		for(MultipartFile file:files){
			vs.addVoice(file, req, session, v);
		}
	}
	
}
