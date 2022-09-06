package com.kh.member.model.vo;

public class Address {

	private int addressNo;
	private String main;
	private String receiver;//RECEIVER	VARCHAR2(20 BYTE)
	private String location;//LOCATION	VARCHAR2(500 BYTE)
	private String phone;//PHONE	VARCHAR2(14 BYTE)
	private int memberNo;//MEMBER_NO	NUMBER
	
	public Address() {
		super();
	}
	
	public Address(int addressNo, String receiver, String location, String phone, int memberNo) {
		super();
		this.addressNo = addressNo;
		this.receiver = receiver;
		this.location = location;
		this.phone = phone;
		this.memberNo = memberNo;
	}

	public Address(int addressNo,String main, String receiver, String location, String phone, int memberNo) {
		super();
		this.addressNo = addressNo;
		this.main = main;
		this.receiver = receiver;
		this.location = location;
		this.phone = phone;
		this.memberNo = memberNo;
	}
	
	// 시퀀스 제외한 생성자
	public Address(String main, String receiver, String location, String phone, int memberNo) {
		super();
		this.main = main;
		this.receiver = receiver;
		this.location = location;
		this.phone = phone;
		this.memberNo = memberNo;
	}

	public int getAddressNo() {
		return addressNo;
	}
	
	public void setAddressNo(int addressNo) {
		this.addressNo = addressNo;
	}
	
	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "Address [addressNo=" + addressNo + ", main=" + main + ", receiver=" + receiver + ", location=" + location + ", phone=" + phone
				+ ", memberNo=" + memberNo + "]";
	}
	
	

}
