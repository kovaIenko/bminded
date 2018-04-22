package com.bminded.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bminded.dao.ILevelDao;
import com.bminded.entity.UserGameEntity;

@Repository
@Transactional
public class LevelRepository {

	@Autowired
	private ILevelDao user_game_dao;

	public void addLevel(UserGameEntity obj) {
		user_game_dao.addLevel(obj);
	}

	public void updateLevel(Long user_id, Long game_id, int new_level) {
		user_game_dao.updateLevel(user_id, game_id, new_level);
	}

}
