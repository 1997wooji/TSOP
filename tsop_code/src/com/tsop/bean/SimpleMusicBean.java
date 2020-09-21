package com.tsop.bean;

public class SimpleMusicBean {
	private int musicId;
	private String filePath;
	public SimpleMusicBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SimpleMusicBean(int musicId, String filePath) {
		super();
		this.musicId = musicId;
		this.filePath = filePath;
	}
	public int getMusicId() {
		return musicId;
	}
	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	@Override
	public String toString() {
		return "{'musicId':'" + musicId + "', 'filePath': '" + filePath + "' }";
	}
	
}
