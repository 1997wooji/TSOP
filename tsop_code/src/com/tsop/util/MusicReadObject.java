package com.tsop.util;

import java.io.Serializable;

public class MusicReadObject implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //이게 뭐하는 애임?
	
	private int musicId;
	private String musicPath;
	
	public MusicReadObject(){
		
	}
	
	public MusicReadObject(int musicId, String musicPath) {
		super();
		this.musicId = musicId;
		this.musicPath = musicPath;
	}

	public int getMusicId() {
		return musicId;
	}

	public String getMusicPath() {
		return musicPath;
	}

	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}

	public void setMusicPath(String musicPath) {
		this.musicPath = musicPath;
	}
	
	

}
