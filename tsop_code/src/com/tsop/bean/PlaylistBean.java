package com.tsop.bean;


public class PlaylistBean {
	
	private int playlistId;
	private String playlistTitle;
	private String imagePath;
	private String memberId;
	private String memberNickName;
	private String tagName;
	private String playlistIntro;
	private String playlistDate;
	
	public PlaylistBean(){
		
	}
	
	public PlaylistBean(int playlistId, String playlistTitle, String imagePath, String memberId, String memberNickName,
			String tagName, String playlistIntro, String playlistDate) {
		super();
		this.playlistId = playlistId;
		this.playlistTitle = playlistTitle;
		this.imagePath = imagePath;
		this.memberId = memberId;
		this.memberNickName = memberNickName;
		this.tagName = tagName;
		this.playlistIntro = playlistIntro;
		this.playlistDate = playlistDate;
	}

	public int getPlaylistId() {
		return playlistId;
	}

	public String getPlaylistTitle() {
		return playlistTitle;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getMemberNickName() {
		return memberNickName;
	}

	public String getTagName() {
		return tagName;
	}

	public String getPlaylistIntro() {
		return playlistIntro;
	}

	public String getPlaylistDate() {
		return playlistDate;
	}

	public void setPlaylistId(int playlistId) {
		this.playlistId = playlistId;
	}

	public void setPlaylistTitle(String playlistTitle) {
		this.playlistTitle = playlistTitle;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public void setPlaylistIntro(String playlistIntro) {
		this.playlistIntro = playlistIntro;
	}

	public void setPlaylistDate(String playlistDate) {
		this.playlistDate = playlistDate;
	}

	@Override
	public String toString() {
		return "{'playlistId':" + playlistId + ", 'playlistTitle':" + playlistTitle + ", 'imagePath':"
				+ imagePath + ", 'memberId':" + memberId + ", 'memberNickName':" + memberNickName + ", 'tagName':" + tagName
				+ ", 'playlistIntro':" + playlistIntro + ", 'playlistDate':" + playlistDate + "}";
	}
	
	
	
}
