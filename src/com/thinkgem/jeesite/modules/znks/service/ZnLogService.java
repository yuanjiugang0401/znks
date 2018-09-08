/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znks.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.znks.entity.ZnLog;
import com.thinkgem.jeesite.modules.znks.dao.ZnLogDao;

/**
 * 日志记录Service
 * @author yjg
 * @version 2018-08-11
 */
@Service
@Transactional(readOnly = true)
public class ZnLogService extends CrudService<ZnLogDao, ZnLog> {

	public ZnLog get(String id) {
		return super.get(id);
	}
	
	public List<ZnLog> findList(ZnLog znLog) {
		return super.findList(znLog);
	}
	
	public Page<ZnLog> findPage(Page<ZnLog> page, ZnLog znLog) {
		return super.findPage(page, znLog);
	}
	
	@Transactional(readOnly = false)
	public void save(ZnLog znLog) {
		super.save(znLog);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZnLog znLog) {
		super.delete(znLog);
	}
	
}