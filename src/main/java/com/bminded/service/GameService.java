package com.bminded.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bminded.dao.IGameDao;
import com.bminded.entity.CategoryEntity;
import com.bminded.entity.GameEntity;
import com.bminded.entity.SubcategoryEntity;

@Service
public class GameService {

	@Autowired
	private IGameDao game_dao;

	public void addGame(GameEntity game) {
		game_dao.addGame(game);
	}

	public GameEntity getGameById(Long id) {
		return game_dao.getOneById(id);
	}

	public CategoryEntity insertCategory(CategoryEntity subcategory) {
		game_dao.insertCategory(subcategory);
		return subcategory;
	}

	public GameEntity updateGame(final GameEntity game) {
		return game_dao.update(game);
	}

	public List<GameEntity> getAllGamesByUser(Long id) {
		return game_dao.getAllGamesByUser(id);
	}

	public SubcategoryEntity getSubcategoryById(Long id) {
		return game_dao.getSubcategoryById(id);
	}

	public void saveSubcategory(SubcategoryEntity subcategory) {
		game_dao.saveSubcategory(subcategory);
	}

	public CategoryEntity getCategoryById(Long id) {
		return game_dao.getCategoryById(id);
	}
}
