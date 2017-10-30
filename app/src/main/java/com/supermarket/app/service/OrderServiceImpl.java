package com.supermarket.app.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import com.supermarket.app.dto.OrderDetailDTO;
import com.supermarket.app.dto.OrderRequestDTO;
import com.supermarket.app.dto.OrderResponseDTO;
import com.supermarket.app.entity.Customer;
import com.supermarket.app.entity.CustomerType;
import com.supermarket.app.entity.Order;
import com.supermarket.app.entity.OrderDetail;
import com.supermarket.app.entity.Product;
import com.supermarket.app.entity.ProductCategoryByCustomerType;
import com.supermarket.app.repository.IOrderRepository;

/**
 * Implementation of order interface service
 * 
 * @author egiraldo
 *
 */
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepository orderRepository;

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private IProductService productService;

	@Autowired
	private IOrderDetailService orderDetailService;

	@Autowired
	private IProductCategoryByCustomerTypeService productCategoryByCustomerTypeService;

	private static Logger _logger = Logger.getLogger(OrderServiceImpl.class);

	@Override
	public int createOrder(OrderRequestDTO orderRequest, String requestId) throws ServiceException {

		_logger.info("[OrderServiceImpl][createOrder][" + requestId + "] Started.");

		// Search Customer Entity
		String emailRegistered = orderRequest.getRegisteredEmail();
		Customer customer = customerService.getCustomerEntityByEmail(emailRegistered, requestId);

		// Verify the user exists
		if (customer == null) {
			throw new ServiceException("We could not find your email in our database. Please check it and try again");
		}

		// Validate max number of products in order
		int totalOrder = 0;
		for (OrderDetailDTO orderDetail : orderRequest.getListOrderDetail()) {
			totalOrder += orderDetail.getQuantity();
		}
		if (totalOrder > 5) {
			throw new ServiceException("The order can't contain more than 5 products in total");
		}

		// Find relation between customer type and product category
		CustomerType customerType = customer.getCustomerTypeBean();
		List<ProductCategoryByCustomerType> listProductCategoryByCustomerType = productCategoryByCustomerTypeService
				.getProductCategoryByCustomerType(customerType);

		// Products available for users
		List<Product> availableProductsByCustomer = new ArrayList<Product>();
		for (ProductCategoryByCustomerType productCategoryByCustomerType : listProductCategoryByCustomerType) {
			for (Product product : productCategoryByCustomerType.getProductCategoryBean().getProducts()) {
				availableProductsByCustomer.add(product);
			}
		}

		// Products name available for users
		List<String> availableProductsName = new ArrayList<String>();
		for (Product product : availableProductsByCustomer) {
			availableProductsName.add(product.getName());
		}

		// Product list requested for users
		List<OrderDetailDTO> orderDetailDTOList = orderRequest.getListOrderDetail();

		// Order entity
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();

		// Total order price
		double totalOrderPrice = 0;

		// Checking if the user can order a certain product or not and add order details
		for (OrderDetailDTO orderDetailDTO : orderDetailDTOList) {
			String productNameInOrder = orderDetailDTO.getProductName().toUpperCase();
			int productQuantityInOrder = orderDetailDTO.getQuantity();
			if (!availableProductsName.contains(productNameInOrder)) {
				throw new ServiceException("Your customer type can't order the product " + productNameInOrder
						+ "Please check the categories that are allowed for your customer type "
						+ customer.getCustomerTypeBean().getCustomerTypeName().toUpperCase());
			}

			Product product = productService.getProductByName(productNameInOrder);
			double orderDetailPrice = productQuantityInOrder * product.getProductPrice();
			totalOrderPrice += orderDetailPrice;

			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrderDetailPrice(orderDetailPrice);
			orderDetail.setProduct(product);
			orderDetail.setProductDescription(productQuantityInOrder + " X " + productNameInOrder);
			orderDetail.setQuantity(productQuantityInOrder);

			orderDetailList.add(orderDetail);

		}

		// Create order and save it
		Order order = new Order();
		order.setCreatedOn(new Date());
		order.setCustomer(customer);
		order.setDeliveryAddress(orderRequest.getDeliveryAddress());
		order.setOrderPrice(totalOrderPrice);
		// order.setOrderDetails(orderDetailList);
		order = orderRepository.save(order);

		// Save order details
		orderDetailService.saveOrderDetails(orderDetailList, order);

		// return order user order ID
		return order.getOrderId();
	}

	@Override
	public List<OrderResponseDTO> getOrdersList(String registeredEmail, String initialDate, String endDate,
			String requestId) throws Exception {

		_logger.info("[OrderServiceImpl][getOrderList][" + requestId + "] Started.");

		// Search Customer Entity
		String emailRegistered = registeredEmail;
		Customer customer = customerService.getCustomerEntityByEmail(emailRegistered, requestId);

		// Verify the user exists
		if (customer == null) {
			throw new ServiceException("We could not find your email in our database. Please check it and try again");
		}

		// Change from string to date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
		Date dateInitial = sdf.parse(initialDate);
		Date dateFinal = sdf.parse(endDate);

		// find orders in DB related with specific user request
		List<Order> ordersList = orderRepository.findBycreatedOnBetween(dateInitial, dateFinal);

		// initialize the response dto list
		List<OrderResponseDTO> orderResponseDtoList = new ArrayList<OrderResponseDTO>();

		// initialize the response list dto of order details
		List<OrderDetailDTO> orderDetailDtoList = new ArrayList<>();

		for (Order order : ordersList) {
			// only takes orders related with the current user
			if (order.getCustomer().getCustomerId() == customer.getCustomerId()) {

				// initialize the response dto
				OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

				// set everything we need
				orderResponseDTO.setCreatedOn(order.getCreatedOn());
				orderResponseDTO.setDeliveryAddress(order.getDeliveryAddress());
				orderResponseDTO.setOrderId(order.getOrderId());
				orderResponseDTO.setOrderPrice(order.getOrderPrice());

				// obtain the order details
				orderDetailDtoList = orderDetailService.getOrderDetailsByOrder(order, requestId);

				orderResponseDTO.setListOrderDetail(orderDetailDtoList);

				// add dto to dtos list
				orderResponseDtoList.add(orderResponseDTO);

			}

		}

		_logger.info("[OrderServiceImpl][getOrderList][" + requestId
				+ "] Finished and return a order response dto list of size: " + orderResponseDtoList.size());
		return orderResponseDtoList;
	}

}
