/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znks.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.znks.entity.ZnIdentifyingCode;
import com.thinkgem.jeesite.modules.znks.dao.ZnIdentifyingCodeDao;

/**
 * 验证码Service
 * @author yjg
 * @version 2018-08-11
 */
@Service
@Transactional(readOnly = true)
public class ZnIdentifyingCodeService extends CrudService<ZnIdentifyingCodeDao, ZnIdentifyingCode> {

	public ZnIdentifyingCode get(String id) {
		return super.get(id);
	}
	
	public List<ZnIdentifyingCode> findList(ZnIdentifyingCode znIdentifyingCode) {
		return super.findList(znIdentifyingCode);
	}
	
	public Page<ZnIdentifyingCode> findPage(Page<ZnIdentifyingCode> page, ZnIdentifyingCode znIdentifyingCode) {
		return super.findPage(page, znIdentifyingCode);
	}
	
	@Transactional(readOnly = false)
	public void save(ZnIdentifyingCode znIdentifyingCode) {
		super.save(znIdentifyingCode);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZnIdentifyingCode znIdentifyingCode) {
		super.delete(znIdentifyingCode);
	}
	
}