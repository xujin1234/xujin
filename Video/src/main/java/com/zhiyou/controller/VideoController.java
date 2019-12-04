package com.zhiyou.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.Video;
import com.zhiyou.service.CourseService;
import com.zhiyou.service.SpeakerService;
import com.zhiyou.service.VideoService;

@Controller
public class VideoController {
	
	@Autowired
	VideoService service;
	@Autowired
	SpeakerService service1;
	@Autowired
	CourseService service2;
	@RequestMapping("videoAdd")
	public String add(Video video) {
		service.add(video);
		return "redirect:show";
	}
	@RequestMapping("addShow")
	public String addShow(HttpServletRequest req,HttpServletResponse resp) {
		List<Speaker> speakerList = service1.selectAll();
		List<Course> courseList = service2.selectAll();
		req.setAttribute("courseList", courseList);
		req.setAttribute("speakerList", speakerList);
		return "forward:video/add.jsp";
	}
	@RequestMapping("addVideo")
	public String add(Video video,HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		service.add(video);
		return "redirect:videoShow";
	}
	@RequestMapping("videoShow")
	public String show(Integer page,HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		Integer count = service.selectCount();
		if(page==null) {
			page=1;
		}
		List<Video> list = service.selectAllLimit((page-1)*5, 5);
		req.setAttribute("count", count);
		System.out.println("list"+list);
		req.setAttribute("list", list);
		req.setAttribute("page", page);
		return "forward:video/videoshow.jsp";
	}
	@RequestMapping("videoDelete")
	public String delete(Integer video_id,HttpServletRequest req,HttpServletResponse resp) {
		service.delete(video_id);
		return "redirect:videoShow";
	}
	@RequestMapping("videoUpdate")
	public String videoUpdate(Integer video_id,HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException {
		
		List<Speaker> speakerList = service1.selectAll();
		List<Course> courseList = service2.selectAll();
		req.setAttribute("courseList", courseList);
		req.setAttribute("speakerList", speakerList);
		Video video = service.selectById(video_id);
		System.out.println("video"+video);
		req.setAttribute("video", video);
		return "forward:video/update.jsp";
	}
	@RequestMapping("updateR")
	public String update(Video video,HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException{
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		service.update(video);
		return "redirect:videoShow";
	}
	
	
	
}
