package com.zhiyou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.Course;

public interface CourseMapper {
	
	void add(Course course);
	void update(Course course);
	void delete(int id);
	void deleteAll(int [] ids);
	Course selectById(Integer id);
	List<Course> selectAllLimit(@Param("page")Integer page,@Param("num")Integer num);
	List<Course> selectAllLike();
	List<Course> selectAll();
	Integer selectCount();

}
