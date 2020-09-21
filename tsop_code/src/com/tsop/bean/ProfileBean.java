package com.tsop.bean;

public class ProfileBean {
	private String memberId;
	private String memberNickName;
	private String memberIntro;
	private String imagePath;
	
	public ProfileBean(){
		
	}
	
	public ProfileBean(String memberId, String memberNickName, String memberIntro, String imagePath) {
		super();
		this.memberId = memberId;
		this.memberNickName = memberNickName;
		this.memberIntro = memberIntro;
		this.imagePath = imagePath;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getMemberNickName() {
		return memberNickName;
	}

	public String getMemberIntro() {
		return memberIntro;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}

	public void setMemberIntro(String memberIntro) {
		this.memberIntro = memberIntro;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
}
