package com.kh.center.model.vo;

public class CenterInfo {

	private int infoNo; //INFO_NO
	private String infoTitle; //INFO_TITLE
	private String infoContent; // INFO_CONTENT
	
	
	public CenterInfo () {}


	public CenterInfo(int infoNo, String infoTitle, String infoContent) {
		super();
		this.infoNo = infoNo;
		this.infoTitle = infoTitle;
		this.infoContent = infoContent;
	}


	public int getInfoNo() {
		return infoNo;
	}


	public void setInfoNo(int infoNo) {
		this.infoNo = infoNo;
	}


	public String getInfoTitle() {
		return infoTitle;
	}


	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}


	public String getInfoContent() {
		return infoContent;
	}


	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}


	@Override
	public String toString() {
		return "CenterInfo [infoNo=" + infoNo + ", infoTitle=" + infoTitle + ", infoContent=" + infoContent + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
