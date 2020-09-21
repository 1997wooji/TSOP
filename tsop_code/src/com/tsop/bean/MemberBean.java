package com.tsop.bean;

public class MemberBean {
	private String memberId;
	private String memberNickName;
	private String imagePath;
	
	public MemberBean(){}
	
	
	public MemberBean(String memberId, String memberNickName, String imagePath) {
		super();
		this.memberId = memberId;
		this.memberNickName = memberNickName;
		this.imagePath = imagePath;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberNickName() {
		return memberNickName;
	}
	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}
