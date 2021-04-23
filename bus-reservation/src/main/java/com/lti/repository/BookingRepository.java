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
    public String cancellation(int bookingId) {
        List<BusSeat> sid= new ArrayList();
        sid=entityManager
         .createQuery("SELECT s.seatId from BusSeat s join Passenger p on s.seatId=p.seatId join p.booking b on b.id=p.booking.id where b.id=:no ")
         .setParameter("no", bookingId)
         .getResultList();
       
        for(BusSeat list:sid) {
        BusSeat bs= new BusSeat();
        bs=(BusSeat)entityManager.find(BusSeat.class, sid);
        bs.setStatus("Y");
        BusSeat busSeat1= entityManager.merge(bs);
        }
        return "Bus Updated!!";
    }
	
	
}
