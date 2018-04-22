package com.bminded.service;

import java.io.Serializable;
import java.util.List;

public interface IService<E, V, I extends Serializable> {

	boolean save(E entity);

	boolean update(V view);

	boolean delete(I id);

	E getOneById(I id);

	List<E> getList(Criteria<E> criteria);

	int count(Criteria<E> criteria);

}
