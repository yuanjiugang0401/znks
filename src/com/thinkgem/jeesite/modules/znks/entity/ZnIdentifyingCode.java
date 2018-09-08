/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znks.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 验证码Entity
 * @author yjg
 * @version 2018-08-11
 */
public class ZnIdentifyingCode extends DataEntity<ZnIdentifyingCode> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// 验证码
	private String phoneNumber;		// 接收手机号
	private Date created;		// 创建时间
	private Date modified;		// 更新时间
	
	public ZnIdentifyingCode() {
		super();
	}

	public ZnIdentifyingCode(String id){
		super(id);
	}

	@Length(min=0, max=6, message="验证码长度必须介于 0 和 6 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=0, max=15, message="接收手机号长度必须介于 0 和 15 之间")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}
	
}