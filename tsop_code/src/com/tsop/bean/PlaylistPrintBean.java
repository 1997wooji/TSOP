package com.tsop.bean;

import java.time.LocalDateTime;
import java.util.List;

public class PlaylistPrintBean {
	
	private int playlistId;
	private String playlistTitle;
	private String imagePath;
	private String memberId;
	private String memberNickName;
	private String tagName;
	private String playlistIntro;
	private LocalDateTime playlistDate;
	private List<MusicBean> musicList;
	
	public PlaylistPrintBean(){
		
	}
	
	public PlaylistPrintBean(int playlistId, String playlistTitle, String imagePath, String memberId,
			String memberNickName, String tagName, String playlistIntro, LocalDateTime playlistDate,
			List<MusicBean> musicList) {
		super();
		this.playlistId = playlistId;
		this.playlistTitle = playlistTitle;
		this.imagePath = imagePath;
		this.memberId = memberId;
		this.memberNickName = memberNickName;
		this.tagName = tagName;
		this.playlistIntro = playlistIntro;
		this.playlistDate = playlistDate;
		this.musicList = musicList;
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

	public LocalDateTime getPlaylistDate() {
		return playlistDate;
	}

	public List<MusicBean> getMusicList() {
		return musicList;
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

	public void setPlaylistDate(LocalDateTime playlistDate) {
		this.playlistDate = playlistDate;
	}

	public void setMusicList(List<MusicBean> musicList) {
		this.musicList = musicList;
	}
	
	
	
	
}
