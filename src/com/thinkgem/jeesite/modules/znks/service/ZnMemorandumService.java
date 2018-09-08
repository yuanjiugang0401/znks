/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znks.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.znks.entity.ZnMemorandum;
import com.thinkgem.jeesite.modules.znks.dao.ZnMemorandumDao;

/**
 * 错题Service
 * @author yjg
 * @version 2018-08-11
 */
@Service
@Transactional(readOnly = true)
public class ZnMemorandumService extends CrudService<ZnMemorandumDao, ZnMemorandum> {

	public ZnMemorandum get(String id) {
		return super.get(id);
	}
	
	public List<ZnMemorandum> findList(ZnMemorandum znMemorandum) {
		return super.findList(znMemorandum);
	}
	
	public Page<ZnMemorandum> findPage(Page<ZnMemorandum> page, ZnMemorandum znMemorandum) {
		return super.findPage(page, znMemorandum);
	}
	
	@Transactional(readOnly = false)
	public void save(ZnMemorandum znMemorandum) {
		super.save(znMemorandum);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZnMemorandum znMemorandum) {
		super.delete(znMemorandum);
	}
	
}