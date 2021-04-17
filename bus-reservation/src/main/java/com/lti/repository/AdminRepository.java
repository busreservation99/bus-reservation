package com.lti.repository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.entity.Bus;
import com.lti.entity.BusSeat;
import com.lti.entity.Schedule;

public class AdminRepository extends GenericRepository {

	@Autowired
	private GenericRepository gr;
	public void addBusScheduleSeats(String name,String source , String destination ,int noOfSeats , LocalDate startDate , LocalDate endDate) {
		
		Bus bus = new Bus();
		bus.setBusName(name);
		bus.setSource(source);
		bus.setDestination(destination);
		bus.setBusType("AC");
		bus = (Bus)gr.save(bus);
		
		
		long days = ChronoUnit.DAYS.between(startDate,endDate);
		LocalDate tempDate= startDate;
		for(int i=0;i<days;i++) {
			
			Schedule s=  new Schedule();
			s.setBus(bus);
			s.setBusDepartureDate(startDate);
			s.setBusArrivalDate(endDate);
			s= (Schedule)gr.save(s);
			tempDate=tempDate.plusDays(1);
			
			for(int j=1;j<=noOfSeats;j++) {
				BusSeat seat = new BusSeat();
				seat.setSeatNumber(j);
				seat.setBus(bus);
				seat.setPrice(500);
				seat.setStatus("N");
				seat.setSchedule(s);
				seat = (BusSeat)gr.save(seat);
			}
		}
		
		

		
		
	}
}
