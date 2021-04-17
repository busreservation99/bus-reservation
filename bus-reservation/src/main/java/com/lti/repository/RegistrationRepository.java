package com.lti.repository;

import org.springframework.stereotype.Repository;


@Repository
public class RegistrationRepository extends GenericRepository{
		
		public boolean isCustomerPresent(String email) {
			 return  (Long) 
					 entityManager
					 .createQuery("SELECT count(r.registrationId) from Registration r where r.email=:em")
					 .setParameter("em", email)
					 .getSingleResult()==1?true:false;
		}
		
		public int fetchIdByEmailAndPassword(String email, String password) {
			return (Integer)
					entityManager
					 .createQuery("SELECT r.registrationId from Registration r where r.email=:em and r.password=:pw")
					 .setParameter("em", email)
					 .setParameter("pw", password)
					 .getSingleResult();
		}
}
