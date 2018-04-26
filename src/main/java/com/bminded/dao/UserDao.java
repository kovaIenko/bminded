package com.bminded.dao;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    public boolean isEmailExist(String email) {


        String hql = "from UserEntity as u where u.email = ?";
        UserEntity user = (UserEntity) em.createQuery(hql).setParameter(1, email).getSingleResult();

        if (user!=null)
            return true;
        return false;
    }

    @Override
    public void addUserRole(String email, String role) {
        String query = "insert into user_roles values(email, role)";

        em.createNativeQuery(query)
                .setParameter(email, role)
                .executeUpdate();
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
