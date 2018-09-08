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
import com.thinkgem.jeesite.modules.znks.entity.ZnQuestions;
import com.thinkgem.jeesite.modules.znks.service.ZnQuestionsService;

/**
 * 问题信息Controller
 * @author yjg
 * @version 2018-08-11
 */
@Controller
@RequestMapping(value = "${adminPath}/znks/znQuestions")
public class ZnQuestionsController extends BaseController {

	@Autowired
	private ZnQuestionsService znQuestionsService;
	
	@ModelAttribute
	public ZnQuestions get(@RequestParam(required=false) String id) {
		ZnQuestions entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = znQuestionsService.get(id);
		}
		if (entity == null){
			entity = new ZnQuestions();
		}
		return entity;
	}
	
	@RequiresPermissions("znks:znQuestions:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZnQuestions znQuestions, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZnQuestions> page = znQuestionsService.findPage(new Page<ZnQuestions>(request, response), znQuestions); 
		model.addAttribute("page", page);
		return "modules/znks/znQuestionsList";
	}

	@RequiresPermissions("znks:znQuestions:view")
	@RequestMapping(value = "form")
	public String form(ZnQuestions znQuestions, Model model) {
		model.addAttribute("znQuestions", znQuestions);
		return "modules/znks/znQuestionsForm";
	}

	@RequiresPermissions("znks:znQuestions:edit")
	@RequestMapping(value = "save")
	public String save(ZnQuestions znQuestions, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, znQuestions)){
			return form(znQuestions, model);
		}
		znQuestionsService.save(znQuestions);
		addMessage(redirectAttributes, "保存问题信息成功");
		return "redirect:"+Global.getAdminPath()+"/znks/znQuestions/?repage";
	}
	
	@RequiresPermissions("znks:znQuestions:edit")
	@RequestMapping(value = "delete")
	public String delete(ZnQuestions znQuestions, RedirectAttributes redirectAttributes) {
		znQuestionsService.delete(znQuestions);
		addMessage(redirectAttributes, "删除问题信息成功");
		return "redirect:"+Global.getAdminPath()+"/znks/znQuestions/?repage";
	}

	@RequestMapping(value = "questionList")
	public String questionList(ZnQuestions znQuestions, HttpServletRequest request, HttpServletResponse response){

	    return "";
	}
}