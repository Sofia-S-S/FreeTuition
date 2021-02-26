package com.freetuition.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "request_approved", schema="freetuition")

public class RequestApproved {
	@Id
	@Column
	private int requestId;
	@Column
	private double amount;
	@Column
	private int managerId;
	@Column
	private Date date;

	public RequestApproved () {}

	public RequestApproved (int requestId, double amount, int managerId, Date date) {
		super();
		this.requestId = requestId;
		this.amount = amount;
		this.managerId = managerId;
		this.date = date;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
