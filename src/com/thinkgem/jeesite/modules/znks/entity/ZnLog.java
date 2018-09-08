/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znks.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 日志记录Entity
 * @author yjg
 * @version 2018-08-11
 */
public class ZnLog extends DataEntity<ZnLog> {
	
	private static final long serialVersionUID = 1L;
	private String label;		// 日志标签
	private String content;		// 日志内容
	private String operator;		// 操作人
	private Date created;		// 创建时间
	private Date modified;		// 更新时间
	
	public ZnLog() {
		super();
	}

	public ZnLog(String id){
		super(id);
	}

	@Length(min=0, max=100, message="日志标签长度必须介于 0 和 100 之间")
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	@Length(min=0, max=1000, message="日志内容长度必须介于 0 和 1000 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=10, message="操作人长度必须介于 0 和 10 之间")
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
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