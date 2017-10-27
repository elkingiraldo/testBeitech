package com.supermarket.app.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the product_category_by_customer_type database table.
 * 
 */
@Entity
@Table(name="product_category_by_customer_type")
@NamedQuery(name="ProductCategoryByCustomerType.findAll", query="SELECT p FROM ProductCategoryByCustomerType p")
public class ProductCategoryByCustomerType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_category_by_customer_type_id")
	private int productCategoryByCustomerTypeId;

	//bi-directional many-to-one association to CustomerType
	@ManyToOne
	@JoinColumn(name="customer_type")
	private CustomerType customerTypeBean;

	//bi-directional many-to-one association to ProductCategory
	@ManyToOne
	@JoinColumn(name="product_category")
	private ProductCategory productCategoryBean;

	public ProductCategoryByCustomerType() {
	}

	public int getProductCategoryByCustomerTypeId() {
		return this.productCategoryByCustomerTypeId;
	}

	public void setProductCategoryByCustomerTypeId(int productCategoryByCustomerTypeId) {
		this.productCategoryByCustomerTypeId = productCategoryByCustomerTypeId;
	}

	public CustomerType getCustomerTypeBean() {
		return this.customerTypeBean;
	}

	public void setCustomerTypeBean(CustomerType customerTypeBean) {
		this.customerTypeBean = customerTypeBean;
	}

	public ProductCategory getProductCategoryBean() {
		return this.productCategoryBean;
	}

	public void setProductCategoryBean(ProductCategory productCategoryBean) {
		this.productCategoryBean = productCategoryBean;
	}

}