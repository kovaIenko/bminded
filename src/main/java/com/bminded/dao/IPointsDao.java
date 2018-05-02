package com.bminded.dao;


import java.util.List;

import com.bminded.entity.SubcategoryEntity;
import com.bminded.entity.UserEntity;
import com.bminded.entity.UserSubcategoryEntity;

public interface IPointsDao {

	void savePoints(UserSubcategoryEntity points);

	UserSubcategoryEntity updatePoints(Long user, Long subcategory, int points);

	SubcategoryEntity  getOneByName(String category);

	int getPoints(Long user, Long subcategory);

}
