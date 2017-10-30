package com.supermarket.app.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.supermarket.app.entity.Customer;
import com.supermarket.app.repository.ICustomerRepository;

/**
 * Implementation of customer interface service
 * 
 * @author egiraldo
 *
 */
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepository;

	private static Logger _logger = Logger.getLogger(CustomerServiceImpl.class);

	@Override
	public Customer getCustomerEntityByEmail(String email, String requestId) {

		_logger.info("[CustomerServiceImpl][getCustomerEntityByEmail][" + requestId + "] Started.");

		return customerRepository.findByEmail(email);

	}

}
