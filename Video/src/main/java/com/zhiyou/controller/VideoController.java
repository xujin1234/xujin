package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.Video;
import com.zhiyou.service.VideoService;

@Controller
public class VideoController {
	
	@Autowired
	VideoService service;
	@RequestMapping("add")
	public String add(Video video) {
		service.add(video);
		return "redirect:show";
	}
	@RequestMapping("show")
	public String show(Integer page,HttpServletRequest req,HttpServletResponse resp) {
		List<Video> list = service.selectAllLimit(page, 5);
		req.setAttribute("list", list);
		return "videoshow";
	}
	@RequestMapping("delete")
	public String delete(Integer id,HttpServletRequest req,HttpServletResponse resp) {
		service.delete(id);
		return "redirect:show";
	}
	
	
	
}
