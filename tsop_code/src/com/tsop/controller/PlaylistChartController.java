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
		music1.setMusicTitle("��������1");
		music1.setImagePath("/image/1.jpg");
		music1.setMemberNickName("ȸ��1 �г���");
		music1.setMemberId("member1");
		music1.setGenreName("�帣1");
		music1.setTagName("�±�1");
		music1.setLikeCnt(20);
		musics.add(music1);
		MusicBean music2 = new MusicBean();
		music2.setMusicId(2);
		music2.setMusicTitle("��������2");
		music2.setImagePath("/image/2.jpg");
		music2.setMemberNickName("ȸ��2 �г���");
		music2.setMemberId("member2");
		music2.setGenreName("�帣2");
		music2.setTagName("�±�2");
		music2.setLikeCnt(30);
		musics.add(music2);
		MusicBean music3 = new MusicBean();
		music3.setMusicId(3);
		music3.setMusicTitle("��������3");
		music3.setImagePath("/image/3.jpg");
		music3.setMemberNickName("ȸ��3 �г���");
		music3.setMemberId("member3");
		music3.setGenreName("�帣3");
		music3.setTagName("�±�3");
		music3.setLikeCnt(40);
		musics.add(music3);
		
		ArrayList<PlaylistPrintBean2> playlists = new ArrayList<PlaylistPrintBean2>();
		PlaylistPrintBean2 playlist1 = new PlaylistPrintBean2();
		playlist1.setImagePath("/image/1.jpg");
		playlist1.setMemberId("member1");
		playlist1.setMemberNickName("ȸ�� �г���1");
		playlist1.setMusicList(musics);
		playlist1.setPlaylistId(1);
		playlist1.setPlaylistTitle("������1");
		playlist1.setTagName("�±�1");
		playlists.add(playlist1);
		
		PlaylistPrintBean2 playlist2 = new PlaylistPrintBean2();
		playlist2.setImagePath("/image/2.jpg");
		playlist2.setMemberId("member2");
		playlist2.setMemberNickName("ȸ�� �г���2");
		playlist2.setMusicList(musics);
		playlist2.setPlaylistId(2);
		playlist2.setPlaylistTitle("������2");
		playlist2.setTagName("�±�2");
		playlists.add(playlist2);
		
		request.setAttribute("playlists", playlists);
		
		HttpUtil.forward(request, response, "./playlistchart.jsp");
	}

}
