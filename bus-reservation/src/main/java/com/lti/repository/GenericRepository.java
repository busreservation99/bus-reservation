package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

	/*This is a Generic Repository for all repo classes*/
	
	@Repository
	public class GenericRepository { 
		
		@PersistenceContext
		protected EntityManager entityManager;
		
		public Object save(Object obj) {
			Object updateObj=entityManager.merge(obj);
			return updateObj;
		}
		
		
		public <E> E fetch(Class<E> clazz, Object pk) {
			E e = entityManager.find(clazz, pk);
			return e;
		}
}
