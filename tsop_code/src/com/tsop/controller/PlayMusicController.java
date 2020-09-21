package com.tsop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.tsop.bean.MusicBean;
import com.tsop.dao.FileViewDAO;
import com.tsop.dao.MusicViewDAO;
import com.tsop.vo.MusicVO;

public class PlayMusicController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      int musicId = Integer.parseInt(request.getParameter("musicId"));
	      JSONObject json = new JSONObject();
	      response.setContentType("text/html");
	   
	      MusicViewDAO musicViewDAO = new MusicViewDAO();
	      FileViewDAO fileViewDAO = new FileViewDAO();
	      
	      int fileId = musicViewDAO.searchMusicFileId(musicId);
	      String filePath = fileViewDAO.searchFilePath(fileId);
	      MusicVO musicVO = (MusicVO)musicViewDAO.searchMusic(musicId);
	      
	      MusicBean musicBean = new MusicBean();
	      musicBean.setMemberId(musicVO.getMemberId()); 
	      musicBean.setMemberNickName(musicVO.getMemberNickName());
	      musicBean.setMusicFilePath(filePath);
	      musicBean.setMusicId(musicVO.getMusicId());
	      musicBean.setMusicImagePath(musicVO.getImagePath());
	      musicBean.setMusicTitle(musicVO.getMusicTitle());
	      
	      response.setCharacterEncoding("UTF-8");
	      json.put("musicFilePath", filePath);
	      json.put("musicBean", musicBean);
	      json.put("imagePath", musicBean.getMusicImagePath());
	      System.out.println(json.toString());
	      response.getWriter().write(json.toString());
	}
}
