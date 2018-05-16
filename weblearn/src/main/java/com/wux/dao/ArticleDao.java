package com.wux.dao;

import java.util.List;

import com.wux.entity.Article;
import org.apache.ibatis.annotations.Param;

import com.wux.entity.Article;
import com.wux.entity.TrollImage;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao {
	int countByExample();

	int deleteByPrimaryKey(String id);

	int insert(Article record);

	int insertSelective(Article record);

	Article selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Article record);

	int updateByPrimaryKey(Article record);

	// 分页查询
	List<Article> selectByPage(@Param("start") Integer start,
                               @Param("pageSize") Integer pageSize);
}