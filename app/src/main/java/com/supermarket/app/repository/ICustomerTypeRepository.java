package com.supermarket.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.supermarket.app.entity.CustomerType;

/**
 * Repository to access Customer Typy DB table
 * 
 * @author egiraldo
 *
 */
public interface ICustomerTypeRepository extends CrudRepository<CustomerType, Long>{

}
