package com.kh.notice.model.vo;

import java.sql.Date;

public class Notice {

	
	private int noticeNo; //NOTICE_NO
	private String noticeWriter; //NOTICE_WRITER
	private String noticeTitle; //NOTICE_TITLE
	private String noticeContent; //NOTICE_CONTENT
	private int count; //COUNT
	private Date createDate; //CREATE_DATE
	private String status; //STATUS
	
	
	
	public Notice() {}


	public Notice(int noticeNo, String noticeWriter, String noticeTitle, String noticeContent, int count, Date createDate,
			String status) {
		super();
		this.noticeNo = noticeNo;
		this.noticeWriter = noticeWriter;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.count = count;
		this.createDate = createDate;
		this.status = status;
	}



	public int getNoticeNo() {
		return noticeNo;
	}



	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}



	public String getNoticeWriter() {
		return noticeWriter;
	}



	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}



	public String getNoticeTitle() {
		return noticeTitle;
	}



	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}



	public String getNoticeContent() {
		return noticeContent;
	}



	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
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
		return "Notice [noticeNo=" + noticeNo + ", noticeWriter=" + noticeWriter + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", count=" + count + ", createDate=" + createDate + ", status="
				+ status + "]";
	}
	
	
	
}
