package com.supermarket.app.service;

import java.util.List;

import com.supermarket.app.entity.CustomerType;
import com.supermarket.app.entity.ProductCategoryByCustomerType;

/**
 * Interface of Product Category By Customer Type Service
 * 
 * @author egiraldo
 *
 */
public interface IProductCategoryByCustomerTypeService {

	List<ProductCategoryByCustomerType> getProductCategoryByCustomerType(CustomerType customerType);

}
