package com.supermarket.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.supermarket.app.service.CustomerServiceImpl;
import com.supermarket.app.service.ICustomerService;
import com.supermarket.app.service.IOrderDetailService;
import com.supermarket.app.service.IOrderService;
import com.supermarket.app.service.IProductCategoryByCustomerTypeService;
import com.supermarket.app.service.IProductService;
import com.supermarket.app.service.OrderDetailServiceImpl;
import com.supermarket.app.service.OrderServiceImpl;
import com.supermarket.app.service.ProductCategoryByCustomerTypeServiceImpl;
import com.supermarket.app.service.ProductServiceImpl;

@Configuration
@EnableJpaRepositories
public class ConfigurationApp {

	@Bean
	public IOrderService orderService() {
		return new OrderServiceImpl();
	}

	@Bean
	public ICustomerService customerService() {
		return new CustomerServiceImpl();
	}

	@Bean
	public IProductService productService() {
		return new ProductServiceImpl();
	}
	
	@Bean
	public IOrderDetailService orderDetailService() {
		return new OrderDetailServiceImpl();
	}

	@Bean
	public IProductCategoryByCustomerTypeService productCategoryByCustomerTypeService() {
		return new ProductCategoryByCustomerTypeServiceImpl();
	}

}
