package com.supermarket.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.supermarket.app.entity.ProductCategory;

/**
 * Repository to access Product Category DB table
 * 
 * @author egiraldo
 *
 */
public interface IProductCategoryRepository extends CrudRepository<ProductCategory, Long>{

}
