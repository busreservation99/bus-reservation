package com.lti.repository;

import org.springframework.stereotype.Repository;

import com.lti.entity.Bus;
import com.lti.entity.BusSeat;

@Repository
public class BusSeatRepository extends GenericRepository{
	public boolean isBusPresent(int busNumber) {
		return (Long)
		entityManager
		.createQuery("SELECT COUNT(b.busNumber) from Bus b where b.busNumber=:bNumber")
		.setParameter("bNumber", busNumber)
		.getSingleResult()==1?true:false;
	}
	
	
}
