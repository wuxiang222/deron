package com.wux.dao;

import com.wux.entity.TrollImage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrollImageDao {

	// 增加轮播图
	void addTrollImage(TrollImage trollImage);

	// 分页查询
	List<TrollImage> selectTrollImagesByPage(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

	Integer selectTotalTrollImage();

	void setTrollImage(TrollImage trollImage);

	void delTrollImage(@Param("id") String id);

}
