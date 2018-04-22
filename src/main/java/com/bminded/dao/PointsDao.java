package com.bminded.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.bminded.entity.UserEntity;
import com.bminded.entity.UserSubcategoryEntity;
import com.bminded.entity.UserSubcategoryID;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PointsDao implements IPointsDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void savePoints(UserSubcategoryEntity points) {
		em.persist(points);
	}

	@Override
	public UserSubcategoryEntity updatePoints(Long user, Long subcategory, int points) {
		UserSubcategoryID key = new UserSubcategoryID(user, subcategory);

		UserSubcategoryEntity pnt = em.find(UserSubcategoryEntity.class, key);
		pnt.setPoints(points);
		em.merge(pnt);
		return pnt;
	}

	@Override
	public List<UserSubcategoryEntity> getAllPointsByUser(UserEntity user) {
		Query query = em.createNamedQuery(UserSubcategoryEntity.findAllPointsByUser).setParameter("user_id",
				user.getId());
		List<UserSubcategoryEntity> subcategories = query.getResultList();
		return subcategories;
	}

}
