package com.kh.event.model.vo;

import java.sql.Date;

public class EventAttachment {


	
	private int fileNo; //FILE_NO  
	private int refEno; //REF_ENO
	private String originName; // ORIGIN_NAME
	private String changeName; //CHANGE_NAME
	private String filePath; //FILE_PATH
	private Date uploadDate; //UPLOAD_DATE
	private int fileLevel; //FILE_LEVEl
	private String status; //STATUS
	public EventAttachment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EventAttachment(int fileNo, int refEno, String originName, String changeName, String filePath,
			Date uploadDate, int fileLevel, String status) {
		super();
		this.fileNo = fileNo;
		this.refEno = refEno;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.fileLevel = fileLevel;
		this.status = status;
	}
	
	
	public EventAttachment(int fileNo, String originName, String changeName, String filePath) {
		super();
		this.fileNo = fileNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public int getRefEno() {
		return refEno;
	}
	public void setRefEno(int refEno) {
		this.refEno = refEno;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public int getFileLevel() {
		return fileLevel;
	}
	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "EventAttachment [fileNo=" + fileNo + ", refEno=" + refEno + ", originName=" + originName
				+ ", changeName=" + changeName + ", filePath=" + filePath + ", uploadDate=" + uploadDate
				+ ", fileLevel=" + fileLevel + ", status=" + status + "]";
	}
	
	
}
