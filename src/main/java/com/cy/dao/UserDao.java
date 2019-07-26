package com.cy.dao;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cy.pojo.User;

@Mapper
public interface UserDao {
	@Select("select * from user where username=#{username}")
	User findObjectByUsername(String username);

	int getRowCount(@Param("name")String name);
	List<User> findPageObjects(
			@Param("name")String name,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	@Update("update user "
			+ "set valid=#{valid} "
			+ "where id=#{id}")
	int validById(
			@Param("id")Integer id,
			@Param("valid")Integer valid);
	int insertObject(User user);
	 
	
		int updatePassword(
				@Param("password")String password,
				@Param("salt")String salt,
				@Param("id")Integer id);
	 int updateObject(User user);
	 User findObjectById(Integer id);
}
