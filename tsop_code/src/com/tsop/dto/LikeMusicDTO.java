package com.tsop.dto;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : LikeMusicDTO.java
//  @ Date : 2018-07-14
//  @ Author : 
//
//




public class LikeMusicDTO {
	public String memberId;
	public int musicId;
	
	public LikeMusicDTO(){
		
		memberId="jiwoo";
		musicId=1;
		
	}

	public LikeMusicDTO(String memberId, int musicId) {
		super();
		this.memberId = memberId;
		this.musicId = musicId;
	}

	public String getMemberId() {
		return memberId;
	}

	public int getMusicId() {
		return musicId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}
	
	
}
