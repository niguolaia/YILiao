package com.cy.common.web;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * 统一异常处理类
 */
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.common.JsonResult;


/**
 * SpringMVC 全局异常处理
 * @ControllerAdvice 描述的类为全局异常处理类
 */
@ControllerAdvice //此类也会交给spring管理
public class GlobalExceptionHandler {
	/**
	 * @ExceptionHandler 注解描述的方法是异常处理方法
	 */
	@ResponseBody
	@ExceptionHandler(RuntimeException.class)//jdk中的自带的日志api
	public JsonResult doHandleRuntimeException(RuntimeException e) {
		e.printStackTrace();//打印异常信息
		return new JsonResult(e);//封装异常信息
	}
	@ExceptionHandler(ShiroException.class)
	@ResponseBody
	public JsonResult doHandleShiroException(
			ShiroException e) {
		JsonResult r=new JsonResult();
		r.setState(0);
		if(e instanceof UnknownAccountException) {
			r.setMessage("账户不存在");
		}else if(e instanceof LockedAccountException) {
			r.setMessage("账户已被禁用");
		}else if(e instanceof IncorrectCredentialsException) {
			r.setMessage("密码不正确");
		}else if(e instanceof AuthorizationException) {
			r.setMessage("没有此操作权限");
		}else {
			r.setMessage("系统维护中");
		}
		e.printStackTrace();
		return r;
	}

}
