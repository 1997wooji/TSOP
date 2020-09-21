package com.tsop.vo;

public class FollowVO {
	
	private String followerId;
	private String followId;
	private String nickName;
	private String imagePath;
	
	public FollowVO(){
		
	}

	public FollowVO(String followerId, String followId, String nickName, String imagePath) {
		super();
		this.followerId = followerId;
		this.followId = followId;
		this.nickName = nickName;
		this.imagePath = imagePath;
	}

	public String getFollowerId() {
		return followerId;
	}

	public String getFollowId() {
		return followId;
	}

	public String getNickName() {
		return nickName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setFollowerId(String followerId) {
		this.followerId = followerId;
	}

	public void setFollowId(String followId) {
		this.followId = followId;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "FollowVO [followerId=" + followerId + ", followId=" + followId + ", nickName=" + nickName
				+ ", imagePath=" + imagePath + "]";
	}
	
	
	
}
