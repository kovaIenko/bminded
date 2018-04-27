package com.bminded.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bminded.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bminded.entity.CategoryEntity;
import com.bminded.entity.GameEntity;
import com.bminded.entity.SubcategoryEntity;
@Repository
@Transactional
public class GameDao implements IGameDao {

	String findByName = "from GameEntity as g where g.name= ?";

	@PersistenceContext
	private EntityManager em;

	@Override
	public void addGame(GameEntity game) {
		em.persist(game);
	}

	@Override
	public GameEntity deleteGame(GameEntity game) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public GameEntity getOneByName(String game)
	{
		GameEntity game_entity = (GameEntity) em.createQuery(findByName).setParameter(1, game).getSingleResult();

		return game_entity;
	}

	@Override
	public void insertCategory(CategoryEntity subcategory) {
		em.persist(subcategory);
	}

	@Override
	public GameEntity update(GameEntity game) {
		return em.merge(game);
	}

	@Override
	public List<GameEntity> getAllGamesByUser(Long id) {
		Query query = em.createNamedQuery(GameEntity.findGamesByUser).setParameter("user_id", id);
		List<GameEntity> results = query.getResultList();
		return results;
	}

	@Override
	public GameEntity getOneById(Long id) {
		GameEntity game = (GameEntity) em.find(GameEntity.class, id);
		return game;
	}

	@Override
	public SubcategoryEntity getSubcategoryById(Long id) {
		SubcategoryEntity subcategory = (SubcategoryEntity) em.find(SubcategoryEntity.class, id);
		return subcategory;
	}

	@Override
	public void saveSubcategory(SubcategoryEntity subcategory) {
		em.persist(subcategory);
	}

	@Override
	public CategoryEntity getCategoryById(Long id) {
		CategoryEntity category = em.find(CategoryEntity.class, id);
		return category;
	}

}
