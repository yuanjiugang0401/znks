/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znks.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.znks.entity.ZnIdentifyingCode;

/**
 * 验证码DAO接口
 * @author yjg
 * @version 2018-08-11
 */
@MyBatisDao
public interface ZnIdentifyingCodeDao extends CrudDao<ZnIdentifyingCode> {
	
}