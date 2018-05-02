package com.bminded.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bminded.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PointsDao implements IPointsDao {

    @PersistenceContext
    private EntityManager em;

    String findByName = "from SubcategoryEntity as s where s.name= ?";

    @Override
    public void savePoints(UserSubcategoryEntity points) {
        em.persist(points);
    }

    @Override
    public UserSubcategoryEntity updatePoints(Long user, Long subcategory, int points) {
        UserSubcategoryEntity userSubcategory = new UserSubcategoryEntity();
        userSubcategory.setId(new UserSubcategoryID(user, subcategory));
        userSubcategory.setPoints(points);
        return em.merge(userSubcategory);
    }

    @Override
    public List<UserSubcategoryEntity> getAllPointsByUser(UserEntity user) {
        Query query = em.createNamedQuery(UserSubcategoryEntity.findAllPointsByUser).setParameter("user_id",
                user.getId());
        List<UserSubcategoryEntity> subcategories = query.getResultList();
        return subcategories;
    }

    @Override
    public SubcategoryEntity getOneByName(String category) {
        SubcategoryEntity subcategory_entity = (SubcategoryEntity) em.createQuery(findByName).setParameter(1, category).getSingleResult();
        return subcategory_entity;
    }

}
