package com.tsop.bean;

import java.util.List;

public class AddPlaylistBean {
	private int playlistId;
	private String playlistTitle;
	private String playlistPath;
	private List<SimpleMusicBean> musicIds;//¼ö·Ï°î ¹øÈ£
	public AddPlaylistBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddPlaylistBean(int playlistId, String playlistTitle, String playlistPath, List<SimpleMusicBean> musicIds) {
		super();
		this.playlistId = playlistId;
		this.playlistTitle = playlistTitle;
		this.playlistPath = playlistPath;
		this.musicIds = musicIds;
	}
	public int getPlaylistId() {
		return playlistId;
	}
	public void setPlaylistId(int playlistId) {
		this.playlistId = playlistId;
	}
	public String getPlaylistTitle() {
		return playlistTitle;
	}
	public void setPlaylistTitle(String playlistTitle) {
		this.playlistTitle = playlistTitle;
	}
	public String getPlaylistPath() {
		return playlistPath;
	}
	public void setPlaylistPath(String playlistPath) {
		this.playlistPath = playlistPath;
	}
	public List<SimpleMusicBean> getMusicIds() {
		return musicIds;
	}
	public void setMusicIds(List<SimpleMusicBean> musicIds) {
		this.musicIds = musicIds;
	}
	@Override
	public String toString() {
		return "{'playlistId':'" + playlistId + "', 'playlistTitle': '" + playlistTitle + "' , 'playlistPath': '"
				+ playlistPath + "' , 'musicIds':" + musicIds + "}";
	}
	
	

	
	
}
