package com.tsop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.bean.MusicDetailBean;
import com.tsop.bean.ProfileBean;
import com.tsop.dao.MemberViewDAO;
import com.tsop.dao.MusicViewDAO;
import com.tsop.vo.MemberVO;
import com.tsop.vo.MusicVO;

public class MusicInfoController implements Controller {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; utf-8");
		String musicId = request.getParameter("musicId");
		String memberId = request.getParameter("memberId");
		System.out.println(memberId);		
		MusicViewDAO music = new MusicViewDAO();
		MemberViewDAO memberDao=new MemberViewDAO();
		MusicVO obj = music.searchMusic(Integer.parseInt(musicId));
		MusicDetailBean m = new MusicDetailBean(obj.getMusicId(), obj.getMusicTitle(),obj.getImagePath(), 
				obj.getMemberId(), obj.getMemberNickName(), obj.getPlayTime(), obj.getMusicDate(),
				obj.getPlayCnt(),obj.getMusicIntro(), obj.getGenreName(),
				obj.getTagname(), obj.getLikeCnt(), false, false, obj.isVisibility(), obj.isDownAccept());//내 곡인지 아닌지와 좋아요 여부를 넣기 위한 빈.
		Object[] likes = music.searchLikeMusic(memberId);
		Object[] myMusic = music.searchMusic(memberId);
		
		if(likes!=null){// 좋아요 여부
			for(int i=0;i<likes.length;i++){
				if(((MusicVO)likes[i]).getMusicId() == obj.getMusicId()){
					 m.setLike(true);
				}
			}
		}
		
		if(myMusic!=null){
			for(int i=0;i<myMusic.length;i++){
				if(((MusicVO)myMusic[i]).getMusicId() == obj.getMusicId()){
					m.setMyMusic(true);
				}
			}
		}
		
		
		MemberVO membervo=memberDao.searchMember(memberId);
		String imagePath=memberDao.searchImagePath(memberId);
		System.out.println(imagePath);
		ProfileBean pr=new ProfileBean(membervo.getMemberId(), membervo.getMemberNickName(), membervo.getMemberIntro(),imagePath);
		request.setAttribute("music", m);
		request.setAttribute("member", pr);
		RequestDispatcher rd = request.getRequestDispatcher("musicinfo.jsp");
		rd.forward(request, response);
	}
	
}
