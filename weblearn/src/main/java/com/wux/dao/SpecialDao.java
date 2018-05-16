package com.wux.dao;

import java.util.List;

import com.wux.entity.Special;
import org.apache.ibatis.annotations.Param;

import com.wux.entity.Special;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialDao {
	
	public List<Special> queryByPage(@Param("begin") Integer begin, @Param("rows") Integer rows);
	public Integer queryCount();
	
	public Special selectById(String id);
	
	public void del(String id);
	
	public void add(Special special);
	
	public void update(Special special);
}
