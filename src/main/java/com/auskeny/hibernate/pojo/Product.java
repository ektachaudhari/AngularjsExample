package com.auskeny.hibernate.pojo;

public class Product {
	private int productIdPk;
	private String productName;
	private Double price;

	public int getProductIdPk() {
		return productIdPk;
	}

	public void setProductIdPk(int productIdPk) {
		this.productIdPk = productIdPk;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productIdPk;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productIdPk != other.productIdPk)
			return false;
		return true;
	}

}
