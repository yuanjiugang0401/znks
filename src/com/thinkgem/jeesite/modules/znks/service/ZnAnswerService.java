/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znks.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.znks.entity.ZnAnswer;
import com.thinkgem.jeesite.modules.znks.dao.ZnAnswerDao;

/**
 * 答案信息Service
 * @author yjg
 * @version 2018-08-11
 */
@Service
@Transactional(readOnly = true)
public class ZnAnswerService extends CrudService<ZnAnswerDao, ZnAnswer> {

	public ZnAnswer get(String id) {
		return super.get(id);
	}
	
	public List<ZnAnswer> findList(ZnAnswer znAnswer) {
		return super.findList(znAnswer);
	}
	
	public Page<ZnAnswer> findPage(Page<ZnAnswer> page, ZnAnswer znAnswer) {
		return super.findPage(page, znAnswer);
	}
	
	@Transactional(readOnly = false)
	public void save(ZnAnswer znAnswer) {
		super.save(znAnswer);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZnAnswer znAnswer) {
		super.delete(znAnswer);
	}
	
}