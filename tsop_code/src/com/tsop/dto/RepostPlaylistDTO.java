package com.tsop.dto;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : RepostPlayListDTO.java
//  @ Date : 2018-07-14
//  @ Author : 
//
//




public class RepostPlaylistDTO {
	public int playlistId;
	public String memberId;
	
	public RepostPlaylistDTO(){
		
		playlistId=1;
		memberId="jiwoo";
	}
	
	public RepostPlaylistDTO(int playlistId, String memberId) {
		super();
		this.playlistId = playlistId;
		this.memberId = memberId;
	}

	public int getPlaylistId() {
		return playlistId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setPlaylistId(int playlistId) {
		this.playlistId = playlistId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
	
	
}
