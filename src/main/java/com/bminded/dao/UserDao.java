package com.bminded.dao;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import com.bminded.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDao implements IUserDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public UserEntity deleteUser(UserEntity user) {
		em.remove(user);
		return user;
	}

	@Override
	public UserEntity addUser(UserEntity user) {
		 return em.merge(user);
	}

	@Override
	public boolean isEmailExist(String email)
	{
//		UserEntity user =  em.find(UserEntity.class, email);
//		if(user!=null)
//			return true;
		return false;
	}

	@Override
	public void updateUser(UserEntity user) {
		em.merge(user);
	}

	@Override
	public UserEntity getOneById(Long id) {
		UserEntity user = (UserEntity) em.find(UserEntity.class, id);
		return user;
	}

	@Override
	public void changePassword(Long id, String old_pass, String new_pass) {
		UserEntity temp = (UserEntity) this.getOneById(id);
		temp.setPassword(new_pass);
		em.persist(temp);

	}

	@Override
	public void setPhoto(Long id, String reference) {
		UserEntity temp = (UserEntity) this.getOneById(id);
		temp.setPhoto_ref(reference);
		em.persist(temp);
	}

}
