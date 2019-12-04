package com.zhiyou.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyou.mapper.SubjectMapper;
import com.zhiyou.model.Subject;
import com.zhiyou.service.SubjectService;
@Service
public class SubjectServiceImpl implements SubjectService{

	
	@Resource
	SubjectMapper mapper;

	public List<Subject> selectAll() {

       return mapper.selectAll();
		
	}
	
}
