package com.lti.repository;

import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository extends GenericRepository {
	
	public boolean isPaymentPresent(int transactionId) {
		 return  (Long) 
				 entityManager
				 .createQuery("SELECT count(r.transactionId) from Payment r where r.transactionId =:em")
				 .setParameter("em", transactionId)
				 .getSingleResult()==1?true:false;
		
	}

}
