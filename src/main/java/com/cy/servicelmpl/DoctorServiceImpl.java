package com.cy.servicelmpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.PageObject;
import com.cy.dao.DoctorDao;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pojo.Doctor;
import com.cy.service.DoctorService;
@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorDao doctorDao;
	
	@Override
	public PageObject<Doctor> findPageObjects(String name, Integer pageCurrent) {
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码不正确");
		int rowCount = doctorDao.getRowCount(name);
		if (rowCount == 0)
			throw new ServiceException("系统没有找到对应记录");	
		int pageSize = 3;
		int startIndex = (pageCurrent - 1) * pageSize;
		List<Doctor> records = doctorDao.findPageObjects(name, startIndex, pageSize);
		return new PageObject<>(pageCurrent, pageSize, rowCount, records);
	}

	@Override
	public int deleteObjects(Integer... ids) {
		//1.参数校验
		if(ids==null||ids.length==0)
		throw new IllegalArgumentException("请先选择");
		//2.执行删除
		int rows=doctorDao.deleteByIds(ids);
		return rows;
	}
	@Override
	public int saveObject(Doctor doctor) {
		if(!(doctor.getEmail().matches("[a-zA-Z0-9._]+@[a-zA-Z0-9._]+(\\.[a-zA-Z0-9_]+)+")))
		throw new ServiceException("邮箱格式错误");
//		if(!(doctor.getTel().matches("/^[1][3,4,5,7,8][0-9]{9}$/")))
//			throw new ServiceException("请输入正确的手机号");
		
		int rows = doctorDao.insertObject(doctor);
		return rows;
	}

	@Override
	public int updateObject(Doctor doctor) {
		if(doctor==null)
			throw new IllegalArgumentException("保存对象不能为空");
		int row = doctorDao.updateObject(doctor);
		return row;
	}

	@Override
	public Doctor findById(Integer id) {
		if(id==null||id<1)
			throw new IllegalArgumentException("id值不正确");
		Doctor findById = doctorDao.findById(id);
		return findById;
	}



}
