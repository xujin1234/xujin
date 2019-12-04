package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.CourseMapper;
import com.zhiyou.model.Course;
import com.zhiyou.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseMapper mapper;
	@Override
	public void add(Course course) {
		mapper.add(course);
		
	}

	@Override
	public void update(Course course) {
		mapper.update(course);
		
	}

	@Override
	public void delete(int id) {
		mapper.delete(id);
		
	}

	@Override
	public void deleteAll(int[] ids) {
		mapper.deleteAll(ids);
		
	}

	@Override
	public Course selectById(Integer id) {
		return mapper.selectById(id);
	}

	@Override
	public List<Course> selectAllLimit(Integer page, Integer num) {
		return mapper.selectAllLimit(page, num);
	}

	@Override
	public List<Course> selectAllLike() {
		return mapper.selectAllLike();
	}

	@Override
	public List<Course> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public Integer selectCount() {
		return mapper.selectCount();
	}

}
