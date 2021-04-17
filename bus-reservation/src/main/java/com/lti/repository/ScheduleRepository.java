package com.lti.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Repository;

@Repository
public class ScheduleRepository extends GenericRepository{
	
	public boolean isSchedulePresent(LocalDate departureDate, String departureTime) {
		 return  (Long) 
				 entityManager
				 .createQuery("SELECT count(s.bus) from Schedule s where s.busDepartureDate=:departureDate AND s.departureTime=:departureTime")
				 .setParameter("departureDate", departureDate)
				 .setParameter("departureTime", departureTime)
				 .getSingleResult()==1?true:false;
		
	}		
	
}
