package com.zhiyou.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhiyou.model.Admin;
import com.zhiyou.service.AdminService;
import com.zhiyou.util.MD5;

@Controller
public class AdminController {
	@Autowired
	AdminService service;
	@RequestMapping(value="adminLogin",method=RequestMethod.POST)
	public String selectBy(@Param("accounts")String accounts, @Param("password")String password,HttpServletRequest req,HttpServletResponse resp) {
		Admin admin = service.selectBy(accounts);
		
		MD5 md5 = MD5.getInstance();
		System.out.println("password"+password);
		System.out.println("password"+md5.getMD5(password));
		System.out.println("admin"+ admin);
		if(admin!=null) {
			if(admin.getPassword().equals(md5.getMD5(password))) {
				req.getSession().setAttribute("accounts", accounts);
				return "redirect:videoShow";
			}else {
				req.setAttribute("msg", "输入密码错误");
				return "index";
			}
		}else {
			req.setAttribute("mag", "输入账号不存在");
			return "index";
		}
	}
	@RequestMapping(value="adminLogin1",method=RequestMethod.POST)
	public void selectBy(String accounts,HttpServletRequest req,HttpServletResponse resp) throws IOException {
		Admin admin = service.selectBy(accounts);
		if(admin!=null) {
			resp.getWriter().write("1");
		}else {
			resp.getWriter().write("0");
			
		}
	}
} 
