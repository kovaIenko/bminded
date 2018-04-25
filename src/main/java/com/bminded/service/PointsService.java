package com.bminded.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bminded.dao.IPointsDao;
import com.bminded.entity.UserEntity;
import com.bminded.entity.UserSubcategoryEntity;

@Service
public class PointsService {

	@Autowired
	private IPointsDao points_dao;

	public void savePoints(UserSubcategoryEntity points) {
		points_dao.savePoints(points);
	}

	public UserSubcategoryEntity update(Long user, Long subcategory, int points) {
		return points_dao.updatePoints(user, subcategory, points);
	}

	public List<UserSubcategoryEntity> getAllPointsBuUser(UserEntity user) {
		return points_dao.getAllPointsByUser(user);
	}
}
