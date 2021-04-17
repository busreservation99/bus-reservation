package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Bus;
import com.lti.entity.BusSeat;
import com.lti.entity.Route;
import com.lti.exception.RegistrationServiceException;
import com.lti.repository.AdminRepository;
import com.lti.repository.GenericRepository;

@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	//adding bus
	public int addBus(Bus bus) {
		
		if(adminRepository.isBusPresent(bus.getBusNumber()))
			throw new RegistrationServiceException("Bus already in database");
		else {
			Bus b = (Bus)adminRepository.save(bus);
			return b.getBusNumber();
		}
	}
	
	//deleting bus
	public void removeBus(int busNumber) {
		adminRepository.removebus(busNumber);
	}
	//adding routes
	public void addroute(Route route) {
		GenericRepository g = new GenericRepository();
		g.save(route);
	}
	
	
}
