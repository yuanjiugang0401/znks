/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znks.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.znks.entity.ZnGeneralUser;
import com.thinkgem.jeesite.modules.znks.dao.ZnGeneralUserDao;

/**
 * 答题者Service
 * @author yjg
 * @version 2018-08-11
 */
@Service
@Transactional(readOnly = true)
public class ZnGeneralUserService extends CrudService<ZnGeneralUserDao, ZnGeneralUser> {

	public ZnGeneralUser get(String id) {
		return super.get(id);
	}
	
	public List<ZnGeneralUser> findList(ZnGeneralUser znGeneralUser) {
		return super.findList(znGeneralUser);
	}
	
	public Page<ZnGeneralUser> findPage(Page<ZnGeneralUser> page, ZnGeneralUser znGeneralUser) {
		return super.findPage(page, znGeneralUser);
	}
	
	@Transactional(readOnly = false)
	public void save(ZnGeneralUser znGeneralUser) {
		super.save(znGeneralUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZnGeneralUser znGeneralUser) {
		super.delete(znGeneralUser);
	}
	
}