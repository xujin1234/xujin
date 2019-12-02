package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.VideoMapper;
import com.zhiyou.model.Video;
import com.zhiyou.service.VideoService;
@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	VideoMapper mapper;
	@Override
	public void add(Video video) {
		mapper.add(video);

	}

	@Override
	public void update(Video video) {
		mapper.update(video);

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
	public Video selectById(Integer id) {
		return mapper.selectById(id);
	}

	@Override
	public List<Video> selectAllLimit(Integer page, Integer num) {
		if(page==null) {
			page=0;
		}
		return mapper.selectAllLimit(page, num);
	}

	@Override
	public List<Video> selectAllLike() {
		return mapper.selectAllLike();
	}

	@Override
	public Integer selectCount() {
		return mapper.selectCount();
	}

}
