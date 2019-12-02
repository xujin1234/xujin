package com.zhiyou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.Video;


public interface VideoMapper {
	
	void add(Video video); //方法名与对应的的mapper中的id一致
	void update(Video video);//参数与mapper中的parameterType一致
	void delete(int id);
	void deleteAll(int [] ids);
	Video selectById(Integer id);
	List<Video> selectAllLimit(@Param("page")Integer page,@Param("num")Integer num);
	List<Video> selectAllLike();
	Integer selectCount();

}
