package com.cognixia.jump.model;

import java.io.Serializable;

public class TransferForm implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private Integer fromId;
	private Double fromCash;
	private String toUsername;
	
	public TransferForm()
	{
		this(-1, -0.0, "N/A");
	}
	
	
	public TransferForm(Integer fromId, Double fromCash, String toUsername)
	{
		this.fromId = fromId;
		this.fromCash = fromCash;
		this.toUsername = toUsername;
	}


	public Integer getFromId() {
		return fromId;
	}


	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}


	public Double getFromCash() {
		return fromCash;
	}


	public void setFromCash(Double fromCash) {
		this.fromCash = fromCash;
	}


	public String getToUsername() {
		return toUsername;
	}


	public void setToUsername(String toUsername) {
		this.toUsername = toUsername;
	}

	@Override
	public String toString() {
		return "TransfrerForm [fromId=" + fromId + ", fromCash=" + fromCash + ", toUsername=" + toUsername + "]";
	}
	
}
