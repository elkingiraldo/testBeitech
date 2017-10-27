package com.supermarket.app.dto;

import java.io.Serializable;

/**
 * Class for the order details
 * 
 * @author egiraldo
 *
 */
public class OrderDetailDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Defines the product name associated to the order
	 */
	private String productName;
	/**
	 * Defines the product quantity the user select
	 */
	private int quantity;
	/**
	 * product name and product quantity
	 */
	private String description;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
