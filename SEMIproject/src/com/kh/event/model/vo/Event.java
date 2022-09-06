package com.kh.event.model.vo;

import java.sql.Date;

public class Event {

	private int eventNo; //EVENT_NO
	private String eventWriter; //EVENT_WRITER
	private String eventTitle; //EVENT_TITLE
	private String eventContent; //EVENT_CONTENT
	private Date createDate; //CREATE_DATE
	private int count; // COUNT
	private String status; //STATUS
	
	private String eventtitleImg; //
	
	public Event() {
		super();
		
	}
	public Event(int eventNo, String eventWriter, String eventTitle, String eventContent, Date createDate, int count,
			String status) {
		super();
		this.eventNo = eventNo;
		this.eventWriter = eventWriter;
		this.eventTitle = eventTitle;
		this.eventContent = eventContent;
		this.createDate = createDate;
		this.count = count;
		this.status = status;
	}
	
	
	
	public Event(int eventNo, String eventWriter, String eventTitle, String eventContent) {
		super();
		this.eventNo = eventNo;
		this.eventWriter = eventWriter;
		this.eventTitle = eventTitle;
		this.eventContent = eventContent;
	}
	public String getEventtitleImg() {
		return eventtitleImg;
	}
	public void setEventtitleImg(String eventtitleImg) {
		this.eventtitleImg = eventtitleImg;
	}
	public int getEventNo() {
		return eventNo;
	}
	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}
	public String getEventWriter() {
		return eventWriter;
	}
	public void setEventWriter(String eventWriter) {
		this.eventWriter = eventWriter;
	}
	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	public String getEventContent() {
		return eventContent;
	}
	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Event [eventNo=" + eventNo + ", eventWriter=" + eventWriter + ", eventTitle=" + eventTitle
				+ ", eventContent=" + eventContent + ", createDate=" + createDate + ", count=" + count + ", status="
				+ status + "]";
	}

	

	
	
}

