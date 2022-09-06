package com.kh.product.model.vo;

public class ProductCategory {
	
	private int categoryNo;
	private String categoryName;
	
	public ProductCategory() {
		super();
	}

	public ProductCategory(int categoryNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "ProductCategory [categoryNo=" + categoryNo + ", categoryName=" + categoryName + "]";
	}

}
