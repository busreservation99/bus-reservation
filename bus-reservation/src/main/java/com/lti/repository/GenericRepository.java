package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component its up to us component or repo both will work
@Repository // recommended for Dao Classes
public class GenericRepository { // Repository another name for dao

	@PersistenceContext
	protected EntityManager entityManager; // protected so that child class can inherit it

	public Object save(Object obj) {
		Object updateObj = entityManager.merge(obj);
		return updateObj;
	}


	public <E> E fetch(Class<E> clazz, Object pk) {
		E e = entityManager.find(clazz, pk);
		return e;
	}


}

