package com.bminded.dao;

import com.bminded.entity.UserEntity;
import com.bminded.entity.UserGameEntity;

public interface IUserDao {

	UserEntity addUser(UserEntity user);

	UserEntity deleteUser(UserEntity user);

	void updateUser(UserEntity user);

	UserEntity getOneById(Long id);

	UserEntity getOneByEmail(String email);

	void changePassword(Long id, String old_pass, String new_pass);

	boolean isEmailExist(String email);

	void addUserRole(String email, String role);


    void setPhoto(String name, String reference);
}
