package com.supermarket.app.service;

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
	
	@Override
	public Customer getCustomerEntityByEmail(String email) {
		
		return customerRepository.findByEmail(email);
		
	}
	
}
