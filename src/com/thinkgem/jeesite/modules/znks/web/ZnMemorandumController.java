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
import com.thinkgem.jeesite.modules.znks.entity.ZnMemorandum;
import com.thinkgem.jeesite.modules.znks.service.ZnMemorandumService;

/**
 * 错题Controller
 * @author yjg
 * @version 2018-08-11
 */
@Controller
@RequestMapping(value = "${adminPath}/znks/znMemorandum")
public class ZnMemorandumController extends BaseController {

	@Autowired
	private ZnMemorandumService znMemorandumService;
	
	@ModelAttribute
	public ZnMemorandum get(@RequestParam(required=false) String id) {
		ZnMemorandum entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = znMemorandumService.get(id);
		}
		if (entity == null){
			entity = new ZnMemorandum();
		}
		return entity;
	}
	
	@RequiresPermissions("znks:znMemorandum:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZnMemorandum znMemorandum, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZnMemorandum> page = znMemorandumService.findPage(new Page<ZnMemorandum>(request, response), znMemorandum); 
		model.addAttribute("page", page);
		return "modules/znks/znMemorandumList";
	}

	@RequiresPermissions("znks:znMemorandum:view")
	@RequestMapping(value = "form")
	public String form(ZnMemorandum znMemorandum, Model model) {
		model.addAttribute("znMemorandum", znMemorandum);
		return "modules/znks/znMemorandumForm";
	}

	@RequiresPermissions("znks:znMemorandum:edit")
	@RequestMapping(value = "save")
	public String save(ZnMemorandum znMemorandum, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, znMemorandum)){
			return form(znMemorandum, model);
		}
		znMemorandumService.save(znMemorandum);
		addMessage(redirectAttributes, "保存错题成功");
		return "redirect:"+Global.getAdminPath()+"/znks/znMemorandum/?repage";
	}
	
	@RequiresPermissions("znks:znMemorandum:edit")
	@RequestMapping(value = "delete")
	public String delete(ZnMemorandum znMemorandum, RedirectAttributes redirectAttributes) {
		znMemorandumService.delete(znMemorandum);
		addMessage(redirectAttributes, "删除错题成功");
		return "redirect:"+Global.getAdminPath()+"/znks/znMemorandum/?repage";
	}

}