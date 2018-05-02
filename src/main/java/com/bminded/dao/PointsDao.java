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

    String findByName = "from SubcategoryEntity as s where s.name = ?";

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
    public int getPoints(Long user, Long subcategory)
    {
        UserSubcategoryEntity user_sub = (UserSubcategoryEntity) em.find(UserSubcategoryEntity.class, new UserSubcategoryID(user, subcategory));
        System.out.println("jfdhgufjvhdfuilxgkhfdgjxhvd;kgxd: " + user_sub.getId().getUserId());
        return user_sub.getPoints();
    }

    @Override
    public SubcategoryEntity getOneByName(String category) {
        SubcategoryEntity subcategory_entity = (SubcategoryEntity) em.createQuery(findByName).setParameter(1, category).getSingleResult();
        return subcategory_entity;
    }

}
