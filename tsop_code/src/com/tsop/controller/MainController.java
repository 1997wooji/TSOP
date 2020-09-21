package com.tsop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.bean.MusicBean;
import com.tsop.bean.PlaylistBean;
import com.tsop.dto.MemberDTO;
import com.tsop.util.HttpUtil;

public class MainController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
ArrayList<MemberDTO> members = new ArrayList<MemberDTO>();
		
		MemberDTO mem1 = new MemberDTO(); members.add(mem1);
		MemberDTO mem2 = new MemberDTO(); members.add(mem2);
		MemberDTO mem3 = new MemberDTO(); members.add(mem3);
		MemberDTO mem4 = new MemberDTO(); members.add(mem4);
		MemberDTO mem5 = new MemberDTO(); members.add(mem5);
		MemberDTO mem6 = new MemberDTO(); members.add(mem6);
		MemberDTO mem7 = new MemberDTO(); members.add(mem7);
		MemberDTO mem8 = new MemberDTO(); members.add(mem8);
		MemberDTO mem9 = new MemberDTO(); members.add(mem9);
		MemberDTO mem10 = new MemberDTO(); members.add(mem10);
		
		request.setAttribute("members", members);
		
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
		
		request.setAttribute("musics", musics);
		
		ArrayList<PlaylistBean> playlists = new ArrayList<PlaylistBean>();
		PlaylistBean playlist1 = new PlaylistBean();
		playlist1.setImagePath("/image/1.jpg");
		playlist1.setMemberId("member1");
		playlist1.setMemberNickName("회원1 닉네임");
		playlist1.setPlaylistTitle("플레이 리스트1");
		playlist1.setTagName("태그1");
		playlists.add(playlist1);
		PlaylistBean playlist2 = new PlaylistBean();
		playlist2.setImagePath("/image/2.jpg");
		playlist2.setMemberId("member2");
		playlist2.setMemberNickName("회원2 닉네임");
		playlist2.setPlaylistTitle("플레이 리스트2");
		playlist2.setTagName("태그2");
		playlists.add(playlist2);
		PlaylistBean playlist3 = new PlaylistBean();
		playlist3.setImagePath("/image/3.jpg");
		playlist3.setMemberId("member3");
		playlist3.setMemberNickName("회원3 닉네임");
		playlist3.setPlaylistTitle("플레이 리스트3");
		playlist3.setTagName("태그3");
		playlists.add(playlist3);
		
		request.setAttribute("playlists", playlists);
		
		HttpUtil.forward(request, response, "./main.jsp");
	}

}
