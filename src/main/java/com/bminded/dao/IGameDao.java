package com.bminded.dao;

import java.util.List;

import com.bminded.entity.CategoryEntity;
import com.bminded.entity.GameEntity;
import com.bminded.entity.SubcategoryEntity;

public interface IGameDao {

	void addGame(GameEntity game);

	GameEntity deleteGame(GameEntity game);

	void insertCategory(CategoryEntity subcategory);

	GameEntity update(GameEntity game);

	List<GameEntity> getAllGamesByUser(Long id);

	GameEntity getOneById(Long id);

	SubcategoryEntity getSubcategoryById(Long id);

	CategoryEntity getCategoryById(Long id);

	void saveSubcategory(SubcategoryEntity subcategory);
}
