package com.cognixia.jump.model;

import java.io.Serializable;

public class RecentUpdate implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	private Double cash;
	private String type;
	public RecentUpdate(Integer userId, Double cash, String type) {
		super();
		this.userId = userId;
		this.cash = cash;
		this.type = type;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Double getCash() {
		return cash;
	}
	public void setCash(Double cash) {
		this.cash = cash;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "RecentUpdate [userId=" + userId + ", cash=" + cash + ", type=" + type + "]";
	}
	
	

}
