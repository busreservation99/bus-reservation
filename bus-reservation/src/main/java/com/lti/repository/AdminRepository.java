package com.lti.repository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity.Bus;
import com.lti.entity.BusSeat;
import com.lti.entity.Route;
import com.lti.entity.Schedule;

@Repository
public class AdminRepository extends GenericRepository {
	
	public boolean isBusPresent(int busNumber) {
		 return  (Long) 
				 entityManager
				 .createQuery("SELECT count(b.busNumber) from Bus b where b.busNumber=:no")
				 .setParameter("no", busNumber)
				 .getSingleResult()==1?true:false;
	}
	
	public void removebus(int busNumber2) {
		Bus busnumber = entityManager.find(Bus.class, busNumber2);
		entityManager.remove(busnumber);
	}
	
	
	
}
