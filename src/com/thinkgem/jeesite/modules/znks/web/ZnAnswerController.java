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
import com.thinkgem.jeesite.modules.znks.entity.ZnAnswer;
import com.thinkgem.jeesite.modules.znks.service.ZnAnswerService;

/**
 * 答案信息Controller
 * @author yjg
 * @version 2018-08-11
 */
@Controller
@RequestMapping(value = "${adminPath}/znks/znAnswer")
public class ZnAnswerController extends BaseController {

	@Autowired
	private ZnAnswerService znAnswerService;
	
	@ModelAttribute
	public ZnAnswer get(@RequestParam(required=false) String id) {
		ZnAnswer entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = znAnswerService.get(id);
		}
		if (entity == null){
			entity = new ZnAnswer();
		}
		return entity;
	}
	
	@RequiresPermissions("znks:znAnswer:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZnAnswer znAnswer, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZnAnswer> page = znAnswerService.findPage(new Page<ZnAnswer>(request, response), znAnswer); 
		model.addAttribute("page", page);
		return "modules/znks/znAnswerList";
	}

	@RequiresPermissions("znks:znAnswer:view")
	@RequestMapping(value = "form")
	public String form(ZnAnswer znAnswer, Model model) {
		model.addAttribute("znAnswer", znAnswer);
		return "modules/znks/znAnswerForm";
	}

	@RequiresPermissions("znks:znAnswer:edit")
	@RequestMapping(value = "save")
	public String save(ZnAnswer znAnswer, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, znAnswer)){
			return form(znAnswer, model);
		}
		znAnswerService.save(znAnswer);
		addMessage(redirectAttributes, "保存答案信息成功");
		return "redirect:"+Global.getAdminPath()+"/znks/znAnswer/?repage";
	}
	
	@RequiresPermissions("znks:znAnswer:edit")
	@RequestMapping(value = "delete")
	public String delete(ZnAnswer znAnswer, RedirectAttributes redirectAttributes) {
		znAnswerService.delete(znAnswer);
		addMessage(redirectAttributes, "删除答案信息成功");
		return "redirect:"+Global.getAdminPath()+"/znks/znAnswer/?repage";
	}

}