package com.tsop.bean;

public class MusicInfo {
	private int musicId;
	private String musicTitle;
	private String musicIntro;
	private String tag;
	private String genre;
	private String memberId;
	private String memberNickName;
	private String img;
	private int likeCnt;
	private int playCnt;
	private boolean visibility;
	private boolean downAccept;
	public MusicInfo() {
		super();
		
		musicId= 1;
		musicTitle= "²É±æ";
		musicIntro = "ºò¹ðÀÇ ³ë·¡ÀÔ´Ï´Ù.";
		tag = "²É±æ¸¸ °ÈÀÚ";
		genre = "°¡¿ä";
		memberId = "BigBang";
		memberNickName = "ºò¹ð";
		img = "./image/b2.gif";
		likeCnt = 100;
		playCnt = 150;
		visibility = true;
		downAccept = true;
	}
	public MusicInfo(int musicId, String musicTitle, String musicIntro, String tag, String genre, String memberId,
			String memberNickName, String img, int likeCnt, int playCnt, boolean visibility, boolean downAccept) {
		super();
		this.musicId = musicId;
		this.musicTitle = musicTitle;
		this.musicIntro = musicIntro;
		this.tag = tag;
		this.genre = genre;
		this.memberId = memberId;
		this.memberNickName = memberNickName;
		this.img = img;
		this.likeCnt = likeCnt;
		this.playCnt = playCnt;
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
	public String getMusicIntro() {
		return musicIntro;
	}
	public void setMusicIntro(String musicIntro) {
		this.musicIntro = musicIntro;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public int getPlayCnt() {
		return playCnt;
	}
	public void setPlayCnt(int playCnt) {
		this.playCnt = playCnt;
	}
	public boolean isVisibility() {
		return visibility;
	}
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}
	public boolean isDownAccept() {
		return downAccept;
	}
	public void setDownAccept(boolean downAccept) {
		this.downAccept = downAccept;
	}
	@Override
	public String toString() {
		return "MusicInfo [musicId=" + musicId + ", musicTitle=" + musicTitle + ", musicIntro=" + musicIntro + ", tag="
				+ tag + ", genre=" + genre + ", memberId=" + memberId + ", memberNickName=" + memberNickName + ", img="
				+ img + ", likeCnt=" + likeCnt + ", playCnt=" + playCnt + ", visibility=" + visibility + ", downAccept="
				+ downAccept + "]";
	}
}
