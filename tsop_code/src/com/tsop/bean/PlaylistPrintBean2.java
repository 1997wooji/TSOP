package com.tsop.bean;

import java.util.List;


public class PlaylistPrintBean2 {
	
	private PlaylistBean playlist;
	private List<MusicBean> musicList;
	
	public PlaylistPrintBean2(){
		playlist = new PlaylistBean();
	}
	
	public PlaylistPrintBean2(PlaylistBean playlist, List<MusicBean> musicList) {
		super();
		this.playlist = playlist;
		this.musicList = musicList;
	}

	public PlaylistBean getPlaylist() {
		return playlist;
	}

	public List<MusicBean> getMusicList() {
		return musicList;
	}

	public void setPlaylist(PlaylistBean playlist) {
		this.playlist = playlist;
	}

	public void setMusicList(List<MusicBean> musicList) {
		this.musicList = musicList;
	}

	@Override
	public String toString() {
		return "{'playlist':" + playlist + ", 'musicList':" + musicList + "}";
	}
		
	
}
