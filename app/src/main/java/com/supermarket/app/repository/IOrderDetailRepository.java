package com.supermarket.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.supermarket.app.entity.Order;
import com.supermarket.app.entity.OrderDetail;

/**
 * Repository to access Order Detail DB table
 * 
 * @author egiraldo
 *
 */
public interface IOrderDetailRepository extends CrudRepository<OrderDetail, Long> {

	/**
	 * It will search the order detail related to an specific order
	 * 
	 * @param order,
	 *            {@link Order} 
	 * @return, List<{@link OrderDetail}>
	 */
	List<OrderDetail> findByorder(Order order);

}
