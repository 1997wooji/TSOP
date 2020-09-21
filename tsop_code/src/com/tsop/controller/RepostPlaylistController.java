package com.tsop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.tsop.dao.PlaylistViewDAO;

public class RepostPlaylistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public RepostPlaylistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		/*session에서 member id, request에서 playlist id, 리포스트 여부 꺼냈다는 전제 하에*/
		
		String id="jiwookkkk";
		int playlistId=3;
		boolean isRepost=true;
		
		JSONObject json = new JSONObject();
		
		PlaylistViewDAO dao=new PlaylistViewDAO();
		response.setContentType("text/plain");
		
		if(isRepost){
			//이미 좋아요 한 경우 좋아요 취소해줘야함
			
			int result=dao.deletePlaylistRepost(playlistId, id);

			
			if(result==playlistId)
				json.put("repostPlaylistResult",false); //리포스트 취소
			else
				json.put("error","서버에 문제가 있습니다.");
				
			
		}
		else{
			//리포스트가 아니면 리포스트 해줘야지
			int result=dao.addPlaylistRepost(playlistId, id);
			
			if(result==playlistId)
				json.put("repostPlaylistResult",true);
			else
				json.put("error","서버에 문제가 있습니다.");
			
		}
		
		response.getWriter().write(json.toString());
		
		
	}

}
