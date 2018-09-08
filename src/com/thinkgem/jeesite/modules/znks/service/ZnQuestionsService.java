/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znks.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.znks.entity.ZnQuestions;
import com.thinkgem.jeesite.modules.znks.dao.ZnQuestionsDao;

/**
 * 问题信息Service
 * @author yjg
 * @version 2018-08-11
 */
@Service
@Transactional(readOnly = true)
public class ZnQuestionsService extends CrudService<ZnQuestionsDao, ZnQuestions> {

	public ZnQuestions get(String id) {
		return super.get(id);
	}
	
	public List<ZnQuestions> findList(ZnQuestions znQuestions) {
		return super.findList(znQuestions);
	}
	
	public Page<ZnQuestions> findPage(Page<ZnQuestions> page, ZnQuestions znQuestions) {
		return super.findPage(page, znQuestions);
	}
	
	@Transactional(readOnly = false)
	public void save(ZnQuestions znQuestions) {
		super.save(znQuestions);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZnQuestions znQuestions) {
		super.delete(znQuestions);
	}
	
}