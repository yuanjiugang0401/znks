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
import com.thinkgem.jeesite.modules.znks.entity.ZnIdentifyingCode;
import com.thinkgem.jeesite.modules.znks.service.ZnIdentifyingCodeService;

/**
 * 验证码Controller
 * @author yjg
 * @version 2018-08-11
 */
@Controller
@RequestMapping(value = "${adminPath}/znks/znIdentifyingCode")
public class ZnIdentifyingCodeController extends BaseController {

	@Autowired
	private ZnIdentifyingCodeService znIdentifyingCodeService;
	
	@ModelAttribute
	public ZnIdentifyingCode get(@RequestParam(required=false) String id) {
		ZnIdentifyingCode entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = znIdentifyingCodeService.get(id);
		}
		if (entity == null){
			entity = new ZnIdentifyingCode();
		}
		return entity;
	}
	
	@RequiresPermissions("znks:znIdentifyingCode:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZnIdentifyingCode znIdentifyingCode, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZnIdentifyingCode> page = znIdentifyingCodeService.findPage(new Page<ZnIdentifyingCode>(request, response), znIdentifyingCode); 
		model.addAttribute("page", page);
		return "modules/znks/znIdentifyingCodeList";
	}

	@RequiresPermissions("znks:znIdentifyingCode:view")
	@RequestMapping(value = "form")
	public String form(ZnIdentifyingCode znIdentifyingCode, Model model) {
		model.addAttribute("znIdentifyingCode", znIdentifyingCode);
		return "modules/znks/znIdentifyingCodeForm";
	}

	@RequiresPermissions("znks:znIdentifyingCode:edit")
	@RequestMapping(value = "save")
	public String save(ZnIdentifyingCode znIdentifyingCode, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, znIdentifyingCode)){
			return form(znIdentifyingCode, model);
		}
		znIdentifyingCodeService.save(znIdentifyingCode);
		addMessage(redirectAttributes, "保存验证码成功");
		return "redirect:"+Global.getAdminPath()+"/znks/znIdentifyingCode/?repage";
	}
	
	@RequiresPermissions("znks:znIdentifyingCode:edit")
	@RequestMapping(value = "delete")
	public String delete(ZnIdentifyingCode znIdentifyingCode, RedirectAttributes redirectAttributes) {
		znIdentifyingCodeService.delete(znIdentifyingCode);
		addMessage(redirectAttributes, "删除验证码成功");
		return "redirect:"+Global.getAdminPath()+"/znks/znIdentifyingCode/?repage";
	}



}