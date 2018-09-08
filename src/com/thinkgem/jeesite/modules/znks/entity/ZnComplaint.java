/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znks.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.User;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 投诉题管理Entity
 * @author yjg
 * @version 2018-08-11
 */
public class ZnComplaint extends DataEntity<ZnComplaint> {
	
	private static final long serialVersionUID = 1L;
	private String questionId;		// 问题id
	private User user;		// 用户id/答题者id
	private String userZn;		// 答题者ZN
	private String basis;		// 投诉理由
	private String status;		// 投诉状态：0投诉未生效、1投诉生效、2审核中
	private Date created;		// 创建时间
	private Date modified;		// 更新时间
	
	public ZnComplaint() {
		super();
	}

	public ZnComplaint(String id){
		super(id);
	}

	@Length(min=0, max=20, message="问题id长度必须介于 0 和 20 之间")
	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Length(min=0, max=20, message="答题者ZN长度必须介于 0 和 20 之间")
	public String getUserZn() {
		return userZn;
	}

	public void setUserZn(String userZn) {
		this.userZn = userZn;
	}
	
	@Length(min=0, max=500, message="投诉理由长度必须介于 0 和 500 之间")
	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}
	
	@Length(min=0, max=2, message="投诉状态：0投诉未生效、1投诉生效、2审核中长度必须介于 0 和 2 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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