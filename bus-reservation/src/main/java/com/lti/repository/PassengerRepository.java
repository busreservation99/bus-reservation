package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Passenger;

@Repository
public class PassengerRepository extends GenericRepository {
	
	public boolean addPassengers(double phoneNumber) {
		return  (Long) 
				 entityManager
				 .createQuery("SELECT count(b.phoneNumber) from Passenger b where b.phoneNumber=:no")
				 .setParameter("no", phoneNumber)
				 .getSingleResult()==1?true:false;		
	}

}
