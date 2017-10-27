package com.supermarket.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.supermarket.app.entity.CustomerType;
import com.supermarket.app.entity.ProductCategoryByCustomerType;
import com.supermarket.app.repository.IProductCategoryByCustomerTypeRepository;

/**
 * Implementation of porduct category by customer type interface service
 * 
 * @author egiraldo
 *
 */
public class ProductCategoryByCustomerTypeServiceImpl implements IProductCategoryByCustomerTypeService{
	
	@Autowired
	private IProductCategoryByCustomerTypeRepository productCategoryByCustomerTypeRepository;

	@Override
	public List<ProductCategoryByCustomerType> getProductCategoryByCustomerType(CustomerType customerType) {
		return productCategoryByCustomerTypeRepository.findBycustomerTypeBean(customerType);
	}
	



}
