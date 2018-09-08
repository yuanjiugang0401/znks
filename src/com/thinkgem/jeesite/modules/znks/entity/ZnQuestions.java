/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znks.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 问题信息Entity
 * @author yjg
 * @version 2018-08-11
 */
public class ZnQuestions extends DataEntity<ZnQuestions> {
	
	private static final long serialVersionUID = 1L;
	private String questionId;		// 问题id
	private String grade;		// 所属年级（K1-K12）
	private String subjectId;		// 所属科目:0数、1语、2外
	private String questionType;		// 题型:1单选、2多选、3判断、4填空、5计算、6问答、7解答、8论述、9完形填空、10证明、11阅读理解、12作文、13智力题、自定义
	private String questionDescribe;		// 题目描述
	private String option1;		// 选项描述1
	private String option2;		// 选项描述2
	private String option3;		// 选项描述3
	private String option4;		// 选项描述4
	private String option5;		// 选项描述5
	private String option6;		// 选项描述6
	private String option7;		// 选项描述7
	private String option8;		// 选项描述8
	private String option9;		// 选项描述9
	private String option10;		// 选项描述10
	private String tips;		// 提示内容
	private String standardAnswer;		// 标准答案
	private String difficultyLevel;		// 难度系数（1-5颗星）
	private String questionValue;		// 问题价值（0-5滴血）
	private String expertId;		// 出题者id/专家id
	private String expertZn;		// 专家ZN
	private String status;		// 题目状态:0未通过、1通过、2审核中
	private Date created;		// 创建时间
	private Date modified;		// 更新时间
	
	public ZnQuestions() {
		super();
	}

	public ZnQuestions(String id){
		super(id);
	}

	@Length(min=0, max=20, message="问题id长度必须介于 0 和 20 之间")
	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	
	@Length(min=0, max=2, message="所属年级（K1-K12）长度必须介于 0 和 2 之间")
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Length(min=0, max=2, message="所属科目:0数、1语、2外长度必须介于 0 和 2 之间")
	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	
	@Length(min=0, max=2, message="题型:1单选、2多选、3判断、4填空、5计算、6问答、7解答、8论述、9完形填空、10证明、11阅读理解、12作文、13智力题、自定义长度必须介于 0 和 2 之间")
	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	
	@Length(min=0, max=2000, message="题目描述长度必须介于 0 和 2000 之间")
	public String getQuestionDescribe() {
		return questionDescribe;
	}

	public void setQuestionDescribe(String questionDescribe) {
		this.questionDescribe = questionDescribe;
	}
	
	@Length(min=0, max=100, message="选项描述1长度必须介于 0 和 100 之间")
	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}
	
	@Length(min=0, max=100, message="选项描述2长度必须介于 0 和 100 之间")
	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}
	
	@Length(min=0, max=100, message="选项描述3长度必须介于 0 和 100 之间")
	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}
	
	@Length(min=0, max=100, message="选项描述4长度必须介于 0 和 100 之间")
	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}
	
	@Length(min=0, max=100, message="选项描述5长度必须介于 0 和 100 之间")
	public String getOption5() {
		return option5;
	}

	public void setOption5(String option5) {
		this.option5 = option5;
	}
	
	@Length(min=0, max=100, message="选项描述6长度必须介于 0 和 100 之间")
	public String getOption6() {
		return option6;
	}

	public void setOption6(String option6) {
		this.option6 = option6;
	}
	
	@Length(min=0, max=100, message="选项描述7长度必须介于 0 和 100 之间")
	public String getOption7() {
		return option7;
	}

	public void setOption7(String option7) {
		this.option7 = option7;
	}
	
	@Length(min=0, max=100, message="选项描述8长度必须介于 0 和 100 之间")
	public String getOption8() {
		return option8;
	}

	public void setOption8(String option8) {
		this.option8 = option8;
	}
	
	@Length(min=0, max=100, message="选项描述9长度必须介于 0 和 100 之间")
	public String getOption9() {
		return option9;
	}

	public void setOption9(String option9) {
		this.option9 = option9;
	}
	
	@Length(min=0, max=100, message="选项描述10长度必须介于 0 和 100 之间")
	public String getOption10() {
		return option10;
	}

	public void setOption10(String option10) {
		this.option10 = option10;
	}
	
	@Length(min=0, max=100, message="提示内容长度必须介于 0 和 100 之间")
	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}
	
	@Length(min=0, max=1000, message="标准答案长度必须介于 0 和 1000 之间")
	public String getStandardAnswer() {
		return standardAnswer;
	}

	public void setStandardAnswer(String standardAnswer) {
		this.standardAnswer = standardAnswer;
	}
	
	@Length(min=0, max=2, message="难度系数（1-5颗星）长度必须介于 0 和 2 之间")
	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	
	@Length(min=0, max=2, message="问题价值（0-5滴血）长度必须介于 0 和 2 之间")
	public String getQuestionValue() {
		return questionValue;
	}

	public void setQuestionValue(String questionValue) {
		this.questionValue = questionValue;
	}
	
	@Length(min=0, max=20, message="出题者id/专家id长度必须介于 0 和 20 之间")
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
	
	@Length(min=0, max=2, message="题目状态:0未通过、1通过、2审核中长度必须介于 0 和 2 之间")
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