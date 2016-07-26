package com.auskeny.hibernate.pojo;

public class Order {
	private  int orderIdPk;	
	private Customer customer;
	
	public Order(){		
	}
	
	public Order(int orderIdPk, Customer customer) {
		super();
		this.orderIdPk = orderIdPk;
		this.customer = customer;
	}
	
	public int getOrderIdPk() {
		return orderIdPk;
	}
	public void setOrderIdPk(int orderIdPk) {
		this.orderIdPk = orderIdPk;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
