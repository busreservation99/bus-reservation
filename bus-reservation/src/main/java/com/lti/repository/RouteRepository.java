package com.lti.repository;

import org.springframework.stereotype.Repository;

@Repository
public class RouteRepository extends GenericRepository{

	public boolean isRoutePresent(int busNumber) {
		return (Long)
				entityManager
				.createQuery("select count(s.bus) from Route r where r.busNumber=:busNumber")
				.setParameter("busNumber", busNumber)
				.getSingleResult()==1?true:false;
	}
}
