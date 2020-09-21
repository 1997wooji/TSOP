package com.tsop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LikePlaylistController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;UTF-8");
		
		String like1 = request.getParameter("like1");
		
		if(like1.equals("0"))
			response.getWriter().print("{'like1':'"+1+"'}");
		else{
			response.getWriter().print("{'like1':'"+0+"'}");
		}
	}

}
