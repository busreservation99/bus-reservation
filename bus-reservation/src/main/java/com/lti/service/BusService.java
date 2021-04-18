package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Bus;
import com.lti.exception.BusServiceException;
import com.lti.repository.BusRepository;

@Transactional
@Service
public class BusService {
	
	@Autowired
	private BusRepository busRepository;
	
	public int addBus(Bus bus) {
		if(busRepository.isBusPresent(bus.getSource(), bus.getDestination(), bus.getBusName())){
			throw new BusServiceException("Bus already present");
		}
		
		else {
			Bus updateBus=(Bus) busRepository.save(bus);
			return updateBus.getBusNumber();
		}
	}
}
