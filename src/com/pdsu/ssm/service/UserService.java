package com.pdsu.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdsu.ssm.bean.User;
import com.pdsu.ssm.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	//	注册
	public int regist(User user) {
		return userDao.regist(user);
	}
	//	验证用户名是否已经存在
	public User isExist(String name) {
		return userDao.isExist(name);
	}
	//登录
	public User login(String name,String password) {
		return userDao.login(name, password);
	}
	//查找所有
	public List<User> findAll(){
		return userDao.findAll();
	}
	//更新
	public int update(User user) {
		return userDao.update(user);
	}
	
	public User findById(String id) {
		return userDao.findById(id);
	}
	//删除
	public int delete(User user) {
		return userDao.delete(user);
	}
}
