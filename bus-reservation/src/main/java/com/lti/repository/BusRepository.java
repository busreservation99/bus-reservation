package com.lti.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BusRepository extends GenericRepository{
	
	/* Jai Mata Di */
	public boolean isBusPresent(String source, String destination, String busName) {
		 return  (Long) 
				 entityManager
				 .createQuery("SELECT count(b.busNumber) from Bus b where b.source=:src AND b.destination=:dst AND b.busName=:bName")
				 .setParameter("src", source)
				 .setParameter("dst", destination)
				 .setParameter("bName", busName)
				 .getSingleResult()==1?true:false;
	}
	
}
