package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Bus;
import com.lti.entity.Schedule;
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
	
	/*
	 * public List<Schedule> fetchBus(Bus bus){ return
	 * busRepository.getBus(bus.getSource(), bus.getDestination(),
	 * bus.getSchedule());
	 * 
	 * 
	 * }
	 */
	
	public List<Bus> fetchBus(String source, String desitnation){
		return busRepository.getBus(source, desitnation);
			}
}
