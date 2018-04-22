package com.bminded.service;

import java.io.Serializable;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;


public abstract class BaseService<E, V, I extends Serializable> implements IService<E, V, I> {

	private Class<E> persistentClass;
	private EntityManager em;

	public BaseService(Class<E> entityClass) {
		this.persistentClass = entityClass;
	}

	@Override
	@Transactional
	public E getOneById(I id) {
		E instance = em.find(persistentClass, id);
		return instance;
	}
		
	@Override
	@Transactional
	public boolean save(E entity)
	{
		em.persist(entity);
		return true;
	}
	
	@Override
	@Transactional
	public List<E> getList(Criteria<E> criteria)
	{
		return null;
		
	}
}
