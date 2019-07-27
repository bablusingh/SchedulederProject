package com.app.scheduled.repositories;

import java.util.Map;

import com.app.scheduled.entities.OrderEntity;

public interface OrderRepository {

	OrderEntity addProduct(OrderEntity product);

	OrderEntity getSingleProduct(long id);

	Map<String, Object> getAllProduct();
	
	OrderEntity updateOrder(OrderEntity orderEntity);

	OrderEntity getOrderByStatus();
	
	
	

}
