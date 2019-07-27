package com.app.scheduled.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.app.scheduled.entities.OrderEntity;
import com.app.scheduled.models.OrderModel;


@Component("orderConverterShowProduct")
public class OrderConverterShowProduct implements Converter<OrderEntity, OrderModel> {

	

	@Override
	public OrderModel convert(OrderEntity product) {
		// TODO Auto-generated method stub
		OrderModel proModel=new OrderModel();
		proModel.setId(product.getId());
		proModel.setProName(product.getProName());
		proModel.setProPrice(product.getProPrice());
		proModel.setProQuantity(product.getProQuantity());
		proModel.setProSize(product.getProSize());
		proModel.setProDescription(product.getProDescription());
		proModel.setProDate(product.getProDate());
		proModel.setProStatus(product.getProStatus());
		
		
		return proModel;
	}

	

}
