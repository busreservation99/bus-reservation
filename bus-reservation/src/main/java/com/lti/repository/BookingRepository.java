package com.lti.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.Booking;
import com.lti.entity.BusSeat;

@Repository
public class BookingRepository extends GenericRepository {
	public boolean isBookingPresent(int bookingId) {
		 return  (Long) 
				 entityManager
				 .createQuery("SELECT count(b.id) from Booking b where b.id =:no")
				 .setParameter("no", bookingId)
				 .getSingleResult()==1?true:false;
	}
	
	@SuppressWarnings("unchecked")
	public String cancellation(int bookingId, int seatPk) {
		List<BusSeat> sid= new ArrayList<BusSeat>();
		sid=entityManager
		 .createQuery("SELECT s.seatId from BusSeat s join Passenger p on s.seatId=p.seatId join p.booking b on b.id=p.bookingId where b.bookingId=:no ")
		 .setParameter("no", bookingId)
		 .getResultList();
		
		for(BusSeat busSeat:sid) {
		BusSeat bs=(BusSeat)entityManager.find(BusSeat.class, seatPk);
		bs.setStatus("Y");
		entityManager.merge(bs);
		}
		return null;
	}
	
}
