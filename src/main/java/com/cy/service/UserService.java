package com.cy.service;
import com.cy.common.PageObject;
import com.cy.pojo.User;


public interface UserService {
	PageObject<User>findObjects(String name,Integer pageCurrent);
	int validById(Integer id,Integer valid);
	int SaveObject(User user);
	int updatePassword(
			String oldPassword,
			String newPassword,
			String cfgPassword);
	int updateObject(User user);
	User findObjectById(
			Integer id);
}
