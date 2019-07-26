package com.cy.servicelmpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.PageObject;
import com.cy.dao.ConsultedDao;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pojo.Consulted;
import com.cy.service.ConsultedService;
@Service
public class ConsultedServicelmpl implements ConsultedService{
	@Autowired
	private ConsultedDao  consultedDao ;
	@Override
	public PageObject<Consulted> findObject(String name, Integer pageCurrent) {
		if (pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("页码不正确");
		int rowCount =  consultedDao.getRowCount(name);
		if (rowCount == 0)
			throw new ServiceException("系统没有找到对应记录");	
		int pageSize = 10;
		int startIndex = (pageCurrent - 1) * pageSize;
		List<Consulted> records =  consultedDao.findPageObjects(name, startIndex, pageSize);
		return new PageObject<>(pageCurrent, pageSize, rowCount, records);
	}
	@Override
	public int delectObject(Integer... ids) {
		if(ids==null||ids.length==0)
			throw new IllegalArgumentException("请选择要删除的");
			int rows = consultedDao.deleteByIds(ids);
		return rows;
	}
	@Override
	public int saveObject(Consulted consulted) {
		if(consulted==null)
			throw new IllegalArgumentException("请输入信息");
		int row = consultedDao.insertObject(consulted);
		return row;
	}
	@Override
	public Consulted findById(Integer id) {
		Consulted consulted= consultedDao.findById(id);
		return consulted;
	}

}
