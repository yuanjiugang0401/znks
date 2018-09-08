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
import com.thinkgem.jeesite.modules.znks.entity.ZnExaminationInfo;
import com.thinkgem.jeesite.modules.znks.service.ZnExaminationInfoService;

/**
 * 试卷信息Controller
 * @author yjg
 * @version 2018-08-11
 */
@Controller
@RequestMapping(value = "${adminPath}/znks/znExaminationInfo")
public class ZnExaminationInfoController extends BaseController {

	@Autowired
	private ZnExaminationInfoService znExaminationInfoService;
	
	@ModelAttribute
	public ZnExaminationInfo get(@RequestParam(required=false) String id) {
		ZnExaminationInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = znExaminationInfoService.get(id);
		}
		if (entity == null){
			entity = new ZnExaminationInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("znks:znExaminationInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZnExaminationInfo znExaminationInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZnExaminationInfo> page = znExaminationInfoService.findPage(new Page<ZnExaminationInfo>(request, response), znExaminationInfo); 
		model.addAttribute("page", page);
		return "modules/znks/znExaminationInfoList";
	}

	@RequiresPermissions("znks:znExaminationInfo:view")
	@RequestMapping(value = "form")
	public String form(ZnExaminationInfo znExaminationInfo, Model model) {
		model.addAttribute("znExaminationInfo", znExaminationInfo);
		return "modules/znks/znExaminationInfoForm";
	}

	@RequiresPermissions("znks:znExaminationInfo:edit")
	@RequestMapping(value = "save")
	public String save(ZnExaminationInfo znExaminationInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, znExaminationInfo)){
			return form(znExaminationInfo, model);
		}
		znExaminationInfoService.save(znExaminationInfo);
		addMessage(redirectAttributes, "保存试卷信息成功");
		return "redirect:"+Global.getAdminPath()+"/znks/znExaminationInfo/?repage";
	}
	
	@RequiresPermissions("znks:znExaminationInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(ZnExaminationInfo znExaminationInfo, RedirectAttributes redirectAttributes) {
		znExaminationInfoService.delete(znExaminationInfo);
		addMessage(redirectAttributes, "删除试卷信息成功");
		return "redirect:"+Global.getAdminPath()+"/znks/znExaminationInfo/?repage";
	}

}