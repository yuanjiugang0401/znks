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
 * 答案信息Entity
 * @author yjg
 * @version 2018-08-11
 */
public class ZnAnswer extends DataEntity<ZnAnswer> {
	
	private static final long serialVersionUID = 1L;
	private String answerId;		// 回答id
	private String questionId;		// 问题id
	private String answerDetail;		// 提交答案
	private User user;		// 用户id/答题者id
	private String userZn;		// 答题者ZN
	private String result;		// 结果:0错误、1正确
	private String expertId;		// 判断者id/专家id
	private String expertZn;		// 专家ZN
	private String basis;		// 判断理由
	private Date judgeTime;		// 判断时间
	private String status;		// 答题状态：0未审核、1审核中、2审核完成、3已结算
	private Date created;		// 创建时间
	private Date modified;		// 更新时间
	
	public ZnAnswer() {
		super();
	}

	public ZnAnswer(String id){
		super(id);
	}

	@Length(min=0, max=20, message="回答id长度必须介于 0 和 20 之间")
	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}
	
	@Length(min=0, max=20, message="问题id长度必须介于 0 和 20 之间")
	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	
	@Length(min=0, max=1000, message="提交答案长度必须介于 0 和 1000 之间")
	public String getAnswerDetail() {
		return answerDetail;
	}

	public void setAnswerDetail(String answerDetail) {
		this.answerDetail = answerDetail;
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
	
	@Length(min=0, max=2, message="结果:0错误、1正确长度必须介于 0 和 2 之间")
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	@Length(min=0, max=20, message="判断者id/专家id长度必须介于 0 和 20 之间")
	public String getExpertId() {
		return expertId;
	}

	public void setExpertId(String expertId) {
		this.expertId = expertId;
	}
	
	@Length(min=0, max=20, message="专家ZN长度必须介于 0 和 20 之间")
	public String getExpertZn() {
		return expertZn;
	}

	public void setExpertZn(String expertZn) {
		this.expertZn = expertZn;
	}
	
	@Length(min=0, max=500, message="判断理由长度必须介于 0 和 500 之间")
	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getJudgeTime() {
		return judgeTime;
	}

	public void setJudgeTime(Date judgeTime) {
		this.judgeTime = judgeTime;
	}
	
	@Length(min=0, max=2, message="答题状态：0未审核、1审核中、2审核完成、3已结算长度必须介于 0 和 2 之间")
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