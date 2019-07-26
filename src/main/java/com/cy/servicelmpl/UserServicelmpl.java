package com.cy.servicelmpl;

import java.util.List;

import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.common.PageObject;
import com.cy.dao.UserDao;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pojo.User;
import com.cy.service.UserService;
@Service
public class UserServicelmpl implements UserService{
@Autowired
private UserDao userDao;
	@Override
	public PageObject<User> findObjects(String name, Integer pageCurrent) {
		if (pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("页码不正确");
		int rowCount = userDao.getRowCount(name);
		if (rowCount == 0)
			throw new ServiceException("系统没有找到对应记录");	
		int pageSize = 10;
		int startIndex = (pageCurrent - 1) * pageSize;
		List<User> records = userDao.findPageObjects(name, startIndex, pageSize);
		return new PageObject<>(pageCurrent, pageSize, rowCount, records);
	}
	@Override
	public int validById(Integer id, Integer valid) {
		if(id==null||id<0)
			throw new IllegalArgumentException("id值不合法");
		if(valid!=1&&valid!=0)
		throw new IllegalArgumentException("状态值不正确");
		//..
		int rows=userDao.validById(id, valid);
		if(rows==0)
		throw new ServiceException("记录可能已经存在");
		return rows;
	}
	@Override
	public int SaveObject(User user) {
		if (user==null)
			throw new IllegalArgumentException("请输入用户");
		if(StringUtils.isEmpty(user.getPassword()))
			throw new IllegalArgumentException("请输入密码");
		String salt=UUID.randomUUID().toString();
		SimpleHash sh=new SimpleHash(
				"MD5",//algorithmName 加密算法 
				user.getPassword(), //source 没加密的密码
				salt, //盐值
				1);//hashIterations
		user.setSalt(salt);
		user.setPassword(sh.toHex());
		int row = userDao.insertObject(user);
		return row;
	}
	@Override
	public int updatePassword(String oldPassword, String newPassword, String cfgPassword) {
		   //1.验证非空
		if(StringUtils.isEmpty(oldPassword))
			throw new IllegalArgumentException("原密码不能空");
			if(StringUtils.isEmpty(newPassword))
			throw new IllegalArgumentException("新密码不能空");
			//2.验证原密码是否正确
			User user=(User)
			SecurityUtils.getSubject().getPrincipal();
			SimpleHash sh=new SimpleHash("MD5",
			oldPassword,user.getSalt(),1);
			if(!user.getPassword().equals(sh.toHex()))
			throw new IllegalArgumentException("输入的原密码不正确");
			//3.验证两次输入密码是否一致
			if(!newPassword.equals(cfgPassword))
			throw new IllegalArgumentException("两次密码输入不一致");
			//4.更新密码并返回结果
			String salt=UUID.randomUUID().toString();
		    sh=new SimpleHash("MD5",newPassword,salt, 1024);
			int rows=userDao.updatePassword(sh.toHex(), salt,user.getId());
			return rows;
		
	}
	@Override
	public int updateObject(User user) {
		if(user==null)
			throw new IllegalArgumentException("保存对象不能为空");
			if(StringUtils.isEmpty(user.getUsername()))
			throw new IllegalArgumentException("用户名不能为空");
			//2.写用户信息
			@SuppressWarnings("unused")
			int rows=userDao.updateObject(user);
		return 0;
	}
	@Override
	public User findObjectById(Integer id) {
		 if(id==null||id<1)
			 throw new IllegalArgumentException("id值无效");
			 //2.查询用户以及对应的部门信息
			User user=
			 userDao.findObjectById(id);
		return user;
	}

}
