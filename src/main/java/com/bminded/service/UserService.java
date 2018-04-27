package com.bminded.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bminded.dao.IUserDao;
import com.bminded.entity.UserEntity;

@Service
public class UserService {

    @Autowired
    private IUserDao user_dao;
    @Autowired
    PasswordEncoder passwordEncoder;

    public UserEntity addUser(UserEntity user) {
        String pass = user.getPassword();
        user.setPassword(passwordEncoder.encode(pass));
        user.setEnabled(true);
        return user_dao.addUser(user);
    }
    public UserEntity getOneByEmail(String email)
    {
        return user_dao.getOneByEmail(email);
    }

    public void addUserRole(String email, String role) {
        user_dao.addUserRole(email, role);
    }

    public boolean isEmailExist(String email) {
        return user_dao.isEmailExist(email);
    }

    public UserEntity getById(Long id) {
        return user_dao.getOneById(id);
    }

    public void updateUser(UserEntity user) {
        user_dao.updateUser(user);
    }
}
