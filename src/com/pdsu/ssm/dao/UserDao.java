package com.pdsu.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pdsu.ssm.bean.User;

public interface UserDao {
	//添加用户
	public int regist(User user);
	//判断用户是否存在
	public User isExist(String name);
	//登录
	public User login(@Param("name") String name,@Param("password") String password);
	//查询所有
	public List<User> findAll();
	//修改
	public Integer update(User user);
	//根据id查询用户
	public User findById(String id);
	//删除
	public Integer delete(User user); 
}
 