package com.tsop.bean;

public class MusicBean {
	
	private int musicId;
	private String musicTitle;
	private String musicFilePath;
	private String memberNickName;
	private String memberId;
	private String musicImagePath;
	
	public MusicBean() {

	}

	
	public MusicBean(int musicId, String musicTitle, String musicFilePath, String memberNickName, String memberId,
			String musicImagePath) {
		super();
		this.musicId = musicId;
		this.musicTitle = musicTitle;
		this.musicFilePath = musicFilePath;
		this.memberNickName = memberNickName;
		this.memberId = memberId;
		this.musicImagePath = musicImagePath;
	}




	public int getMusicId() {
		return musicId;
	}

	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}

	public String getMusicTitle() {
		return musicTitle;
	}

	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}

	public String getMusicFilePath() {
		return musicFilePath;
	}

	public void setMusicFilePath(String musicFilePath) {
		this.musicFilePath = musicFilePath;
	}

	public String getMemberNickName() {
		return memberNickName;
	}

	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMusicImagePath() {
		return musicImagePath;
	}

	public void setMusicImagePath(String musicImagePath) {
		this.musicImagePath = musicImagePath;
	}
	
	   public String toString() {
		      return "{'musicId':'" + musicId + "', 'memberNickName': '" + memberNickName + "', 'musicTitle': '" + musicTitle + 
		            "', 'memberId': '" + memberId + "' }";
		   }
}
