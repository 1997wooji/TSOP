package com.tsop.vo;

public class MemberVO {
	private String memberId;
	private String memberPwd;
	private String memberNickName;
	private String memberName;
	private String memberPhone;
	private String memberEmail;
	private String memberClassName;
	private int maxStoreSize;
	private String memberIntro;
	
	public MemberVO(){
		
	}
	
	public MemberVO(String memberId, String memberPwd, String memberNickName, String memberName, String memberPhone,
			String memberEmail, String memberClassName, int maxStoreSize, String memberIntro) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberNickName = memberNickName;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberClassName = memberClassName;
		this.maxStoreSize = maxStoreSize;
		this.memberIntro = memberIntro;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public String getMemberNickName() {
		return memberNickName;
	}

	public String getMemberName() {
		return memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public String getMemberClassName() {
		return memberClassName;
	}

	public int getMaxStoreSize() {
		return maxStoreSize;
	}

	public String getMemberIntro() {
		return memberIntro;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public void setMemberClassName(String memberClassName) {
		this.memberClassName = memberClassName;
	}

	public void setMaxStoreSize(int maxStoreSize) {
		this.maxStoreSize = maxStoreSize;
	}

	public void setMemberIntro(String memberIntro) {
		this.memberIntro = memberIntro;
	}

	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberNickName=" + memberNickName
				+ ", memberName=" + memberName + ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail
				+ ", memberClassName=" + memberClassName + ", maxStoreSize=" + maxStoreSize + ", memberIntro="
				+ memberIntro + "]";
	}
	
	
	
}
