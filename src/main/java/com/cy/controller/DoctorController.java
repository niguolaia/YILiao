package com.cy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.common.JsonResult;
import com.cy.common.PageObject;

import com.cy.pojo.Doctor;
import com.cy.service.DoctorService;

@Controller
@RequestMapping("doctor/")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
@RequestMapping("doFindPageObjects")
@ResponseBody
public JsonResult dofindObject(String name,Integer pageCurrent) {
	PageObject<Doctor> list = doctorService.findPageObjects(name, pageCurrent);
	return new JsonResult(list);
}
@RequestMapping("doDeleteObjects")
@ResponseBody
public JsonResult doDeleteObjects(
		Integer...ids) {
	doctorService.deleteObjects(ids);
	return new JsonResult("删除成功");
}

@RequestMapping("doSaveObject")
@ResponseBody
public JsonResult doSaveObject(Doctor entity) {
	doctorService.saveObject(entity);
	return new JsonResult("添加成功");
}
@RequestMapping("doUpdateObject")
@ResponseBody
public JsonResult doUpdateObject(Doctor doctor) {
	doctorService.updateObject(doctor);
	return new JsonResult("修改成功");
}
@RequestMapping("doFindObjectById")
@ResponseBody
public JsonResult doFindById(Integer id) {
	System.out.println(id);
	Doctor findById = doctorService.findById(id);
	System.out.println(findById.toString());
	return new JsonResult(findById);
}
}
