package com.zhiyou.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
	
	private Integer admin_id;
	private String accounts;
	private String pssword;
	private String admin_remark;
	
	
	public Admin(String accounts, String pssword, String admin_remark) {
		super();
		
		this.accounts = accounts;
		this.pssword = pssword;
		this.admin_remark = admin_remark;
		
	}
	
	
	

}
