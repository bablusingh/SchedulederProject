package com.app.scheduled.controllers;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.aiolus.RestTemplateErrorHandler;
import com.app.scheduled.entities.OrderEntity;
import com.app.scheduled.services.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
public class DataTravellerController {
	
	@Autowired
	private RestTemplate restClient;
	
	@Autowired
	private OrderService productServiceImpl;
	
	@Scheduled(fixedDelay = 100000)
	public Object getProductData() {
		
		 String url="http://localhost:8083/orderProduct/getAllProduct"; 
		 HttpHeaders  httpHeader=new HttpHeaders();
		  httpHeader.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 HttpEntity<Object> entity=new HttpEntity<>(httpHeader);
		 restClient.setErrorHandler(new RestTemplateErrorHandler());
		  ResponseEntity<Object> response= restClient.exchange(url, HttpMethod.GET,
		 entity, Object.class);
	 
		  return response.getBody();
		 
		
		
	}
	
	@Scheduled(fixedDelay = 10000)
	public Object postProductData() throws JsonProcessingException {
		 
		OrderEntity obj=productServiceImpl.getOrderByStatus(); 
		   if(obj==null)
		   {
			   System.out.println("data not availabel");
			   return null;
		   }
		 ObjectMapper mapper=new  ObjectMapper(); 
		 String data=mapper.writeValueAsString(obj);
		  String url="http://localhost:8080/products/addproducts"; 
		  HttpHeaders  httpHeader=new HttpHeaders();
		  httpHeader.set("Content-Type", "application/json");
		  HttpEntity<Object> entity=new HttpEntity<>(data,httpHeader);
		  restClient.setErrorHandler(new RestTemplateErrorHandler());
		  ResponseEntity<Object> response= restClient.exchange(url, HttpMethod.POST,
		 entity, Object.class);
		 
		if(response.getStatusCode().value()==200)
		{
			obj.setProStatus("True");
			obj.setProDate(new Date());
			productServiceImpl.updateOrder(obj);
		}
		 
	return null;
		
	}
	
	

}
