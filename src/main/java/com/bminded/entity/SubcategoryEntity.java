package com.bminded.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subcategory")
public class SubcategoryEntity {
 
	 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private CategoryEntity category;

	@OneToMany( mappedBy = "subcategory", cascade = CascadeType.ALL)
	private List<GameEntity> games;

	@OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL)
	private List<UserSubcategoryEntity> users;

	@Column(name = "name", nullable = false)
	private String name;

	public SubcategoryEntity(String name) {
		this.name = name;
	}

	public SubcategoryEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<GameEntity> getGames() {
		return games;
	}

	public void setGames(List<GameEntity> games) {
		this.games = games;
	}

	public List<UserSubcategoryEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserSubcategoryEntity> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((games == null) ? 0 : games.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		SubcategoryEntity other = (SubcategoryEntity) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (games == null) {
			if (other.games != null)
				return false;
		} else if (!games.equals(other.games))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubcategoryEntity [id=" + id + ", category=" + category.getName() + ", games=" + games + ", users=" + users
				+ ", name=" + name + "]";
	}

}
