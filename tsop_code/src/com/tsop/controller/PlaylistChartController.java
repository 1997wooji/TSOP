package com.tsop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.bean.MusicBean;
import com.tsop.bean.PlaylistPrintBean2;
import com.tsop.util.HttpUtil;

public class PlaylistChartController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
ArrayList<MusicBean> musics = new ArrayList<MusicBean>();
		
		MusicBean music1 = new MusicBean(); 
		music1.setMusicId(1);
		music1.setMusicTitle("음악제목1");
		music1.setImagePath("/image/1.jpg");
		music1.setMemberNickName("회원1 닉네임");
		music1.setMemberId("member1");
		music1.setGenreName("장르1");
		music1.setTagName("태그1");
		music1.setLikeCnt(20);
		musics.add(music1);
		MusicBean music2 = new MusicBean();
		music2.setMusicId(2);
		music2.setMusicTitle("음악제목2");
		music2.setImagePath("/image/2.jpg");
		music2.setMemberNickName("회원2 닉네임");
		music2.setMemberId("member2");
		music2.setGenreName("장르2");
		music2.setTagName("태그2");
		music2.setLikeCnt(30);
		musics.add(music2);
		MusicBean music3 = new MusicBean();
		music3.setMusicId(3);
		music3.setMusicTitle("음악제목3");
		music3.setImagePath("/image/3.jpg");
		music3.setMemberNickName("회원3 닉네임");
		music3.setMemberId("member3");
		music3.setGenreName("장르3");
		music3.setTagName("태그3");
		music3.setLikeCnt(40);
		musics.add(music3);
		
		ArrayList<PlaylistPrintBean2> playlists = new ArrayList<PlaylistPrintBean2>();
		PlaylistPrintBean2 playlist1 = new PlaylistPrintBean2();
		playlist1.setImagePath("/image/1.jpg");
		playlist1.setMemberId("member1");
		playlist1.setMemberNickName("회원 닉네임1");
		playlist1.setMusicList(musics);
		playlist1.setPlaylistId(1);
		playlist1.setPlaylistTitle("재생목록1");
		playlist1.setTagName("태그1");
		playlists.add(playlist1);
		
		PlaylistPrintBean2 playlist2 = new PlaylistPrintBean2();
		playlist2.setImagePath("/image/2.jpg");
		playlist2.setMemberId("member2");
		playlist2.setMemberNickName("회원 닉네임2");
		playlist2.setMusicList(musics);
		playlist2.setPlaylistId(2);
		playlist2.setPlaylistTitle("재생목록2");
		playlist2.setTagName("태그2");
		playlists.add(playlist2);
		
		request.setAttribute("playlists", playlists);
		
		HttpUtil.forward(request, response, "./playlistchart.jsp");
	}

}
