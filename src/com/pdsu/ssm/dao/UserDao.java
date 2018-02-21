package com.pdsu.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pdsu.ssm.bean.User;

public interface UserDao {
	//����û�
	public int regist(User user);
	//�ж��û��Ƿ����
	public User isExist(String name);
	//��¼
	public User login(@Param("name") String name,@Param("password") String password);
	//��ѯ����
	public List<User> findAll();
	//�޸�
	public Integer update(User user);
	//����id��ѯ�û�
	public User findById(String id);
	//ɾ��
	public Integer delete(User user); 
}
 