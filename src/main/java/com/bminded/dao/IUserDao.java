package com.bminded.dao;

import com.bminded.entity.UserEntity;
import com.bminded.entity.UserGameEntity;

public interface IUserDao {

	UserEntity addUser(UserEntity user);

	UserEntity deleteUser(UserEntity user);

	void updateUser(UserEntity user);

	UserEntity getOneById(Long id);

	void changePassword(Long id, String old_pass, String new_pass);

	void setPhoto(Long id, String reference);

	boolean isEmailExist(String email);

}
