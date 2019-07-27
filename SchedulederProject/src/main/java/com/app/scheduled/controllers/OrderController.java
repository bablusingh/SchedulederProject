package com.app.scheduled.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.scheduled.models.OrderModel;
import com.app.scheduled.models.OrderResponseModel;
import com.app.scheduled.models.ResponseData;
import com.app.scheduled.services.OrderService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/orderProduct")
public class OrderController {

	@Autowired
	private OrderService productServiceImpl;
	
	@PostMapping(value = "/addProduct")
	public ResponseData addProduct(@RequestBody OrderModel productModel) {
		return productServiceImpl.addProduct(productModel);

	}

	@GetMapping(value = "/getSingleProdutc")
	public OrderModel getSingleProduct(@RequestParam("id") long id) {

		return productServiceImpl.getSingleProduct(id);

	}

	@GetMapping(value = "/getAllProduct")
	public OrderResponseModel getAllProduct() {
		return productServiceImpl.getAllProduct();
	}
}
