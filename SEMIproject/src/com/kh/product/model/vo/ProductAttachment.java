package com.kh.product.model.vo;

import java.sql.Date;

public class ProductAttachment {
	
	private int fileNo; //FILE_NO
	private int refPno; //REF_PNO
	private String originName; //ORIGIN_NAME
	private String changeName; //CHANGE_NAME
	private String filePath; //FILE_PATH
	private Date updloadDate; //UPLOAD_DATE
	private int fileLevel; //FILE_LEVEL
	private String status; //STATUS
	
	public ProductAttachment() {
		super();
	}

	public ProductAttachment(int fileNo, int refPno, String originName, String changeName, String filePath,
			Date updloadDate, int fileLevel, String status) {
		super();
		this.fileNo = fileNo;
		this.refPno = refPno;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.updloadDate = updloadDate;
		this.fileLevel = fileLevel;
		this.status = status;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getRefPno() {
		return refPno;
	}

	public void setRefPno(int refPno) {
		this.refPno = refPno;
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

	public Date getUpdloadDate() {
		return updloadDate;
	}

	public void setUpdloadDate(Date updloadDate) {
		this.updloadDate = updloadDate;
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
		return "ProductAttachment [fileNo=" + fileNo + ", refPno=" + refPno + ", originName=" + originName
				+ ", changeName=" + changeName + ", filePath=" + filePath + ", updloadDate=" + updloadDate
				+ ", fileLevel=" + fileLevel + ", status=" + status + "]";
	}

}
