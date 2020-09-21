package com.tsop.vo;

public class MusicVO {
	private int musicId;
	private String musicTitle;
	private String imagePath;
	private String memberNickName;
	private int playTime;
	private String musicDate;
	private int playCnt;
	private String musicIntro;
	private String genreName;
	private String tagname;
	private int likeCnt;
	private boolean visibility;
	private boolean downAccept;
	public MusicVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MusicVO(int musicId, String musicTitle, String imagePath, String memberNickName, int playTime,
			String musicDate, int playCnt, String musicIntro, String genreName, String tagname, int likeCnt,
			boolean visibility, boolean downAccept) {
		super();
		this.musicId = musicId;
		this.musicTitle = musicTitle;
		this.imagePath = imagePath;
		this.memberNickName = memberNickName;
		this.playTime = playTime;
		this.musicDate = musicDate;
		this.playCnt = playCnt;
		this.musicIntro = musicIntro;
		this.genreName = genreName;
		this.tagname = tagname;
		this.likeCnt = likeCnt;
		this.visibility = visibility;
		this.downAccept = downAccept;
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
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getMemberNickName() {
		return memberNickName;
	}
	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}
	public int getPlayTime() {
		return playTime;
	}
	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}
	public String getMusicDate() {
		return musicDate;
	}
	public void setMusicDate(String musicDate) {
		this.musicDate = musicDate;
	}
	public int getPlayCnt() {
		return playCnt;
	}
	public void setPlayCnt(int playCnt) {
		this.playCnt = playCnt;
	}
	public String getMusicIntro() {
		return musicIntro;
	}
	public void setMusicIntro(String musicIntro) {
		this.musicIntro = musicIntro;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	public String getTagname() {
		return tagname;
	}
	public void setTagname(String tagname) {
		this.tagname = tagname;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public boolean isVisibility() {
		return visibility;
	}
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}
	public boolean isDo150wnAccept() {
		return downAccept;
	}
	public void setDownAccept(boolean downAccept) {
		this.downAccept = downAccept;
	}
	@Override
	public String toString() {
		return "MusicVO [musicId=" + musicId + ", musicTitle=" + musicTitle + ", imagePath=" + imagePath
				+ ", memberNickName=" + memberNickName + ", playTime=" + playTime + ", musicDate=" + musicDate
				+ ", playCnt=" + playCnt + ", musicIntro=" + musicIntro + ", genreName=" + genreName + ", tagname="
				+ tagname + ", likeCnt=" + likeCnt + ", visibility=" + visibility + ", downAccept=" + downAccept + "]";
	}
	
	
}
