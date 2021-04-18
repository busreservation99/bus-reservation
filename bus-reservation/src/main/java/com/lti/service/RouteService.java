package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lti.entity.Route;
import com.lti.exception.RouteServiceException;
import com.lti.repository.RouteRepository;

/*Adding Route To Buses*/ /*Arguement Added*/
@Service
@Transactional
public class RouteService {

	
	@Autowired
	private RouteRepository routeRepository;
	
	public int addRoute(Route route) {
		
		if(routeRepository.isRoutePresent(route.getBus().getBusNumber(), route.getBusStopName())){
			throw new RouteServiceException("Route already present");
		}
		else {
			Route updateRoute=(Route) routeRepository.save(route);
			return updateRoute.getRouteId();
		}
	}
}
