package com.zhiyou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.Video;


public interface VideoMapper {
	
	void add(Video video);
	void update(Video video);
	void delete(int id);
	void deleteAll(int [] ids);
	Video selectById(Integer id);
	List<Video> selectAllLimit(@Param("page")Integer page,@Param("num")Integer num);
	List<Video> selectAllLike();
	Integer selectCount();

}
