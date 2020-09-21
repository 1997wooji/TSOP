package com.tsop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.dao.MusicViewDAO;

public class LikeMusicController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;UTF-8");
		 Cookie[] cookies = request.getCookies();
	      String generatedId = null;
	      // 세션아이디/멤버아이디
	      for (Cookie cookie : cookies) {
	         if (cookie.getName().equals("generatedId")) {
	            generatedId = cookie.getValue();
	            break;
	         }
	      }
	      //멤버아이디 있다고 치고 UI에서도 like여부를 가지고있어야한다.
	      generatedId = "joonsung14";
	      boolean isLike = Boolean.parseBoolean(request.getParameter("isLike"));
	      int musicId = Integer.parseInt(request.getParameter("musicId"));
	      MusicViewDAO musicDAO = new MusicViewDAO();
	      
	      if(isLike){
	    	  int res = musicDAO.deleteLikeMusic(generatedId, musicId);
		      if(musicId != res){return ;}
		      response.getWriter().write("{'result': 'false'}");  
	      }else{
	    	  int res = musicDAO.addLikeMusic(generatedId, musicId);
		      System.out.println(res);
		      if(musicId != res){return ;}
		      response.getWriter().write("{'result': 'true'}"); 
	      }
	      
	      
	}
}
