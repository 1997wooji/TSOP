package com.tsop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddPlaylistMusicController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/JSON;UTF-8");
		String listId = request.getParameter("lId");
		String musicId = request.getParameter("mId");
		
		response.getWriter().write("{'res':'true'}");
	}
}
