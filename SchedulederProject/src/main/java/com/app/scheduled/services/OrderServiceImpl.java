package com.app.scheduled.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.app.scheduled.converters.OrderConverter;
import com.app.scheduled.entities.OrderEntity;
import com.app.scheduled.models.OrderModel;
import com.app.scheduled.models.OrderResponseModel;
import com.app.scheduled.models.ResponseData;
import com.app.scheduled.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository productRepositoryImpl;

	@Autowired
	private Converter<OrderModel, OrderEntity> orderConverter;

	@Autowired
	private Converter<OrderEntity, OrderModel> orderConverterShowAll;

	@Override
	public ResponseData addProduct(OrderModel productModel) {
		// TODO Auto-generated method stub
		OrderEntity product = (OrderEntity) orderConverter.convert(productModel);
		long i = productRepositoryImpl.addProduct(product).getId();
		if (i > 0) {
			return new ResponseData(product.getId(), true, "Save Data Success full");
		} else {
			return new ResponseData(0, false, "Failed");
		}

	}

	@Override
	public OrderModel getSingleProduct(long id) {
		// TODO Auto-generated method stub
		// productRepositoryImpl.getSingleProduct(id);
		return orderConverterShowAll.convert(productRepositoryImpl.getSingleProduct(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public OrderResponseModel getAllProduct() {
		OrderResponseModel productResponseModel = new OrderResponseModel();
		Map<String, Object> map = productRepositoryImpl.getAllProduct();
		//productResponseModel.setCount((long) map.get("count"));
		List<OrderEntity> product = (List<OrderEntity>) map.get("data");
		List<OrderModel> productList = product.stream()
				.map(p -> new OrderModel(p.getId(), p.getProStatus(), p.getProDescription(), p.getProName(),
						p.getProPrice(), p.getProQuantity(), p.getProSize(), p.getProDate()))
				.collect(Collectors.toList());

		productResponseModel.setData(productList);
		return productResponseModel;

	}
	
	@Override
	public OrderEntity getOrderByStatus()
	{
		return productRepositoryImpl.getOrderByStatus();
	}

	@Override
	public void updateOrder(OrderEntity oderEntity) {
		
		productRepositoryImpl.updateOrder(oderEntity);
		
	}

}
