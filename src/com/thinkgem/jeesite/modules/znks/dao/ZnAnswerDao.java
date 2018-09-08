/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znks.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.znks.entity.ZnAnswer;

/**
 * 答案信息DAO接口
 * @author yjg
 * @version 2018-08-11
 */
@MyBatisDao
public interface ZnAnswerDao extends CrudDao<ZnAnswer> {
	
}