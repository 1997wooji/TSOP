package com.tsop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.bean.MemberBean;
import com.tsop.bean.MusicBean;
import com.tsop.dao.FileViewDAO;
import com.tsop.dao.FollowViewDAO;
import com.tsop.dao.MemberViewDAO;
import com.tsop.dao.MusicViewDAO;
import com.tsop.dto.MusicDTO;
import com.tsop.vo.FollowVO;
import com.tsop.vo.MemberVO;
import com.tsop.vo.MusicVO;

public class SearchController implements Controller {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		String job = request.getParameter("job");
		
		switch(job)
		{
		case "music":
			music(request, response);
			break;/*
		case "playlist":
			playlist(request,response);
			break;*/
		case "artist":
			artistlist(request,response);
			break;
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("searchmusic.jsp");
		rd.forward(request, response);
		
	}
	
	public void music(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		MusicDTO dto =  MusicDTO.getInstance();
		MusicViewDAO musicViewDAO = new MusicViewDAO();
		FileViewDAO fileViewDAO = new FileViewDAO();
		String key = request.getParameter("key");
		
		Object[] objs = musicViewDAO.searchTitleMusic(key);
		if(objs == null){return ;}
		List<MusicBean> list = new ArrayList<MusicBean>();
		int fileId = -1;
		if(objs!= null){
			for(int i = 0;i<objs.length;i++){
				fileId = musicViewDAO.searchMusicFileId(((MusicVO)objs[i]).getMusicId());
				list.add(new MusicBean(((MusicVO)objs[i]).getMusicId(), ((MusicVO)objs[i]).getMusicTitle(), fileViewDAO.searchFilePath(fileId), ((MusicVO)objs[i]).getMemberNickName(), ((MusicVO)objs[i]).getMemberId(), ((MusicVO)objs[i]).getImagePath()));
			}
		}
		System.out.println(list.toString());
		
		request.setAttribute("job", "music");
		
		request.setAttribute("list", list);
		
		request.setAttribute("listSize", list.size()-1);
	}
	/*
	public void playlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String key = request.getParameter("key");
		PlaylistViewDAO playlist = new PlaylistViewDAO();
		Object[] objs = playlist.searchPlaylist(key, 0);
		String filePath = -1;
		if(objs != null){
			for(int i=0;i<objs.length;i++)
			{
				playlist.searchPlaylistFilePath(((PlaylistVO)objs[i]).getPlaylistId());
			}
			
		}
		
		Object[] objs = 
		
		request.setAttribute("job", "playlist");
		
		request.setAttribute("list", list);
		
		request.setAttribute("listSize", list.size()-1);
	}
	*/
	public void artistlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = "joonsung14";//로그인한 아이디라고 생각하고.
		String key = request.getParameter("key");
		MemberViewDAO memberView = new MemberViewDAO();
		FollowViewDAO followView = new FollowViewDAO();
		Object[] follow = followView.searchFollow(id);
		boolean res = false;
		
		MemberBean member = null;
		Object[] objs = memberView.searchMembers("");
		if(objs == null){return ;}
		List<MemberBean> list = new ArrayList<MemberBean>();
		
		for(int i=0;i<objs.length;i++){
			for(int j=0;j<follow.length;j++){
				if(follow[j] != null){
					if(((FollowVO)follow[j]).getFollowId().equals(((MemberVO)objs[i]).getMemberId())){
						list.add(new MemberBean( ((MemberVO)objs[i]).getMemberId(), ((MemberVO)objs[i]).getMemberNickName(), memberView.searchImagePath(((MemberVO)objs[i]).getMemberId())));
						res= true;
						break;
					}
				}
			}
			if(!res){
			list.add(new MemberBean( ((MemberVO)objs[i]).getMemberId(), ((MemberVO)objs[i]).getMemberNickName(), memberView.searchImagePath(((MemberVO)objs[i]).getMemberId())));
			}
			res= false;
		}
		
		request.setAttribute("job", "artist");
		
		request.setAttribute("list", list);
		
		request.setAttribute("listSize", list.size()-1);
	}

}
