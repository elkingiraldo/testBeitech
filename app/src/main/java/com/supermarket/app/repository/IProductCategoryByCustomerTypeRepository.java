package com.supermarket.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.supermarket.app.entity.CustomerType;
import com.supermarket.app.entity.ProductCategoryByCustomerType;

/**
 * Repository to access Product Category By Customer Type DB table
 * 
 * @author egiraldo
 *
 */
public interface IProductCategoryByCustomerTypeRepository extends CrudRepository<ProductCategoryByCustomerType, Long>{
	List<ProductCategoryByCustomerType> findBycustomerTypeBean(CustomerType customerType);
}
