package com.thinkgem.jeesite.modules.znks.web;

import java.util.HashMap;
import java.util.Map;

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
import com.thinkgem.jeesite.modules.znks.entity.ZnGeneralUser;
import com.thinkgem.jeesite.modules.znks.service.ZnGeneralUserService;

/**
 * 答题者Controller
 * @author yjg
 * @version 2018-08-11
 */
@Controller
@RequestMapping(value = "${adminPath}/znks/znGeneralUser")
public class ZnGeneralUserController extends BaseController {

	@Autowired
	private ZnGeneralUserService znGeneralUserService;
	
	@ModelAttribute
	public ZnGeneralUser get(@RequestParam(required=false) String id) {
		ZnGeneralUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = znGeneralUserService.get(id);
		}
		if (entity == null){
			entity = new ZnGeneralUser();
		}
		return entity;
	}
	
	@RequiresPermissions("znks:znGeneralUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZnGeneralUser znGeneralUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZnGeneralUser> page = znGeneralUserService.findPage(new Page<ZnGeneralUser>(request, response), znGeneralUser); 
		model.addAttribute("page", page);
		return "modules/znks/znGeneralUserList";
	}

	@RequiresPermissions("znks:znGeneralUser:view")
	@RequestMapping(value = "form")
	public String form(ZnGeneralUser znGeneralUser, Model model) {
		model.addAttribute("znGeneralUser", znGeneralUser);
		return "modules/znks/znGeneralUserForm";
	}

	@RequiresPermissions("znks:znGeneralUser:edit")
	@RequestMapping(value = "save")
	public String save(ZnGeneralUser znGeneralUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, znGeneralUser)){
			return form(znGeneralUser, model);
		}
		znGeneralUserService.save(znGeneralUser);
		addMessage(redirectAttributes, "保存答题者成功");
		return "redirect:"+Global.getAdminPath()+"/znks/znGeneralUser/?repage";
	}
	
	@RequiresPermissions("znks:znGeneralUser:edit")
	@RequestMapping(value = "delete")
	public String delete(ZnGeneralUser znGeneralUser, RedirectAttributes redirectAttributes) {
		znGeneralUserService.delete(znGeneralUser);
		addMessage(redirectAttributes, "删除答题者成功");
		return "redirect:"+Global.getAdminPath()+"/znks/znGeneralUser/?repage";
	}
	/**
	 * 获取微信登录者信息
	 * @param znGeneralUser
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "insertUserInfo")
	public String insertUserInfo(ZnGeneralUser znGeneralUser, HttpServletRequest request, HttpServletResponse response){
		znGeneralUser.setIsNewRecord(true);
		znGeneralUserService.save(znGeneralUser);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("code", "0");
		map.put("message", "保存成功！");
		return renderString(response, map);
	}
}