package com.wux.dao;

import com.wux.entity.Voice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoiceDao {

	//根据外键
	List<Voice> selectBySpecialID(String specialID);
	//查1
	Voice selectById(String id);
	//删除
	void deleteVoiceById(String id);
	//根据外键删除音频
	void deleteBySpecialID(String specialID);
	//修改
	void updateVoiceById(Voice v);
	//添加
	void insertVoice(Voice v);
}
