package com.cognixia.jump.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name ="recent")
@Entity
public class Recent implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="user_id")
	@GeneratedValue()
	private Integer recentId;
	
	@Column(name="count")
	private Integer count;
	
	@Column(name="r1")
	private String r1;
	
	@Column(name="r2")
	private String r2;
	
	@Column(name="r3")
	private String r3;
	
	@Column(name="r4")
	private String r4;
	
	@Column(name="r5")
	private String r5;
	
	
	public Recent()
	{
		this(-1, -1, "N/A", "N/A", "N/A", "N/A", "N/A");
	}


	public Recent(Integer recentId, Integer count, String r1, String r2, String r3, String r4, String r5) {
		super();
		this.recentId = recentId;
		this.count = count;
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.r4 = r4;
		this.r5 = r5;
	}


	public Integer getRecentId() {
		return recentId;
	}


	public void setRecentId(Integer recentId) {
		this.recentId = recentId;
	}


	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}


	public String getR1() {
		return r1;
	}


	public void setR1(String r1) {
		this.r1 = r1;
	}


	public String getR2() {
		return r2;
	}


	public void setR2(String r2) {
		this.r2 = r2;
	}


	public String getR3() {
		return r3;
	}


	public void setR3(String r3) {
		this.r3 = r3;
	}


	public String getR4() {
		return r4;
	}


	public void setR4(String r4) {
		this.r4 = r4;
	}


	public String getR5() {
		return r5;
	}


	public void setR5(String r5) {
		this.r5 = r5;
	}


	@Override
	public String toString() {
		return "Recent [recentId=" + recentId + ", count=" + count + ", r1=" + r1 + ", r2=" + r2 + ", r3=" + r3
				+ ", r4=" + r4 + ", r5=" + r5 + "]";
	}
	
	
}
