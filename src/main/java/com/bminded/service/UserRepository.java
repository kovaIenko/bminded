package com.bminded.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bminded.dao.IUserDao;
import com.bminded.entity.UserEntity;

@Repository
@Transactional
public class UserRepository {

	@Autowired
	private IUserDao user_dao;

	public void addUser(UserEntity user) {
		user_dao.saveUser(user);
	}

	public UserEntity getById(Long id) {
		return user_dao.getOneById(id);
	}

	public void updateUser(UserEntity user) {
		user_dao.updateUser(user);
	}
}
