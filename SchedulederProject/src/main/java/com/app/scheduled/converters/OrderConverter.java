package com.app.scheduled.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.app.scheduled.entities.OrderEntity;
import com.app.scheduled.models.OrderModel;


@Component("orderConverter")
public class OrderConverter implements Converter<OrderModel, OrderEntity> {

	@Override
	public OrderEntity convert(OrderModel productModel) {
		// TODO Auto-generated method stub
		OrderEntity prod=new OrderEntity();
		prod.setId(productModel.getId());
		prod.setProName(productModel.getProName());
		prod.setProPrice(productModel.getProPrice());
		prod.setProQuantity(productModel.getProQuantity());
		prod.setProSize(productModel.getProSize());
		prod.setProDescription(productModel.getProDescription());
		prod.setProDate(productModel.getProDate());
		prod.setProStatus(productModel.getProStatus());
		
		
		return prod;
	}

}
