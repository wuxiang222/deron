package com.wux.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wux.dao.VoiceDao;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.wux.dao.VoiceDao;
import com.wux.entity.Voice;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class VoiceServiceImpl implements VoiceService {
	
	@Autowired
	private VoiceDao vd;

	@Override
	public void addVoice(MultipartFile file, HttpServletRequest req,HttpSession session, Voice v) {
		//获取文件路径
		String realPath = session.getServletContext().getRealPath("/");
		String parent = new File(realPath).getParent();
		String path = parent+File.separator+"upload";
		File file2 = new File(path);
		if(!file2.exists()){
			file2.mkdir();
		}
		//重新命名存储的文件名（唯一）
		String sdf = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date());
		String id = UUID.randomUUID().toString().replace("-", "");
		String name = file.getOriginalFilename();
		String extension = FilenameUtils.getExtension(name);
		String realname = sdf + id + "." +extension;
		//上传
		File upfile = new File(path,realname);
		try {
			file.transferTo(upfile);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//网络路径
		String netPath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+"/upload/"+realname;
		//入数据库
		v.setId(id);
		v.setName(name);
		v.setPublish(new Date());
		v.setRealname(realname);
		v.setStatus(false);
		v.setType("voice");
		v.setUrl(netPath);
		vd.insertVoice(v);
	}

	@Override
	public void dropVoiceById(HttpSession session, String id) {
		Voice vo = vd.selectById(id);
		String realPath = session.getServletContext().getRealPath("/");
		String parent = new File(realPath).getParent();
		File target = new File(parent+"/upload/",vo.getRealname());
		//先删除文件
		target.delete();
		//再在数据库中删除
		vd.deleteVoiceById(id);
	}

	@Override
	public void changeVoiceById(Voice v) {
		vd.updateVoiceById(v);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public Voice   queryById(String id) {
		Voice voice = vd.selectById(id);
		return voice;
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Voice> queryBySpecialID(String specialID) {
		List<Voice> list = vd.selectBySpecialID(specialID);
		return list;
	}

}
