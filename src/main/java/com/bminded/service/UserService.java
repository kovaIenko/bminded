package com.bminded.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bminded.dao.IUserDao;
import com.bminded.entity.UserEntity;

@Service
public class UserService {

	@Autowired
	private IUserDao user_dao;

	public UserEntity addUser(UserEntity user) {
		 return user_dao.addUser(user);
	}
	public  boolean  isEmailExist(String email) {
		return user_dao.isEmailExist(email); }

	public UserEntity getById(Long id) {
		return user_dao.getOneById(id);
	}

	public void updateUser(UserEntity user) {
		user_dao.updateUser(user);
	}
}
