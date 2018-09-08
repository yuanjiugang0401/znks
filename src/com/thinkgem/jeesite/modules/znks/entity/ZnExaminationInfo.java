/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znks.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 试卷信息Entity
 * @author yjg
 * @version 2018-08-11
 */
public class ZnExaminationInfo extends DataEntity<ZnExaminationInfo> {
	
	private static final long serialVersionUID = 1L;
	private String testId;		// 试卷id
	private String totalScore;		// 总分
	private String totalQuestions;		// 题目数量
	private String testTime;		// 考试时间（分钟）
	private String questionList;		// 题目List
	private String scoreList;		// 分值List
	private String status;		// 试卷状态:0未通过、1通过、2审核中
	private Date created;		// 创建时间
	private Date modified;		// 更新时间
	
	public ZnExaminationInfo() {
		super();
	}

	public ZnExaminationInfo(String id){
		super(id);
	}

	@Length(min=0, max=20, message="试卷id长度必须介于 0 和 20 之间")
	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}
	
	@Length(min=0, max=4, message="总分长度必须介于 0 和 4 之间")
	public String getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}
	
	@Length(min=0, max=4, message="题目数量长度必须介于 0 和 4 之间")
	public String getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(String totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	
	@Length(min=0, max=4, message="考试时间（分钟）长度必须介于 0 和 4 之间")
	public String getTestTime() {
		return testTime;
	}

	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}
	
	@Length(min=0, max=1000, message="题目List长度必须介于 0 和 1000 之间")
	public String getQuestionList() {
		return questionList;
	}

	public void setQuestionList(String questionList) {
		this.questionList = questionList;
	}
	
	@Length(min=0, max=1000, message="分值List长度必须介于 0 和 1000 之间")
	public String getScoreList() {
		return scoreList;
	}

	public void setScoreList(String scoreList) {
		this.scoreList = scoreList;
	}
	
	@Length(min=0, max=2, message="试卷状态:0未通过、1通过、2审核中长度必须介于 0 和 2 之间")
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