package com.supermarket.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.supermarket.app.entity.Customer;

/**
 * Repository to access Customer DB table
 * 
 * @author egiraldo
 *
 */
public interface ICustomerRepository extends CrudRepository<Customer, Long> {

	/**
	 * It will search in DB the entity customer related to email entered in request
	 * 
	 * @param email,
	 *            Email registered for users in DB
	 * @return
	 */
	Customer findByEmail(String email);

}
