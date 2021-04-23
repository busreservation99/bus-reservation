package com.lti.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.Bus;
import com.lti.entity.BusSeat;

@Repository
public class BusSeatRepository extends GenericRepository{
	public boolean isBusPresent(int busNumber) {
		return (Long)
		entityManager
		.createQuery("SELECT COUNT(b.busNumber) from Bus b where b.busNumber=:bNumber")
		.setParameter("bNumber", busNumber)
		.getSingleResult()==1?true:false;
	}
	
	public List getStatusAndSeatNumber(int busNumber,int scheduleId) {
		List seatStatus=new ArrayList<>();
		seatStatus=
		entityManager
		.createQuery("select s.status,s.seatNumber from  BusSeat s where s.schedule.scheduleId=:sid and s.bus.busNumber=:bn")
		.setParameter("sid", scheduleId)
		.setParameter("bn", busNumber)
		.getResultList();
		
		
		return seatStatus;
	}
	
}
