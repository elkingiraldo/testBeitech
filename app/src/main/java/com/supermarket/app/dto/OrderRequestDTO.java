package com.supermarket.app.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Class for orders list requests
 * 
 * @author egiraldo
 *
 */
public class OrderRequestDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Defines the email registered for users in DB
	 */
	private String registeredEmail;
	/**
	 * Defines the order delivery address
	 */
	private String deliveryAddress;
	/**
	 * List of products users want to buy
	 */
	private List<OrderDetailDTO> listOrderDetail;

	public String getRegisteredEmail() {
		return registeredEmail;
	}

	public void setRegisteredEmail(String registeredEmail) {
		this.registeredEmail = registeredEmail;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public List<OrderDetailDTO> getListOrderDetail() {
		return listOrderDetail;
	}

	public void setListOrderDetail(List<OrderDetailDTO> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}

}
