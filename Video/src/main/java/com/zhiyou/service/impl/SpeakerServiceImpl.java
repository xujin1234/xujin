package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.SpeakerMapper;
import com.zhiyou.model.Speaker;
import com.zhiyou.service.SpeakerService;
@Service
public class SpeakerServiceImpl implements SpeakerService {

	
	@Autowired
	SpeakerMapper mapper;
	@Override
	public void add(Speaker speaker) {
		mapper.add(speaker);
	}

	@Override
	public void update(Speaker speaker) {
		mapper.update(speaker);
		
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
	public Speaker selectById(Integer id) {
		return mapper.selectById(id);
	}

	@Override
	public List<Speaker> selectAllLimit(Integer page, Integer num) {
		return mapper.selectAllLimit(page, num);
	}

	@Override
	public List<Speaker> selectAllLike() {
		return mapper.selectAllLike();
	}

	@Override
	public List<Speaker> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public Integer selectCount() {
		return mapper.selectCount();
	}

}
