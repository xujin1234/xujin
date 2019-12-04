package com.zhiyou.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.Speaker;

public interface SpeakerService {
	
	void add(Speaker speaker);
	void update(Speaker speaker);
	void delete(int id);
	void deleteAll(int [] ids);
	Speaker selectById(Integer id);
	List<Speaker> selectAllLimit(@Param("page")Integer page,@Param("num")Integer num);
	List<Speaker> selectAllLike();
	List<Speaker> selectAll();
	Integer selectCount();


}
