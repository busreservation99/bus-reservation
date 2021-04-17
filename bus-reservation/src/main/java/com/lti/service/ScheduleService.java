package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Schedule;
import com.lti.exception.ScheduleServiceException;
import com.lti.repository.ScheduleRepository;

@Service
@Transactional
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	public int addschedule(Schedule schedule) {
		
		if(scheduleRepository.isSchedulePresent(schedule.getBusDepartureDate(), schedule.getDepartureTime())){
			throw new ScheduleServiceException("Schedule already present");
		}
		else {
			Schedule updateSchedule=(Schedule) scheduleRepository.save(schedule);
			return updateSchedule.getScheduleId();
		}
	}
}
