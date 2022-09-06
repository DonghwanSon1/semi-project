package com.kh.board.model.vo;

import java.sql.Date;

public class Board {

	private int boardNo; // BOARD_NO NUMBER PRIMARY KEY,
	private String category; //    CATEGORY_NO NUMBER NOT NULL,
	private String boardWriter; //   BOARD_WRITER NUMBER NOT NULL,
	private String boardTitle; //   BOARD_TITLE VARCHAR2(50) NOT NULL,
	private String boardContent; //  BOARD_CONTENT VARCHAR2(4000) NOT NULL,
	private Date createDate; //  CREATE_DATE DATE NOT NULL,
	private int count; // COUNT NUMBER DEFAULT 0 NOT NULL,
	private String status; //    STATUS VARCHAR2(1) DEFAULT 'Y' NOT NULL,
	private String titleImg;
	


	public Board() {
		super();
	
	}
	
	
	
	public Board(int boardNo, String category, String boardWriter, String boardTitle, int count, Date createDate) {
		super();
		this.boardNo = boardNo;
		this.category = category;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.count = count;
		this.createDate = createDate;
	}
	


	public Board(int boardNo, String category, String boardWriter, String boardTitle, String boardContent,
			Date createDate) {
		super();
		this.boardNo = boardNo;
		this.category = category;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.createDate = createDate;
	}
	


	public Board(String boardTitle, String boardContent, String boardWriter) {
		super();
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
	}
	
	
	
	
	public String getTitleImg() {
		return titleImg;
	}


	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
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
		return "Board [boardNo=" + boardNo + ", category=" + category + ", boardWriter=" + boardWriter + ", boardTitle="
				+ boardTitle + ", boardContent=" + boardContent + ", createDate=" + createDate + ", count=" + count
				+ ", status=" + status + "]";
	}
	
}
