package com.cy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pojo.Consulted;

@Mapper
public interface ConsultedDao {
List<Consulted>findPageObjects(@Param("name")String name,
						@Param("startIndex")Integer startIndex,
						@Param("pageSize")Integer pagerSize);
int getRowCount(@Param("name")String name);
int deleteByIds(Integer...ids);
int insertObject(Consulted consulted);
Consulted findById(Integer id);


}
