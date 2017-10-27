package com.supermarket.app.service;

import com.supermarket.app.entity.Customer;

/**
 * Interface of Customer Service
 * 
 * @author egiraldo
 *
 */
public interface ICustomerService {

	/**
	 * This method will search, in customer repository, the entity customer with the
	 * email entered in the request
	 * 
	 * @param email,
	 *            Email registered for users in DB
	 * @return {@link Customer}
	 */
	public Customer getCustomerEntityByEmail(String email);

}
