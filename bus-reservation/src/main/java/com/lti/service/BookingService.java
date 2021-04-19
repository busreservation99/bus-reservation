package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Booking;
import com.lti.entity.Bus;
import com.lti.exception.BookingServiceException;
import com.lti.exception.RegistrationServiceException;
import com.lti.repository.AdminRepository;
import com.lti.repository.BookingRepository;

@Service
@Transactional
public class BookingService {
	@Autowired
	private BookingRepository bookingrepository;
	//adding booking
		public int addBus(Booking booking) throws BookingServiceException {
			
			if(bookingrepository.isBookingPresent(booking.getId()))
				throw new BookingServiceException("Booking already in database");
			else {
				Booking b = (Booking)bookingrepository.save(booking);
				return b.getId();
			}
		}
	
	

}
