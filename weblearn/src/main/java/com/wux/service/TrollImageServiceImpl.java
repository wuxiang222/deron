package com.wux.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.wux.dao.TrollImageDao;
import com.wux.entity.TrollImage;
import org.apache.commons.io.FilenameUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.wux.dao.TrollImageDao;
import com.wux.entity.TrollImage;

@Service
@Transactional
public class TrollImageServiceImpl implements TrollImageService {
	private static final String FILEPATH = "upload";
	@Autowired
	private TrollImageDao trollImageDao;

	@Override
	public void addTrollImage(MultipartFile source, HttpServletRequest req,
			TrollImage trollImage) {
		// 指定文件上传路径，项目部属服务器后，其根目录在磁盘的绝对路径
		String realPath = req.getSession().getServletContext().getRealPath("/");
		String webappsPath = new File(realPath).getParent();
		// // 指定文件上传路径，如果不存在则创建该目录
		File file = new File(webappsPath, FILEPATH);
		if (!file.exists()) {
			file.mkdir();
		}
		// 修改文件名: 时间戳+UUID+“。”后缀
		String originalFilename = source.getOriginalFilename();
		String newName = new SimpleDateFormat("yyyyMMddHHmmssSSS")
				.format(new Date())
				+ UUID.randomUUID().toString().replace("-", "")
				+ "."
				+ FilenameUtils.getExtension(originalFilename);

		// 上传文件，把路径 id 状态，放入数据库
		File file2 = new File(file, newName);
		try {
			source.transferTo(file2);
			String id = UUID.randomUUID().toString().replace("-", "");
			String netPath = req.getScheme() + "://" + req.getServerName()
					+ ":" + req.getServerPort() + "/" + FILEPATH + "/"
					+ newName;
			// 设置 上传的 论选图信息
			trollImage.setId(id);
			trollImage.setRealname(originalFilename);
			trollImage.setUuidname(newName);
			trollImage.setImgurl(netPath);
			trollImage.setOnstatus(false);
			trollImage.setIssave(true);
			trollImage.setUptime(new java.sql.Date(new Date().getTime()));

			// 调用 DAO
			trollImageDao.addTrollImage(trollImage);

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	@RequiresRoles("superAdmin")
	public List<TrollImage> showTrollImage(Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		Integer start = (currentPage - 1) * pageSize;
		List<TrollImage> list = trollImageDao.selectTrollImagesByPage(start,
				pageSize);
		return list; 
	}

	@Override
	public Integer showTotalTrollImage() {
		return trollImageDao.selectTotalTrollImage();
	}

	@Override
	public void setTrollImage(TrollImage trollImage) {
		trollImageDao.setTrollImage(trollImage);

	}

	@Override
	public void delTrollImage(String id) {
		System.out.println("~~~~~~~~~~~~~~~~" + id);
		trollImageDao.delTrollImage(id);
	}

}
