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
	//	ע��
	public int regist(User user) {
		return userDao.regist(user);
	}
	//	��֤�û����Ƿ��Ѿ�����
	public User isExist(String name) {
		return userDao.isExist(name);
	}
	//��¼
	public User login(String name,String password) {
		return userDao.login(name, password);
	}
	//��������
	public List<User> findAll(){
		return userDao.findAll();
	}
	//����
	public int update(User user) {
		return userDao.update(user);
	}
	
	public User findById(String id) {
		return userDao.findById(id);
	}
	//ɾ��
	public int delete(User user) {
		return userDao.delete(user);
	}
}
