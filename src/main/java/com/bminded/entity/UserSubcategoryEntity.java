package com.bminded.entity;

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
		@NamedNativeQuery(name = UserSubcategoryEntity.findAllPointsByUser, query = "select * from user_has_subcategory g where g.user_id = :user_id", resultClass = UserSubcategoryEntity.class) })
@Entity
@Table(name = "user_has_subcategory")
public class UserSubcategoryEntity {

	public static final String findAllPointsByUser = "findAllPointsByUser";

	@EmbeddedId
	private UserSubcategoryID id;

	@ManyToOne
	@JoinColumn(name = "user", insertable = false, updatable = false)
	private UserEntity user;

	@ManyToOne
	@JoinColumn(name = "subcategory", insertable = false, updatable = false)
	private SubcategoryEntity subcategory;

	private int points;

	public UserSubcategoryEntity() {
	}

	public UserSubcategoryEntity(UserEntity user, SubcategoryEntity subcategory) {
		this.user = user;
		this.subcategory = subcategory;
		this.id = new UserSubcategoryID(user.getId(), subcategory.getId());
	}

	public UserSubcategoryID getId() {
		return id;
	}

	public void setId(UserSubcategoryID id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public SubcategoryEntity getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(SubcategoryEntity subcategory) {
		this.subcategory = subcategory;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + points;
		result = prime * result + ((subcategory == null) ? 0 : subcategory.hashCode());
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
		UserSubcategoryEntity other = (UserSubcategoryEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (points != other.points)
			return false;
		if (subcategory == null) {
			if (other.subcategory != null)
				return false;
		} else if (!subcategory.equals(other.subcategory))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserSubcategoryEntity [id=" + id + ", user=" + user + ", subcategory=" + subcategory + ", points="
				+ points + "]";
	}

}
