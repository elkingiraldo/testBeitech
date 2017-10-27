package com.supermarket.app.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Class for orders list responses
 * 
 * @author egiraldo
 *
 */
public class OrderResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Defines the customer's order ID
	 */
	private int orderId;
	/**
	 * Defines the customer's date was created
	 */
	private Date createdOn;
	/**
	 * Defines the customer's total order price
	 */
	private double orderPrice;
	/**
	 * Defines the customer's delivery address
	 */
	private String deliveryAddress;
	/**
	 * List of Order Details
	 */
	private List<OrderDetailDTO> listOrderDetail;

	public OrderResponseDTO() {
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
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
