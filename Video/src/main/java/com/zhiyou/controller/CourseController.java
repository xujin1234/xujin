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
public class CourseController {
	
	@Autowired
	CourseService service;
	@Autowired
	SubjectService service1;
	@RequestMapping("addShow1")
	public String addShow(HttpServletRequest req,HttpServletResponse resp) {
		List<Subject> subjecList = service1.selectAll();
		req.setAttribute("subjecList", subjecList);
		return "forward:course/add.jsp";
	}
	@RequestMapping("addCourse")
	public String add(Course course,HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		System.out.println(course+"course");
		service.add(course);
		return "redirect:courseShow";
	}
	@RequestMapping("courseShow")
	public String show(Integer page,HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		Integer count = service.selectCount();
		if(page==null) {
			page=1;
		}
		List<Course> list = service.selectAllLimit((page-1)*5, 5);
		req.setAttribute("count", count);
		req.setAttribute("list", list);
		req.setAttribute("page", page);
		return "forward:course/courseshow.jsp";
	}
	@RequestMapping("courseDelete")
	public String delete(Integer id,HttpServletRequest req,HttpServletResponse resp) {
		service.delete(id);
		return "redirect:courseShow";
	}
	@RequestMapping("courseUpdate")
	public String courseUpdate(Integer id,HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException {
		List<Subject> subjecList = service1.selectAll();
		req.setAttribute("subjecList", subjecList);
		Course course = service.selectById(id);
		req.setAttribute("course", course);
		return "forward:course/update.jsp";
	}
	@RequestMapping("updateR1")
	public String update(Course course,HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException{
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		service.update(course);
		return "redirect:courseShow";
	}
	
	
	
}
