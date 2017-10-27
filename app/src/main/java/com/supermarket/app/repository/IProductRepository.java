package com.supermarket.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.supermarket.app.entity.Product;

/**
 * Repository to access Product DB table
 * 
 * @author egiraldo
 *
 */
public interface IProductRepository extends CrudRepository<Product, Long> {
	
	/**
	 * It will find products of a specific category
	 * @return
	 */
	Product findByName(String name);

}
