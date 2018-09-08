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
import com.thinkgem.jeesite.modules.znks.entity.ZnExpertUser;
import com.thinkgem.jeesite.modules.znks.service.ZnExpertUserService;

/**
 * 出题者Controller
 * @author yjg
 * @version 2018-08-11
 */
@Controller
@RequestMapping(value = "${adminPath}/znks/znExpertUser")
public class ZnExpertUserController extends BaseController {

	@Autowired
	private ZnExpertUserService znExpertUserService;
	
	@ModelAttribute
	public ZnExpertUser get(@RequestParam(required=false) String id) {
		ZnExpertUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = znExpertUserService.get(id);
		}
		if (entity == null){
			entity = new ZnExpertUser();
		}
		return entity;
	}
	
	@RequiresPermissions("znks:znExpertUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZnExpertUser znExpertUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZnExpertUser> page = znExpertUserService.findPage(new Page<ZnExpertUser>(request, response), znExpertUser); 
		model.addAttribute("page", page);
		return "modules/znks/znExpertUserList";
	}

	@RequiresPermissions("znks:znExpertUser:view")
	@RequestMapping(value = "form")
	public String form(ZnExpertUser znExpertUser, Model model) {
		model.addAttribute("znExpertUser", znExpertUser);
		return "modules/znks/znExpertUserForm";
	}

	@RequiresPermissions("znks:znExpertUser:edit")
	@RequestMapping(value = "save")
	public String save(ZnExpertUser znExpertUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, znExpertUser)){
			return form(znExpertUser, model);
		}
		znExpertUserService.save(znExpertUser);
		addMessage(redirectAttributes, "保存出题者成功");
		return "redirect:"+Global.getAdminPath()+"/znks/znExpertUser/?repage";
	}
	
	@RequiresPermissions("znks:znExpertUser:edit")
	@RequestMapping(value = "delete")
	public String delete(ZnExpertUser znExpertUser, RedirectAttributes redirectAttributes) {
		znExpertUserService.delete(znExpertUser);
		addMessage(redirectAttributes, "删除出题者成功");
		return "redirect:"+Global.getAdminPath()+"/znks/znExpertUser/?repage";
	}

}