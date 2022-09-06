package com.kh.member.model.vo;

import java.sql.Date;

public class Member {

	private int memberNo;//MEMBER_NO	NUMBER
	private String memberId;//MEMBER_ID	VARCHAR2(30 BYTE)
	private String memberPwd;//MEMBER_PWD	VARCHAR2(100 BYTE)
	private String memberName;//MEMBER_NAME	VARCHAR2(20 BYTE)
	private String memberNick;//MEMBER_NICK	VARCHAR2(20 BYTE)
	private String phone;//PHONE	VARCHAR2(14 BYTE)
	private String email;//EMAIL	VARCHAR2(50 BYTE)
	private Date birthDay;//BIRTHDAY	DATE
	private String question;//QUESTION	VARCHAR2(50 BYTE)
	private String answer;//ANSWER	VARCHAR2(50 BYTE)
	private String status;//STATUS	VARCHAR2(1 BYTE)
	private int point;//POINT	NUMBER
	private Date enrollDate;//ENROLL_DATE	DATE
	
	public Member() {
		super();
	}

	public Member(int memberNo, String memberId, String memberPwd, String memberName, String memberNick, String phone,
			String email, Date birthDay, String question, String answer, String status, int point,
			Date enrollDate) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberNick = memberNick;
		this.phone = phone;
		this.email = email;
		this.birthDay = birthDay;
		this.question = question;
		this.answer = answer;
		this.status = status;
		this.point = point;
		this.enrollDate = enrollDate;
	}
	
	public Member(String memberId, String memberPwd, String memberName, Date birthDay, String question, String answer, String email, String phone, String memberNick) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.birthDay = birthDay;
		this.question = question;
		this.answer = answer;
		this.email = email;
		this.phone = phone;
		this.memberNick = memberNick;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName="
				+ memberName + ", memberNick=" + memberNick + ", phone=" + phone + ", email=" + email + ", birthDay=" 
				+ birthDay + ", question=" + question + ", answer=" + answer + ", status="
				+ status + ", point=" + point + ", enrollDate=" + enrollDate + "]";
	}
}
