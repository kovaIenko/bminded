package com.bminded.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserGameID implements  Serializable{
  
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="game_id")
	private Long gameId;
	
	
	public UserGameID(Long userId,Long gameId)
	{
		this.userId = userId;
		this.gameId = gameId;
	}
	
	
	public UserGameID() {}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getGameId() {
		return gameId;
	}


	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gameId == null) ? 0 : gameId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserGameID other = (UserGameID) obj;
		if (gameId == null) {
			if (other.gameId != null)
				return false;
		} else if (!gameId.equals(other.gameId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
}
