package com.lti.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.Bus;
import com.lti.entity.Schedule;

@Repository
public class BusRepository extends GenericRepository{
	
	/* Jai Mata Di */
	public boolean isBusPresent(String source, String destination, String busName) {
		 return  (Long) 
				 entityManager
				 .createQuery("SELECT count(b.busNumber) from Bus b where b.source=:src AND b.destination=:dst AND b.busName=:bName")
				 .setParameter("src", source)
				 .setParameter("dst", destination)
				 .setParameter("bName", busName)
				 .getSingleResult()==1?true:false;
	}
	
//	public List<Schedule> getBus(String source, String destination,  List<Schedule> schedule ){
//		return 
//				entityManager
//				.createQuery("select b.source,b.destination,s.busDepartureDate from Bus b join Schedule s on b.busNumber=s.busNumber where b.source=:src and"
//						+ "b.destination=:dst and s.busDepartureDate=:date")
//				.setParameter("date", schedule)
//				.setParameter("dst", destination)
//				.setParameter("src", source)
//				.getResultList();		
//	}
	public List<Bus> getBus(String source, String destination){
		return 
				entityManager
				.createQuery("select b.source,b.destination from Bus b WHERE b.source=:src and b.destination=:dst")
				.setParameter("dst", destination)
				.setParameter("src", source)
				.getResultList();		
	}

	
	
	@SuppressWarnings("unchecked")
	public List<Schedule> getBus2(String source, String destination, LocalDate date){
		return 
				entityManager
				.createQuery("select b.source,s.busDepartureDate from Schedule s join s.bus b where b.source=:src and b.destination=:dst and s.busDepartureDate=:date")    
				.setParameter("dst", destination)
				.setParameter("src", source)
				.setParameter("date", date)
				.getResultList();		
	}

}
