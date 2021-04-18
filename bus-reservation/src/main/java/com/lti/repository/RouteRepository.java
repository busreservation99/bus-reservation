package com.lti.repository;

import org.springframework.stereotype.Repository;

@Repository
public class RouteRepository extends GenericRepository{

	public boolean isRoutePresent(int busNumber, String busStopName) {
		return (Long)
				entityManager
				.createQuery("select count(r.bus) from Route r where r.bus.busNumber=:busNumber AND r.busStopName=:bstop")
				.setParameter("busNumber", busNumber)
				.setParameter("bstop", busStopName)
				.getSingleResult()==1?true:false;
	}
}
