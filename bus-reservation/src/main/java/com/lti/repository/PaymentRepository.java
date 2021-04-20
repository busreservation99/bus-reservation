package com.lti.repository;

import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository extends GenericRepository {
	
	public boolean isPaymentPresent(int paymentId) {
		 return  (Long) 
				 entityManager
				 .createQuery("SELECT count(r.id) from Payment r where r.id =:em")
				 .setParameter("em", paymentId)
				 .getSingleResult()==1?true:false;
		
	}

}
