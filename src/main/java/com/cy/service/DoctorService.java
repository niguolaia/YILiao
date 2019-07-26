package com.cy.service;


import org.apache.ibatis.annotations.Param;


import com.cy.common.PageObject;
import com.cy.pojo.Doctor;

public interface DoctorService {
	
	PageObject<Doctor> findPageObjects(
			String name,Integer pageCurrent);
	int deleteObjects(@Param("ids")Integer...ids);
	int saveObject(Doctor doctor);
	int updateObject(Doctor doctor);
	Doctor findById(Integer id);
}