package com.supermarket.app.controller;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.app.dto.OrderRequestDTO;
import com.supermarket.app.dto.OrderResponseDTO;
import com.supermarket.app.dto.ResultDTO;
import com.supermarket.app.service.IOrderService;

/**
 * Order controller for manage requests
 * 
 * @author egiraldo
 *
 */
@RestController
public class OrderController {

	@Autowired
	private IOrderService orderService;

	private static Logger _logger = Logger.getLogger(OrderController.class);

	/**
	 * POST request for create a new order for a specific user
	 * 
	 * @param orderRequest,
	 *            Dto requested for making the order
	 * @return {@link ResultDTO}
	 */
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Object createOrder(@RequestBody final OrderRequestDTO orderRequest) {

		try {

			String requestId = UUID.randomUUID().toString();

			_logger.info("[OrderController][createOrder][" + requestId + "] Started.");

			int orderId = orderService.createOrder(orderRequest, requestId);

			return new ResultDTO(true, "Order created succesfully. Order ID: " + orderId);

		} catch (Exception e) {
			_logger.error("POST=/ordersList method", e);
			return (new ResultDTO(false, e.getMessage()));
		}

	}

	/**
	 * GET request for obtaining orders list in a range time
	 * 
	 * @param registeredEmail,
	 *            User's registered email in DB
	 * @param initialDate,
	 *            Initial date of a range time requested
	 * @param endDate,
	 *            End date of a rage time requested
	 * @return {@link ResultDTO}
	 */
	@RequestMapping(value = "/ordersList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object getOrderList(@RequestParam("registeredEmail") String registeredEmail,
			@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {

		try {

			String requestId = UUID.randomUUID().toString();

			_logger.info("[OrderController][getOrderList][" + requestId + "] Started.");

			List<OrderResponseDTO> ordersList = orderService.getOrdersList(registeredEmail, startDate, endDate, requestId);
			
			_logger.info("[OrderController][getOrderList][" + requestId + "] Finish.");
			
			if(ordersList.size() == 0){
				return new ResultDTO(true, "This user don't have orders associates in this period.", ordersList, ordersList.size());
			} else {
				return new ResultDTO(true, "Successfully operation.", ordersList, ordersList.size());
			}

		} catch (Exception e) {
			_logger.error("GET=/ordersList method", e);
			return (new ResultDTO(false, e.getMessage()));
		}

	}

}
