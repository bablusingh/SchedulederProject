package com.app.scheduled.models;

import java.util.List;

import lombok.Data;

@Data
public class OrderResponseModel {

	//private long count;
	private List<OrderModel> data;

}
