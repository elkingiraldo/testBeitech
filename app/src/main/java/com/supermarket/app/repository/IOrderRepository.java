package com.supermarket.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.supermarket.app.entity.Order;

/**
 * Repository to access Order DB table
 * 
 * @author egiraldo
 *
 */
public interface IOrderRepository extends CrudRepository<Order, Long> {

	/**
	 * It will search orders in a rage of dates for an specific user
	 * 
	 * @param startDate,
	 *            start date to search
	 * @param endDate,
	 *            end date to search
	 * @return List<{@link Order}>
	 */
	List<Order> findBycreatedOnBetween(Date startDate, Date endDate);

}
