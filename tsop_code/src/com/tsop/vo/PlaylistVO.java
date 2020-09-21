package com.tsop.vo;

public class PlaylistVO {
	private int playlistId;
	private String playlistTitle;
	private String memberId;
	private String memberNickName;
	private String playlistIntro;
	private String playlistDate;
	private String tagName;
	private String imagePath;
	private int likeCnt;
	private int repostCnt;
	private boolean visibility;
	
	public PlaylistVO(){
		
	}
	
	public PlaylistVO(int playlistId, String playlistTitle, String memberId, String memberNickName,
			String playlistIntro, String playlistDate, String tagName, String imagePath, int likeCnt, int repostCnt,
			boolean visibility) {
		super();
		this.playlistId = playlistId;		
		this.playlistTitle = playlistTitle;
		this.memberId = memberId;
		this.memberNickName = memberNickName;
		this.playlistIntro = playlistIntro;
		this.playlistDate = playlistDate;
		this.tagName = tagName;
		this.imagePath = imagePath;
		this.likeCnt = likeCnt;
		this.repostCnt = repostCnt;
		this.visibility = visibility;
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

	public String getPlaylistIntro() {
		return playlistIntro;
	}

	public String getPlaylistDate() {
		return playlistDate;
	}

	public String getTagName() {
		return tagName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public int getRepostCnt() {
		return repostCnt;
	}

	public boolean isVisibility() {
		return visibility;
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

	public void setPlaylistIntro(String playlistIntro) {
		this.playlistIntro = playlistIntro;
	}

	public void setPlaylistDate(String playlistDate) {
		this.playlistDate = playlistDate;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public void setRepostCnt(int repostCnt) {
		this.repostCnt = repostCnt;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	@Override
	public String toString() {
		return "PlaylistVO [playlistId=" + playlistId + ", playlistTitle=" + playlistTitle + ", memberId=" + memberId
				+ ", memberNickName=" + memberNickName + ", playlistIntro=" + playlistIntro + ", playlistDate="
				+ playlistDate + ", tagName=" + tagName + ", imagePath=" + imagePath + ", likeCnt=" + likeCnt
				+ ", repostCnt=" + repostCnt + ", visibility=" + visibility + "]";
	}

	
	
}
