package com.tsop.vo;

public class SimplePlaylistVO {
	private int playlistId;
	private String playlistTitle;
	private String memberId;
	private String memberNickName;
	private String imagePath;
	
	public SimplePlaylistVO(){
		
	}
	
	public SimplePlaylistVO(int playlistId, String playlistTitle, String memberId, String memberNickName,
			String imagePath) {
		super();
		this.playlistId = playlistId;
		this.playlistTitle = playlistTitle;
		this.memberId = memberId;
		this.memberNickName = memberNickName;
		this.imagePath = imagePath;
	}

	public int getPlaylistId() {
		return playlistId;
	}

	public String getPlaylistTitle() {
		return playlistTitle;
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

	public void setPlaylistId(int playlistId) {
		this.playlistId = playlistId;
	}

	public void setPlaylistTitle(String playlistTitle) {
		this.playlistTitle = playlistTitle;
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
		return "SimplePlaylistVO [playlistId=" + playlistId + ", playlistTitle=" + playlistTitle + ", memberId="
				+ memberId + ", memberNickName=" + memberNickName + ", imagePath=" + imagePath + "]";
	}
	
	
	
}
