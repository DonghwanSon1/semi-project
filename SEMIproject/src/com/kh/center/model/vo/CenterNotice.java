package com.kh.center.model.vo;

public class CenterNotice {
	
	
	private int noticeNo; //NOTICE_NO
	private String noticeTitle; //NOTICE_TITLE
	private String noticeContent; //NOTICE_CONTENT
	
	
	public CenterNotice() {}

	
	
	
	public CenterNotice(int noticeNo, String noticeTitle) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
	}




	public CenterNotice(int noticeNo, String noticeTitle, String noticeContent) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
	}


	public int getNoticeNo() {
		return noticeNo;
	}


	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
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


	@Override
	public String toString() {
		return "CenterNotice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent="
				+ noticeContent + "]";
	}

	
	
	
	
	
}
