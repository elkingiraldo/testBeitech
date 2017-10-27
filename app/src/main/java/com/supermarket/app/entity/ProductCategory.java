package com.supermarket.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product_category database table.
 * 
 */
@Entity
@Table(name="product_category")
@NamedQuery(name="ProductCategory.findAll", query="SELECT p FROM ProductCategory p")
public class ProductCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_category_id")
	private int productCategoryId;

	@Column(name="product_category_name")
	private String productCategoryName;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="productCategoryBean")
	private List<Product> products;

	//bi-directional many-to-one association to ProductCategoryByCustomerType
	@OneToMany(mappedBy="productCategoryBean")
	private List<ProductCategoryByCustomerType> productCategoryByCustomerTypes;

	public ProductCategory() {
	}

	public int getProductCategoryId() {
		return this.productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getProductCategoryName() {
		return this.productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProductCategoryBean(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProductCategoryBean(null);

		return product;
	}

	public List<ProductCategoryByCustomerType> getProductCategoryByCustomerTypes() {
		return this.productCategoryByCustomerTypes;
	}

	public void setProductCategoryByCustomerTypes(List<ProductCategoryByCustomerType> productCategoryByCustomerTypes) {
		this.productCategoryByCustomerTypes = productCategoryByCustomerTypes;
	}

	public ProductCategoryByCustomerType addProductCategoryByCustomerType(ProductCategoryByCustomerType productCategoryByCustomerType) {
		getProductCategoryByCustomerTypes().add(productCategoryByCustomerType);
		productCategoryByCustomerType.setProductCategoryBean(this);

		return productCategoryByCustomerType;
	}

	public ProductCategoryByCustomerType removeProductCategoryByCustomerType(ProductCategoryByCustomerType productCategoryByCustomerType) {
		getProductCategoryByCustomerTypes().remove(productCategoryByCustomerType);
		productCategoryByCustomerType.setProductCategoryBean(null);

		return productCategoryByCustomerType;
	}

}