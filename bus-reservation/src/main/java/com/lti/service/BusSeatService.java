package com.lti.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.BusSeat;
import com.lti.entity.Route;
import com.lti.exception.BusSeatServiceException;
import com.lti.exception.RegistrationServiceException;
import com.lti.repository.BusSeatRepository;

@Service
@Transactional
public class BusSeatService {
	
	@Autowired
	private BusSeatRepository busSeatRepository;
	
	public int addSeatsForBus(BusSeat busSeat, int numberOfSeats) {
		if(!busSeatRepository.isBusPresent(busSeat.getBus().getBusNumber())) {
			throw new BusSeatServiceException("Bus not found");
		}
		else {
			for(int i=1;i<=numberOfSeats;i++) {
				busSeat.setSeatNumber(i);
				busSeat.setStatus("Y");
				busSeat.setSchedule(busSeat.getSchedule());
				busSeat.setBus(busSeat.getBus());
				busSeatRepository.save(busSeat);
			}
		}
		return busSeat.getBus().getBusNumber();
	}	
	
		public List getBusSeatStatus(int busNumber, int scheduleId){
			
			List busStatus=busSeatRepository.getStatusAndSeatNumber( busNumber, scheduleId);
			return busStatus;
		}
		public int SeatStatusUpdate(int seatId) {
			return 	busSeatRepository.updateSeatStatus(seatId);
			
		}
}
