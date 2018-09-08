/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znks.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.znks.entity.ZnExaminationInfo;
import com.thinkgem.jeesite.modules.znks.dao.ZnExaminationInfoDao;

/**
 * 试卷信息Service
 * @author yjg
 * @version 2018-08-11
 */
@Service
@Transactional(readOnly = true)
public class ZnExaminationInfoService extends CrudService<ZnExaminationInfoDao, ZnExaminationInfo> {

	public ZnExaminationInfo get(String id) {
		return super.get(id);
	}
	
	public List<ZnExaminationInfo> findList(ZnExaminationInfo znExaminationInfo) {
		return super.findList(znExaminationInfo);
	}
	
	public Page<ZnExaminationInfo> findPage(Page<ZnExaminationInfo> page, ZnExaminationInfo znExaminationInfo) {
		return super.findPage(page, znExaminationInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(ZnExaminationInfo znExaminationInfo) {
		super.save(znExaminationInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZnExaminationInfo znExaminationInfo) {
		super.delete(znExaminationInfo);
	}
	
}