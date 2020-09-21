package com.tsop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.tsop.util.ListFileRead;

public class PlayPlaylistController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int playlistId=Integer.parseInt(request.getParameter("playlistId"));
		System.out.println(playlistId);
		JSONObject json = new JSONObject();
		ListFileRead lfr=new ListFileRead();
		List<String> list= lfr.readPlaylistFile(playlistId);
		List<String> playlist=new ArrayList<String>();
		
		for(String str:list){
			
			String[] result=str.split("-");
			//만약에 musicId가 없어진 애일 경우 처리 해줘야함	
			playlist.add(result[1]);
	
		}
		
		response.setContentType("text/plain");
		json.put("list",playlist);
		response.getWriter().write(json.toString());
	}

}
