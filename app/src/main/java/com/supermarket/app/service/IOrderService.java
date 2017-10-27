package com.supermarket.app.service;

import java.util.List;

import com.supermarket.app.dto.OrderRequestDTO;
import com.supermarket.app.dto.OrderResponseDTO;

/**
 * Interface of Order Service
 * 
 * @author egiraldo
 *
 */
public interface IOrderService {

	/**
	 * Create a new order for a specific user
	 * 
	 * @param orderRequest,
	 *            Dto with necessary information for creating an order
	 * @param requestId,
	 *            Request related to user petition
	 * 
	 * @return integer, order ID for a request
	 */
	public int createOrder(OrderRequestDTO orderRequest, String requestId);

	/**
	 * Get order detail for an user in a specific time range
	 * 
	 * @param registeredEmail,
	 *            Email registered in DB
	 * @param initialDate,
	 *            Initial date of a range time requested
	 * @param endDate,
	 *            End date of a rage time requested
	 * @return List<OrderResponseDTO>, orders list in the selected range list
	 */
	public List<OrderResponseDTO> getOrdersList(String registeredEmail, String initialDate, String endDate) throws Exception;

}
