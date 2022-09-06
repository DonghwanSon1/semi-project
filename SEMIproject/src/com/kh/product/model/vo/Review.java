package com.kh.product.model.vo;

public class Review {
	
	private int reviewNo; 
	private String reviewWriter;
	private int reviewPno;
	private String reviewContent;
	private String createDate;
	
	
	public Review(int reviewNo, String reviewWriter, int reviewPno, String reviewContent, String createDate) {
		super();
		this.reviewNo = reviewNo;
		this.reviewWriter = reviewWriter;
		this.reviewPno = reviewPno;
		this.reviewContent = reviewContent;
		this.createDate = createDate;
	}
	
	public Review(int reviewNo, String reviewWriter, String reviewContent, String createDate) {
		super();
		this.reviewNo = reviewNo;
		this.reviewWriter = reviewWriter;
		this.reviewContent = reviewContent;
		this.createDate = createDate;
	}


	public Review() {
		super();
	}

	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


	public String getReviewWriter() {
		return reviewWriter;
	}


	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}


	public int getReviewPno() {
		return reviewPno;
	}


	public void setReviewPno(int reviewPno) {
		this.reviewPno = reviewPno;
	}


	public String getReviewContent() {
		return reviewContent;
	}


	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", reviewWriter=" + reviewWriter + ", reviewPno=" + reviewPno
				+ ", reviewContent=" + reviewContent + ", createDate=" + createDate + "]";
	}
	
	
	
	
}




