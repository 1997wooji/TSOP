package com.tsop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.dao.MusicViewDAO;

public class DeleteMusicController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;UTF-8");
		
		String id = "joonsung14";//로그인한 아이디임.
		int musicId = Integer.parseInt(request.getParameter("mId"));
		System.out.println("musicId:"+musicId);
		MusicViewDAO dao = new MusicViewDAO();
		dao.deleteMusic(musicId);
		RequestDispatcher rs = request.getRequestDispatcher("main.do");
		rs.forward(request, response);
	}
}
