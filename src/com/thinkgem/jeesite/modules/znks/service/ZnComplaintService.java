/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znks.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.znks.entity.ZnComplaint;
import com.thinkgem.jeesite.modules.znks.dao.ZnComplaintDao;

/**
 * 投诉题管理Service
 * @author yjg
 * @version 2018-08-11
 */
@Service
@Transactional(readOnly = true)
public class ZnComplaintService extends CrudService<ZnComplaintDao, ZnComplaint> {

	public ZnComplaint get(String id) {
		return super.get(id);
	}
	
	public List<ZnComplaint> findList(ZnComplaint znComplaint) {
		return super.findList(znComplaint);
	}
	
	public Page<ZnComplaint> findPage(Page<ZnComplaint> page, ZnComplaint znComplaint) {
		return super.findPage(page, znComplaint);
	}
	
	@Transactional(readOnly = false)
	public void save(ZnComplaint znComplaint) {
		super.save(znComplaint);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZnComplaint znComplaint) {
		super.delete(znComplaint);
	}
	
}