package com.journaldev.model;

public class Product {

	

	private String productName;
	private double productPrice;
	private String productDescription;
	private int productId;
	
	public Product(){}
	
	public Product(String productName, double productPrice, String productDescription) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;

	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productPrice="
				+ productPrice + ", productDescription=" + productDescription
				+ ", productId=" + productId + "]";
	}
	
	
	
	
}
