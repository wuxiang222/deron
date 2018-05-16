package com.wux.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wux.dao.ArticleDao;
import com.wux.entity.Article;
import com.wux.entity.TrollImage;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;

	@Override
	public void deleteByPrimaryKey(String id) {
		articleDao.deleteByPrimaryKey(id);
	}

	@Override
	public void insert(Article record) {
		articleDao.insert(record);
	}

	@Override
	public void insertSelective(Article record) {
		String id = UUID.randomUUID().toString().replace("-", "");
		record.setId(id);
		articleDao.insertSelective(record);
	}

	@Override
	public Article selectByPrimaryKey(String id) {
		Article article = articleDao.selectByPrimaryKey(id);
		return article;
	}

	@Override
	public void updateByPrimaryKeySelective(Article record) {
		articleDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public void updateByPrimaryKey(Article record) {
		articleDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Article> selectByPage(Integer page, Integer rows) {
		// TODO Auto-generated method stub
		Integer start = (page - 1) * rows;
		List<Article> list = articleDao.selectByPage(start, rows);
		return list;
	}

	@Override
	public int countByExample() {
		int total = articleDao.countByExample();
		return total;
	}
}
