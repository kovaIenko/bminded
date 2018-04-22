package com.bminded.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserSubcategoryID implements Serializable {

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "subcategory_id")
	private Long subcategoryId;

	public UserSubcategoryID(Long userId, Long subcategoryId) {
		this.userId = userId;
		this.subcategoryId = subcategoryId;
	}

	public UserSubcategoryID() {
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(Long subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subcategoryId == null) ? 0 : subcategoryId.hashCode());
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
		UserSubcategoryID other = (UserSubcategoryID) obj;
		if (subcategoryId == null) {
			if (other.subcategoryId != null)
				return false;
		} else if (!subcategoryId.equals(other.subcategoryId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
