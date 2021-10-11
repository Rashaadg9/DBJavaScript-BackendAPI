package com.cognixia.jump.model;

import java.io.Serializable;

public class TransferRecentUpdate implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private String username;
	private Double cash;
	private String type;
	
	
	public TransferRecentUpdate()
	{
		this("N/A", -0.0, "N/A");
	}
	
	public TransferRecentUpdate(String username, Double cash, String type) {
		super();
		this.username = username;
		this.cash = cash;
		this.type = type;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return "TransferRecentUpdate [username=" + username + ", cash=" + cash + ", type=" + type + "]";
	}

}
