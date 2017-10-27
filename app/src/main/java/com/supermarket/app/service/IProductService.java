package com.supermarket.app.service;

import java.util.List;

import com.supermarket.app.entity.Product;

/**
 * Interface of Product Service
 * 
 * @author egiraldo
 *
 */
public interface IProductService {
	
	/**
	 * This class will search all product entities in product repository
	 * 
	 * @return {@link Product}
	 */
	public Product getProductByName(String nameRegistered);

}
