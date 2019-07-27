package com.app.scheduled.models;

import java.util.Date;

import lombok.Data;

@Data
public class OrderModel {

	public OrderModel() {
	}

	public OrderModel(long id, String proName, String proPrice, String proDescription, String proQuantity,
			String proSize, String proStatus, Date proDate) {

		this.id = id;
		this.proName = proName;
		this.proPrice = proPrice;
		this.proDescription = proDescription;
		this.proQuantity = proQuantity;
		this.proSize = proSize;
		this.proDate = proDate;
		this.proStatus = proStatus;

	}

	private long id;
	private String proName;
	private String proPrice;
	private String proDescription;
	private String proQuantity;
	private String proSize;
	private String proStatus;
	private Date proDate;

	@Override
	public String toString() {
		return "OrderModel [id=" + id + ", proName=" + proName + ", proPrice=" + proPrice + ", proDescription="
				+ proDescription + ", proQuantity=" + proQuantity + ", proSize=" + proSize + ", proStatus=" + proStatus
				+ ", proDate=" + proDate + "]";
	}

}
