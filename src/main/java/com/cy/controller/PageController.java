package com.cy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
	@RequestMapping("doIndex")
	public String doIndex() {
		System.out.println("hello");
		return "starter";
	}
	//医生信息管理页面
	@RequestMapping("doctor/doDoctorListUI")
	public String doLogUI() {
		return "doctor/doctor_list";
	}
	//中药信息管理页面
	@RequestMapping("drug/doDrugListUI")
	public String doDrugListUI() {
		return "drug/drug_list";
	}
	//西药信息管理页面
	@RequestMapping("drug/xdoDrugListUI")
	public String xdoDrugListUI() {
		return "drug/drug_list";
	}
	//分页页面
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}
	//登录页面
	@RequestMapping("doLoginUI")
	public String doLoginUI() {
		return"login";
	}
	//咨询室页面
	@RequestMapping("doPublic")
	public String doPublic() {
		return"chart/chart";
	}
	@RequestMapping("doPublic1")
	public String doPublic1() {
		return"chart/chart1";
	}
//	咨询者页面
	@RequestMapping("consulted/doConsultedListUI")
	public String doConsultedListUI() {
		return "consulted/consulted_list";
	}
	//患者信息页面
	@RequestMapping("patient/doPatientListUI")
	public String doPatientListUI() {
		return "patient/patient_list";
	}
	@RequestMapping("patient/doPatientEditUI")
	public String doPatientEditUI() {
		return "patient/patient_edit";
	}
	@RequestMapping("doctor/doDoctorEditUI")
	public String doDoctorEditUI() {
		return "doctor/doctor_edit";
	}
	@RequestMapping("consulted/doConsultedEditUI")
	public String doConsultedEditUI() {
		return "consulted/consulted_edit";
	}
	@RequestMapping("user/doUserListUI")
	public String doUserListUI() {
		return "user/user_list";
	}
	@RequestMapping("user/doUserEditUI")
	public String doUserEditUI() {
		return "user/user_edit";
	}
	@RequestMapping("user/doUserEditNoPwdUI")
	public String doUserEditNoPwdUI() {
		return "user/user_editnopwd";
	}
	
	@RequestMapping("pwd/doPwdEditUI")
	public String doPWEditUI() {
		return "user/pwd_edit";
	}
	
}
