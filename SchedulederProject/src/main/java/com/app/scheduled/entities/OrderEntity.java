package com.app.scheduled.entities;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String proName;
	private String proPrice;
	private String proDescription;
	private String proQuantity;
	private String proSize;
	private String proStatus;
	private Date proDate;
	
	

}
