package com.kh.center.model.vo;

import java.sql.Date;

public class CenterReply {

	private int replyNo; //REPLY_NO
	private String replyContent; //REPLY_CONTENT
	private int refBno; //REF_BNO
	private String replyWriter; //REPLY_WRITER
	private String createDate; //CREATE_DATE
	private String status; //STATUS
	
	
	public CenterReply() {}

	
	public CenterReply(int replyNo, String replyContent, String replyWriter, String createDate) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.replyWriter = replyWriter;
		this.createDate = createDate;
	}






	public CenterReply(int replyNo, String replyContent, int refBno, String replyWriter, String createDate, String status) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.refBno = refBno;
		this.replyWriter = replyWriter;
		this.createDate = createDate;
		this.status = status;
	}


	public int getReplyNo() {
		return replyNo;
	}


	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}


	public String getReplyContent() {
		return replyContent;
	}


	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}


	public int getRefBno() {
		return refBno;
	}


	public void setRefBno(int refBno) {
		this.refBno = refBno;
	}


	public String getReplyWriter() {
		return replyWriter;
	}


	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
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
		return "CenterReply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", refBno=" + refBno
				+ ", replyWriter=" + replyWriter + ", createDate=" + createDate + ", status=" + status + "]";
	}
	
	
	
	
}
