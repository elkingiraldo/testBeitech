package com.supermarket.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.supermarket.app.entity.Product;
import com.supermarket.app.repository.IProductRepository;

/**
 * Implementation of product interface service
 * 
 * @author egiraldo
 *
 */
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productRepository;


	@Override
	public Product getProductByName(String nameRegistered) {
		return productRepository.findByName(nameRegistered);
	}

}
