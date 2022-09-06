package com.kh.myPage.model.vo;

public class Cart {

	private int memberNo; //MEMBER_NO	NUMBER
	private int productNo;//PRODUCT_NO	NUMBER
	private int totalQuantity;//TOTAL_QUANTITY	NUMBER
	
	public Cart() {
		super();
	}

	public Cart(int memberNo, int productNo, int totalQuantity) {
		super();
		this.memberNo = memberNo;
		this.productNo = productNo;
		this.totalQuantity = totalQuantity;
	}

	@Override
	public String toString() {
		return "Cart [memberNo=" + memberNo + ", productNo=" + productNo + ", totalQuantity=" + totalQuantity + "]";
	}
	
	
	
}
