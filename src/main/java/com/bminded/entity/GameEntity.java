package com.bminded.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NamedNativeQueries({
		@NamedNativeQuery(name = GameEntity.findGamesByUser, query = "select * from game g where g.user_id = :user_id", resultClass = GameEntity.class) })
@Entity
@Table(name = "game")
public class GameEntity {

	public static final String findGamesByUser = "GameEntity.findGamesByUser";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TypeGame name;

	@OneToMany(mappedBy = "game")
	private List<UserGameEntity> users;

	@ManyToOne()
	@JoinColumn(name = "subcategory_id", nullable = false)
	private SubcategoryEntity subcategory;

	public GameEntity(TypeGame name) {
		this.name = name;
		users = new ArrayList<UserGameEntity>();
	}

	public GameEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeGame getName() {
		return name;
	}

	public void setName(TypeGame name) {
		this.name = name;
	}

	public List<UserGameEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserGameEntity> users) {
		this.users = users;
	}

	public static String getFindgamesbyuser() {
		return findGamesByUser;
	}

	@Override
	public String toString() {
		return "GameEntity [id=" + id + ", name=" + name  + "]";
	}

	public SubcategoryEntity getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(SubcategoryEntity subcategory) {
		this.subcategory = subcategory;
	}

}