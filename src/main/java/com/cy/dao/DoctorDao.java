package com.cy.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.cy.pojo.Doctor;

@Mapper
public interface DoctorDao {
	List<Doctor>findPageObjects(@Param("name")String name,
							@Param("startIndex") Integer startIndex,
							@Param("pageSize") Integer pageSize);
	int getRowCount(@Param("name")String name);
	int deleteByIds(Integer...ids);
	int insertObject(Doctor doctor);
	int updateObject(Doctor doctor);
	Doctor findById(Integer id);
}
