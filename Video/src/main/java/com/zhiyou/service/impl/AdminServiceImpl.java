package com.zhiyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.AdminMapper;
import com.zhiyou.model.Admin;
import com.zhiyou.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {

	
	@Autowired
	AdminMapper mapper;
	@Override
	public Admin selectBy(String accounts) {
		 Admin admin = mapper.selectBy(accounts);
		 if(admin==null) {
			 return null;
		 }else {
			 return admin;
		 }
	}

}
