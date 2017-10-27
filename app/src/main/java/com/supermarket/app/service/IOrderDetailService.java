package com.supermarket.app.service;

import java.util.List;

import com.supermarket.app.dto.OrderDetailDTO;
import com.supermarket.app.entity.Order;
import com.supermarket.app.entity.OrderDetail;

/**
 * Interface of Order Detail Service
 * 
 * @author egiraldo
 *
 */
public interface IOrderDetailService {

	/**
	 * It will save the order details
	 * 
	 * @param orderDetailList,
	 *            list of {@link OrderDetail}
	 * @param Order,
	 *            order requested for users
	 */
	void saveOrderDetails(List<OrderDetail> orderDetailList, Order order);

	/**
	 * It will search order detail entity and transform it in dto
	 * 
	 * @param order,
	 *            {@link Order}
	 * @return, List<{@link Order}>
	 */
	List<OrderDetailDTO> getOrderDetailsByOrder(Order order);

}
