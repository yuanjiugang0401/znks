/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znks.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.znks.entity.ZnLog;
import com.thinkgem.jeesite.modules.znks.service.ZnLogService;

/**
 * 日志记录Controller
 * @author yjg
 * @version 2018-08-11
 */
@Controller
@RequestMapping(value = "${adminPath}/znks/znLog")
public class ZnLogController extends BaseController {

	@Autowired
	private ZnLogService znLogService;
	
	@ModelAttribute
	public ZnLog get(@RequestParam(required=false) String id) {
		ZnLog entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = znLogService.get(id);
		}
		if (entity == null){
			entity = new ZnLog();
		}
		return entity;
	}
	
	@RequiresPermissions("znks:znLog:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZnLog znLog, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZnLog> page = znLogService.findPage(new Page<ZnLog>(request, response), znLog); 
		model.addAttribute("page", page);
		return "modules/znks/znLogList";
	}

	@RequiresPermissions("znks:znLog:view")
	@RequestMapping(value = "form")
	public String form(ZnLog znLog, Model model) {
		model.addAttribute("znLog", znLog);
		return "modules/znks/znLogForm";
	}

	@RequiresPermissions("znks:znLog:edit")
	@RequestMapping(value = "save")
	public String save(ZnLog znLog, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, znLog)){
			return form(znLog, model);
		}
		znLogService.save(znLog);
		addMessage(redirectAttributes, "保存日志记录成功");
		return "redirect:"+Global.getAdminPath()+"/znks/znLog/?repage";
	}
	
	@RequiresPermissions("znks:znLog:edit")
	@RequestMapping(value = "delete")
	public String delete(ZnLog znLog, RedirectAttributes redirectAttributes) {
		znLogService.delete(znLog);
		addMessage(redirectAttributes, "删除日志记录成功");
		return "redirect:"+Global.getAdminPath()+"/znks/znLog/?repage";
	}

}