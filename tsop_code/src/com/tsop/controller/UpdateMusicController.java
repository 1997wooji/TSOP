package com.tsop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.dao.MusicViewDAO;

public class UpdateMusicController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;UTF-8");
		
		int musicId = Integer.parseInt((String)request.getParameter("musicId"));
		String musicTitle = request.getParameter("updateTitle");
		String musicIntro = request.getParameter("updateIntro");
		String tags = request.getParameter("updateTag");
		String imagePath = request.getParameter("imagePath");
		String genreName = request.getParameter("updateGenre");
		boolean musicVisibility = Boolean.parseBoolean((String)request.getAttribute("visibility"));
		boolean downloadAccept = Boolean.parseBoolean((String)request.getAttribute("downAccept"));
		System.out.println("musicId"+musicId+"/musicTitle"+musicTitle+"/musicInto"+musicIntro+"/tags"+tags+"/imagePath"+imagePath+"/genreName"+genreName);
		MusicViewDAO mvd = new MusicViewDAO();
		int res = mvd.updateMusic(musicId, musicTitle, musicIntro, imagePath, genreName, new String[]{tags}, musicVisibility, downloadAccept);
		request.setAttribute("musicId", musicId);
		RequestDispatcher rd = request.getRequestDispatcher("musicinfo.do");
		rd.forward(request, response);
	}
}
