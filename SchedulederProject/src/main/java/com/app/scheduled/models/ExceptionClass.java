package com.app.scheduled.models;

import java.io.IOException;


@SuppressWarnings("serial")
public class ExceptionClass extends IOException  {
	
	private String code;
	private String message;
	public ExceptionClass() {
		super();
	}
	public ExceptionClass(String code,String message)
	{
		super();
		this.code=code;
		this.message=message;
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ExceptionClass [code=" + code + ", message=" + message + "]";
	}
	
	
	
	

}
