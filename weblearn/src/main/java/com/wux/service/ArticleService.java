package com.wux.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wux.entity.Article;

public interface ArticleService {
	int countByExample();
	
	void deleteByPrimaryKey(String id);

	void insert(Article record);

	void insertSelective(Article record);

    Article selectByPrimaryKey(String id);

    void updateByPrimaryKeySelective(Article record);

    void updateByPrimaryKey(Article record);
    
    // 分页查询
 	List<Article> selectByPage(Integer page, Integer rows);
}
