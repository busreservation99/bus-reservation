package com.lti.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookingRepository extends GenericRepository {
	public boolean isBookingPresent(int bookingId) {
		 return  (Long) 
				 entityManager
				 .createQuery("SELECT count(b.id) from Booking b where b.id =:no")
				 .setParameter("no", bookingId)
				 .getSingleResult()==1?true:false;
	}
	
	
}
