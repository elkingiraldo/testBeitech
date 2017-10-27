package com.supermarket.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the customer_type database table.
 * 
 */
@Entity
@Table(name="customer_type")
@NamedQuery(name="CustomerType.findAll", query="SELECT c FROM CustomerType c")
public class CustomerType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customer_type_id")
	private int customerTypeId;

	@Column(name="customer_type_name")
	private String customerTypeName;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="customerTypeBean")
	private List<Customer> customers;

	//bi-directional many-to-one association to ProductCategoryByCustomerType
	@OneToMany(mappedBy="customerTypeBean")
	private List<ProductCategoryByCustomerType> productCategoryByCustomerTypes;

	public CustomerType() {
	}

	public int getCustomerTypeId() {
		return this.customerTypeId;
	}

	public void setCustomerTypeId(int customerTypeId) {
		this.customerTypeId = customerTypeId;
	}

	public String getCustomerTypeName() {
		return this.customerTypeName;
	}

	public void setCustomerTypeName(String customerTypeName) {
		this.customerTypeName = customerTypeName;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setCustomerTypeBean(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setCustomerTypeBean(null);

		return customer;
	}

	public List<ProductCategoryByCustomerType> getProductCategoryByCustomerTypes() {
		return this.productCategoryByCustomerTypes;
	}

	public void setProductCategoryByCustomerTypes(List<ProductCategoryByCustomerType> productCategoryByCustomerTypes) {
		this.productCategoryByCustomerTypes = productCategoryByCustomerTypes;
	}

	public ProductCategoryByCustomerType addProductCategoryByCustomerType(ProductCategoryByCustomerType productCategoryByCustomerType) {
		getProductCategoryByCustomerTypes().add(productCategoryByCustomerType);
		productCategoryByCustomerType.setCustomerTypeBean(this);

		return productCategoryByCustomerType;
	}

	public ProductCategoryByCustomerType removeProductCategoryByCustomerType(ProductCategoryByCustomerType productCategoryByCustomerType) {
		getProductCategoryByCustomerTypes().remove(productCategoryByCustomerType);
		productCategoryByCustomerType.setCustomerTypeBean(null);

		return productCategoryByCustomerType;
	}

}