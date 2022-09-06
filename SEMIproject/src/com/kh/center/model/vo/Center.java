package com.kh.center.model.vo;

import java.sql.Date;

public class Center {
	
	private int centerNo; //CENTER_NO
	private String centerTitle; //CENTER_TITLE
	private String centerContent; //CENTER_CONTENT
	private String centerWriter; //CENTER_WRITER
	private Date createDate; //CREATE_DATE
	private String status; //STATUS
	
	
	
	public Center () {}



	public Center(int centerNo, String centerTitle, String centerContent, String centerWriter, Date createDate,
			String status) {
		super();
		this.centerNo = centerNo;
		this.centerTitle = centerTitle;
		this.centerContent = centerContent;
		this.centerWriter = centerWriter;
		this.createDate = createDate;
		this.status = status;
	}



	public int getCenterNo() {
		return centerNo;
	}



	public void setCenterNo(int centerNo) {
		this.centerNo = centerNo;
	}



	public String getCenterTitle() {
		return centerTitle;
	}



	public void setCenterTitle(String centerTitle) {
		this.centerTitle = centerTitle;
	}



	public String getCenterContent() {
		return centerContent;
	}



	public void setCenterContent(String centerContent) {
		this.centerContent = centerContent;
	}



	public String getCenterWriter() {
		return centerWriter;
	}



	public void setCenterWriter(String centerWriter) {
		this.centerWriter = centerWriter;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Center [centerNo=" + centerNo + ", centerTitle=" + centerTitle + ", centerContent=" + centerContent
				+ ", centerWriter=" + centerWriter + ", createDate=" + createDate + ", status=" + status + "]";
	}
	
	
	
	
	

}
