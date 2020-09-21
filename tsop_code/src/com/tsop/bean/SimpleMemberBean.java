package com.tsop.bean;

public class SimpleMemberBean {
	
	private String memberId;
	private String memberNickName;
	private String imagePath;
	
	public SimpleMemberBean(){
		
	}

	public SimpleMemberBean(String memberId, String memberNickName, String imagePath) {
		super();
		this.memberId = memberId;
		this.memberNickName = memberNickName;
		this.imagePath = imagePath;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getMemberNickName() {
		return memberNickName;
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

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "{'memberId':" + memberId + ", 'memberNickName':" + memberNickName + ", 'imagePath':"
				+ imagePath + "}";
	}
	
	

}
