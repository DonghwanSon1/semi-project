package com.kh.myPage.model.vo;

public class Coupon {
	
	private int couponNo;
	private String couponName;
	private String couponCode;
	private int discount;
	private String status;
	private int memberNo;
	
	public Coupon() {
		super();
	}
	
	public Coupon(int couponNo, String couponName, String couponCode, int discount, int memberNo) {
		super();
		this.couponNo = couponNo;
		this.couponName = couponName;
		this.couponCode = couponCode;
		this.discount = discount;
		this.memberNo = memberNo;
		
	}

	public Coupon(int couponNo, String couponName, String couponCode, int discount, String status, int memberNo) {
		super();
		this.couponNo = couponNo;
		this.couponName = couponName;
		this.couponCode = couponCode;
		this.discount = discount;
		this.status = status;
		this.memberNo = memberNo;
	}

	public int getCouponNo() {
		return couponNo;
	}

	public void setCouponNo(int couponNo) {
		this.couponNo = couponNo;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "Coupon [couponNo=" + couponNo + ", couponName=" + couponName + ", couponCode=" + couponCode + ", discount="
				+ discount + ", status=" + status + ", memberNo=" + memberNo + "]";
	}
	
	
}
