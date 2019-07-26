package com.cy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.common.JsonResult;
import com.cy.pojo.Consulted;
import com.cy.service.ConsultedService;

@Controller
@RequestMapping("consulted/")
public class ConsultedController {
	@Autowired
	private ConsultedService consultedService;
	@RequestMapping("doFindPageObjects")
	@ResponseBody
public JsonResult doFindPageObjects(String name,Integer pageCurrent) {
	
	return new JsonResult(consultedService.findObject(name, pageCurrent));
}
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer...ids) {
		 consultedService.delectObject(ids);
		return new JsonResult("删除成功");
	}
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(Consulted consulted) {
		consultedService.saveObject(consulted);
		return new JsonResult("保存成功");
		
		
	}
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindById(Integer id) {
		
		return new JsonResult(consultedService.findById(id));
	}
}
