package com.wux.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wux.dao.SpecialDao;
import com.wux.dao.VoiceDao;
import com.wux.entity.Special;
import com.wux.entity.Voice;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.wux.dao.SpecialDao;
import com.wux.dao.VoiceDao;
import com.wux.entity.Special;
import com.wux.entity.Voice;

@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class SpecialServiceImpl implements SpecialService {

	@Autowired
	private SpecialDao sd;
	@Autowired
	private VoiceDao vd;
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Special> queryByPage(Integer currentPage, Integer rows) {
		int begin = (currentPage-1)*rows;
		List<Special> list = sd.queryByPage(begin, rows);
		return list;
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public Integer count() {
		Integer count = sd.queryCount();
		return count;
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public Special selectById(String id) {
		Special special = sd.selectById(id);
		return special;
	}

	@Override
	public void del(String id,HttpSession session) {
		List<Voice> children = vd.selectBySpecialID(id);
		if(children!=null){
			System.out.println(children);
			String realPath1 = session.getServletContext().getRealPath("/");
			String parent1 = new File(realPath1).getParent();
			for(Voice v:children){
				File target1 = new File(parent1+"/upload/",v.getRealname());
				//先删除文件
				target1.delete();
			}
			vd.deleteBySpecialID(id);
		}
		Special spl = sd.selectById(id);
		String realPath2 = session.getServletContext().getRealPath("/");
		String parent2 = new File(realPath2).getParent();
		File target2 = new File(parent2+"/upload/",spl.getRealname());
		//先删除文件
		target2.delete();
		//再在数据库中删除
		sd.del(id);
	}

	@Override
	public void add(MultipartFile file, HttpServletRequest req, HttpSession session,Special s) {
		//文件上传
		//1、路径
		//获得项目所在的路径
		String realPath = session.getServletContext().getRealPath("/");
		//获得文件所在路径的父级
		String parent = new File(realPath).getParent();
		//文件上传之后的存储路径
		String path = parent +File.separator + "upload";
		File file2 = new File(path);
		//判断文件夹是否存在
		if(!file2.exists()){
			file2.mkdir();
		}
		//2、存储的文件名
		//获得原有文件的后缀名
		String name = file.getOriginalFilename();
		String extension = FilenameUtils.getExtension(name);
		//UUID
		String id = UUID.randomUUID().toString().replace("-", "");
		//时间戳
		String sdf = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date());
		//拼接文件的存储名
		String realname = sdf + id + "." + extension;
		//3、上传入库
		//指定文件的路径+存储名称
		File upfile = new File(path,realname);
		try {
			file.transferTo(upfile);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//网络路径
		String netPath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+"/upload/"+realname;
		//入库
		s.setId(id);
		s.setPublish(new Date());
		s.setRealname(realname);
		s.setStatus(false);
		s.setType("special");
		s.setUrl(netPath);
		sd.add(s);
	}

	@Override
	public void update(Special special) {
		sd.update(special);
	}

}
