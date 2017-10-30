package com.supermarket.app.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.supermarket.app.controller.OrderController;
import com.supermarket.app.dto.OrderDetailDTO;
import com.supermarket.app.entity.Order;
import com.supermarket.app.entity.OrderDetail;
import com.supermarket.app.repository.IOrderDetailRepository;

/**
 * Implementation of order detail interface service
 * 
 * @author egiraldo
 *
 */
public class OrderDetailServiceImpl implements IOrderDetailService {

	@Autowired
	private IOrderDetailRepository orderDetailRepository;

	private static Logger _logger = Logger.getLogger(OrderDetailServiceImpl.class);

	@Override
	public void saveOrderDetails(List<OrderDetail> orderDetailList, Order order) {

		for (OrderDetail orderDetail : orderDetailList) {
			orderDetail.setOrder(order);
		}

		orderDetailRepository.save(orderDetailList);

	}

	@Override
	public List<OrderDetailDTO> getOrderDetailsByOrder(Order order, String requestId) {

		_logger.info("[OrderDetailServiceImpl][getOrderDetailsByOrder][" + requestId + "] Started.");

		// obtain entities of order details
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		orderDetailList = orderDetailRepository.findByorder(order);

		// initialize order detail dto and order detail dto list
		List<OrderDetailDTO> orderDetailDtoList = new ArrayList<OrderDetailDTO>();

		// convert entity to dto and add it to the response list
		for (OrderDetail orderDetail : orderDetailList) {
			OrderDetailDTO orderDetailDto = new OrderDetailDTO();
			orderDetailDto.setDescription(orderDetail.getProductDescription());
			orderDetailDto.setQuantity(orderDetail.getQuantity());

			orderDetailDtoList.add(orderDetailDto);
		}

		_logger.info("[OrderDetailServiceImpl][getOrderDetailsByOrder][" + requestId
				+ "] Finished and return a order detail dto list of size: " + +orderDetailDtoList.size());

		return orderDetailDtoList;
	}

}
