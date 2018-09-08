/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znks.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.znks.entity.ZnExpertUser;
import com.thinkgem.jeesite.modules.znks.dao.ZnExpertUserDao;

/**
 * 出题者Service
 * @author yjg
 * @version 2018-08-11
 */
@Service
@Transactional(readOnly = true)
public class ZnExpertUserService extends CrudService<ZnExpertUserDao, ZnExpertUser> {

	public ZnExpertUser get(String id) {
		return super.get(id);
	}
	
	public List<ZnExpertUser> findList(ZnExpertUser znExpertUser) {
		return super.findList(znExpertUser);
	}
	
	public Page<ZnExpertUser> findPage(Page<ZnExpertUser> page, ZnExpertUser znExpertUser) {
		return super.findPage(page, znExpertUser);
	}
	
	@Transactional(readOnly = false)
	public void save(ZnExpertUser znExpertUser) {
		super.save(znExpertUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZnExpertUser znExpertUser) {
		super.delete(znExpertUser);
	}
	
}