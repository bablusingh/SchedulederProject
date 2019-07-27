package com.app.scheduled.services;

import com.app.scheduled.entities.OrderEntity;
import com.app.scheduled.models.OrderModel;
import com.app.scheduled.models.OrderResponseModel;
import com.app.scheduled.models.ResponseData;

public interface OrderService {

	ResponseData addProduct(OrderModel productModel);

	OrderModel getSingleProduct(long id);

	OrderResponseModel getAllProduct();

	OrderEntity getOrderByStatus();
	
	public void updateOrder(OrderEntity oderEntity);

}
