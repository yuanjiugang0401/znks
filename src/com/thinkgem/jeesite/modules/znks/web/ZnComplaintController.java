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
import com.thinkgem.jeesite.modules.znks.entity.ZnComplaint;
import com.thinkgem.jeesite.modules.znks.service.ZnComplaintService;

/**
 * 投诉题管理Controller
 * @author yjg
 * @version 2018-08-11
 */
@Controller
@RequestMapping(value = "${adminPath}/znks/znComplaint")
public class ZnComplaintController extends BaseController {

	@Autowired
	private ZnComplaintService znComplaintService;
	
	@ModelAttribute
	public ZnComplaint get(@RequestParam(required=false) String id) {
		ZnComplaint entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = znComplaintService.get(id);
		}
		if (entity == null){
			entity = new ZnComplaint();
		}
		return entity;
	}
	
	@RequiresPermissions("znks:znComplaint:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZnComplaint znComplaint, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZnComplaint> page = znComplaintService.findPage(new Page<ZnComplaint>(request, response), znComplaint); 
		model.addAttribute("page", page);
		return "modules/znks/znComplaintList";
	}

	@RequiresPermissions("znks:znComplaint:view")
	@RequestMapping(value = "form")
	public String form(ZnComplaint znComplaint, Model model) {
		model.addAttribute("znComplaint", znComplaint);
		return "modules/znks/znComplaintForm";
	}

	@RequiresPermissions("znks:znComplaint:edit")
	@RequestMapping(value = "save")
	public String save(ZnComplaint znComplaint, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, znComplaint)){
			return form(znComplaint, model);
		}
		znComplaintService.save(znComplaint);
		addMessage(redirectAttributes, "保存投诉题管理成功");
		return "redirect:"+Global.getAdminPath()+"/znks/znComplaint/?repage";
	}
	
	@RequiresPermissions("znks:znComplaint:edit")
	@RequestMapping(value = "delete")
	public String delete(ZnComplaint znComplaint, RedirectAttributes redirectAttributes) {
		znComplaintService.delete(znComplaint);
		addMessage(redirectAttributes, "删除投诉题管理成功");
		return "redirect:"+Global.getAdminPath()+"/znks/znComplaint/?repage";
	}

}