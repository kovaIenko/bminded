package com.bminded.entity;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@NamedNativeQueries({
	@NamedNativeQuery(name = UserGameEntity.findGamesByUser, query = "select * from user_has_game ug where ( ug.user_id = :user_id && ug", resultClass = GameEntity.class) })
@Entity
@Table(name = "user_has_game")
public class UserGameEntity {

	 public static final String findGamesByUser="UserGameEntity.findGamesByUser";
	@EmbeddedId
	private UserGameID id;

	@ManyToOne
	@JoinColumn(name="user", insertable = false, updatable = false)
	private UserEntity user;

	@ManyToOne
	@JoinColumn(name="game", insertable = false, updatable = false)
	private GameEntity game;

	private int level;

	public UserGameEntity() {
	}

	public UserGameEntity(UserEntity user, GameEntity game) {
		this.user = user;
		this.game = game;
		this.id = new UserGameID(user.getId(), game.getId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((game == null) ? 0 : game.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + level;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		UserGameEntity other = (UserGameEntity) obj;
		if (game == null) {
			if (other.game != null)
				return false;
		} else if (!game.equals(other.game))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (level != other.level)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public UserGameID getId() {
		return id;
	}

	public void setId(UserGameID id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public GameEntity getGame() {
		return game;
	}

	public void setGame(GameEntity game) {
		this.game = game;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "UserGameEntity [id=" + id + ", user=" + user + ", game=" + game + ", level=" + level + "]";
	}

}
