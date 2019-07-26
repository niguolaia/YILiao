package com.cy.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.common.JsonResult;
import com.cy.pojo.User;
import com.cy.service.UserService;

@Controller
@RequestMapping("user/")
public class UserController {
	@Autowired
	private UserService userService;
	 @RequestMapping("doLogin")
	   @ResponseBody
	   public JsonResult doLogin(String username,String password){
		   //1.获取Subject对象
		   Subject subject=SecurityUtils.getSubject();
		   //2.通过Subject提交用户信息,交给shiro框架进行认证操作
		   //2.1对用户进行封装
		   UsernamePasswordToken token=
		   new UsernamePasswordToken(
				   username,//身份信息
				   password);//凭证信息
		   //2.2对用户信息进行身份认证
		   subject.login(token);
		   //分析:
		   //1)token会传给shiro的SecurityManager
		   //2)SecurityManager将token传递给认证管理器
		   //3)认证管理器会将token传递给realm
		   return new JsonResult("login ok");
	   }

	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String name,Integer pageCurrent) {
		return new JsonResult(userService.findObjects(name, pageCurrent));
	}
	@RequestMapping("doValidById")
	@ResponseBody
	public JsonResult doValidById(Integer id,Integer valid) {
		userService.validById(id, valid);
		return new JsonResult("修改成功");
	}
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(User user) {
		userService.SaveObject(user);
		return new JsonResult("保存成功");
	}
	@RequestMapping("doUpdatePassword")
	@ResponseBody
	public JsonResult doUpdatePassword(String oldPassword,String newPassword,String cfgPassword) {
		userService.updatePassword(oldPassword, newPassword, cfgPassword);
		return new JsonResult("修改成功");
	}
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doupdateObject(User user) {
		userService.updateObject(user);
		return new JsonResult("修改成功");
	}
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindById(Integer id) {
		User user = userService.findObjectById(id);
		return new JsonResult(user);
	}
	
}
