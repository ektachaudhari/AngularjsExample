package com.auskeny.hibernate.pojo;

public class 	OrderDetail {
	private int orderDetailIdPk;
	private Customer customer;
	private Product product;
	private int quantity;
	private Double totalPrice;
	
	public OrderDetail(){}
	
	public OrderDetail(int orderDetailIdPk, Customer Customer, int quantity,Product product) {
		super();
		this.orderDetailIdPk = orderDetailIdPk;
		this.customer = Customer;
		this.quantity = quantity;
		this.product=product;
	}
	
	public OrderDetail(Customer Customer, int quantity,Product product) {
		super();		
		this.customer = Customer;
		this.quantity = quantity;
		this.product=product;
	}
	
	public int getOrderDetailIdPk() {
		return orderDetailIdPk;
	}
	public void setOrderDetailIdPk(int orderDetailIdPk) {
		this.orderDetailIdPk = orderDetailIdPk;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer Customer) {
		this.customer = Customer;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
