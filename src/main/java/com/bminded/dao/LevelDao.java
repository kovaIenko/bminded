package com.bminded.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.bminded.entity.UserGameEntity;
import com.bminded.entity.UserGameID;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LevelDao implements ILevelDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public void addLevel(UserGameEntity obj) {
        em.persist(obj);
    }

    @Override
    public UserGameEntity updateLevel(Long user_id, Long game_id, int new_level) {
        UserGameEntity usergame = new UserGameEntity();
        usergame.setId(new UserGameID(user_id, game_id));

        usergame.setLevel(new_level);
        em.merge(usergame);

        return usergame;
    }

    @Override
    public int getLevel(Long user, Long game)
    {
        UserGameEntity usergame = (UserGameEntity) em.find(UserGameEntity.class, new UserGameID(user, game));
        return usergame.getLevel();
    }

}
