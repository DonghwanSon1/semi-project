package com.kh.product.model.vo;

import java.sql.Date;

public class Product {
	
	private int productNo;
	private int categoryNo; // String으로 받아도 됨
	private String productName;
	private int price;
	private int stock;
	private String productDesc;
	private String status;
	private int salesQuantity;
	private Date productEnroll;
	private String filePathName;
	
	
	
	public Product() {
		super();
	}
	
	// DAO - selectProduct를 위한 생성자
	public Product(int categoryNo, String productName, int price, int stock, String productDesc) {
		super();
		this.categoryNo = categoryNo;
		this.productName = productName;
		this.price = price;
		this.stock = stock;
		this.productDesc = productDesc;
	}
	
	public Product(int productNo, int categoryNo, String productName, int price, int stock, String productDesc,
			String status, int salesQuantity, Date productEnroll, String filePathName) {
		super();
		this.productNo = productNo;
		this.categoryNo = categoryNo;
		this.productName = productName;
		this.price = price;
		this.stock = stock;
		this.productDesc = productDesc;
		this.status = status;
		this.salesQuantity = salesQuantity;
		this.productEnroll = productEnroll;
		this.filePathName = filePathName;
	}

	public int getProductNo() {
		return productNo;
	}
	public Product(int productNo, String productName, int price, int stock, String productDesc, int salesQuantity) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.price = price;
		this.stock = stock;
		this.productDesc = productDesc;
		this.salesQuantity = salesQuantity;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategory(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSalesQuantity() {
		return salesQuantity;
	}
	public void setSalesQuantity(int salesQuantity) {
		this.salesQuantity = salesQuantity;
	}
	public Date getProductEnroll() {
		return productEnroll;
	}
	public void setProductEnroll(Date productEnroll) {
		this.productEnroll = productEnroll;
	}
	public String getFilePathName() {
		return filePathName;
	}
	public void setFilePathName(String filePathName) {
		this.filePathName = filePathName;
	}

	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", categoryNo=" + categoryNo + ", productName=" + productName
				+ ", price=" + price + ", stock=" + stock + ", productDesc=" + productDesc + ", status=" + status
				+ ", salesQuantity=" + salesQuantity + ", productEnroll=" + productEnroll + ", filePathName="
				+ filePathName + "]";
	}
	
}
