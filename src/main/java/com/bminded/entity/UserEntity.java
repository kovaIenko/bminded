package com.bminded.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "users")
//@NamedQuery(name = UserEntity.isEmailExist, query = "select u.email from users as u where u.email= :email")
public class UserEntity {

	//public static final String isEmailExist = "isEmailExist";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	private String email;
	private String photo_ref;
	private String password;

	private String first_name;
	private String second_name;

	private int currency;

	@OneToMany(mappedBy = "user")
	private Set<UserGameEntity> games;

	@OneToMany(mappedBy = "user")
	private Set<UserSubcategoryEntity> subcategories;

	public UserEntity(String email, String password, String first_name, String second_name) {
		this.email = email;
		this.password = password;
		this.first_name = first_name;
		this.second_name = second_name;
		games = new HashSet<UserGameEntity>(0);
		subcategories = new HashSet<UserSubcategoryEntity>(0);
	}

	public UserEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto_ref() {
		return photo_ref;
	}

	public void setPhoto_ref(String photo_ref) {
		this.photo_ref = photo_ref;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getSecond_name() {
		return second_name;
	}

	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}

	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	public Set<UserGameEntity> getGames() {
		return games;
	}

	public void setGames(Set<UserGameEntity> games) {
		this.games = games;
	}

	public Set<UserSubcategoryEntity> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(Set<UserSubcategoryEntity> subcategories) {
		this.subcategories = subcategories;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", email=" + email + ", photo_ref=" + ", password=" + password
				+ ", first_name=" + first_name + ", second_name=" + second_name + ", currency=" + currency + "]";
	}

}
