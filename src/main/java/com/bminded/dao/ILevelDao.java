package com.bminded.dao;

import com.bminded.entity.UserGameEntity;

public interface ILevelDao {

	void addLevel(UserGameEntity obj);
	
	UserGameEntity updateLevel(Long user_id, Long game_id, int level);

}
