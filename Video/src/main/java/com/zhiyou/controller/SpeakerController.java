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
import com.zhiyou.model.Subject;
import com.zhiyou.model.Video;
import com.zhiyou.service.CourseService;
import com.zhiyou.service.SpeakerService;
import com.zhiyou.service.SubjectService;
import com.zhiyou.service.VideoService;

@Controller
public class SpeakerController {
	
	@Autowired
	SpeakerService service;
	@Autowired
	SubjectService service1;
	@RequestMapping("addShow2")
	public String addShow(HttpServletRequest req,HttpServletResponse resp) {
		return "forward:speaker/add.jsp";
	}
	@RequestMapping("addSpeaker")
	public String add(Speaker speaker,HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		System.out.println(speaker+"course");
		service.add(speaker);
		return "redirect:courseShow";
	}
	@RequestMapping("speakerShow")
	public String show(Integer page,HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		Integer count = service.selectCount();
		if(page==null) {
			page=1;
		}
		List<Speaker> list = service.selectAllLimit((page-1)*5, 5);
		req.setAttribute("count", count);
		req.setAttribute("list", list);
		req.setAttribute("page", page);
		return "forward:speaker/speakershow.jsp";
	}
	@RequestMapping("speakerDelete")
	public String delete(Integer id,HttpServletRequest req,HttpServletResponse resp) {
		service.delete(id);
		return "redirect:speakerShow";
	}
	@RequestMapping("speakerUpdate")
	public String courseUpdate(Integer id,HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException {
		Speaker speaker = service.selectById(id);
		req.setAttribute("speaker", speaker);
		return "forward:speaker/update.jsp";
	}
	@RequestMapping("updateR2")
	public String update(Speaker speaker,HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException{
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		service.update(speaker);
		return "redirect:speakerShow";
	}
	
	
	
}
