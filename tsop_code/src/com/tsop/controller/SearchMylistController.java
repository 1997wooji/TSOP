package com.tsop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.tsop.bean.AddPlaylistBean;
import com.tsop.bean.SimpleMusicBean;
import com.tsop.dao.PlaylistViewDAO;
import com.tsop.vo.PlaylistVO;

public class SearchMylistController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/JSON;UTF-8");
		
		String musicId = request.getParameter("musicId");
		String id = "joonsung14";
		PlaylistViewDAO play = new PlaylistViewDAO();
		Object[] objs = play.searchPlaylist(id);
		if(objs.length == 0){ return ;}
		
		List<AddPlaylistBean> playlists = new ArrayList<AddPlaylistBean>(); 
		List<SimpleMusicBean> musics = new ArrayList<SimpleMusicBean>();
		SimpleMusicBean simplemusic = new SimpleMusicBean(7,"노래추가");//플레이리스트 파일에서 읽어와서 SimpleMusicBean을 생성하고 AddPlaylistBean에 추가하기 위한 작업
		musics.add(simplemusic);
		JSONObject json = new JSONObject();
		
		for(int i=0;i<objs.length;i++){
			playlists.add(new AddPlaylistBean( ((PlaylistVO)objs[i]).getPlaylistId(), ((PlaylistVO)objs[i]).getPlaylistTitle(), "filePath-"+i, musics));//수록곡 곡번호는 파일에서 읽어와서 배열에 넣어서 관리
		}
		
		json.put("lists", playlists);
		response.getWriter().write(json.toString());
	}
}
