package com.tsop.controller;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.dao.PlaylistViewDAO;
import org.json.simple.JSONObject;


public class LikePlaylistsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LikePlaylistsController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*세션에서 member id, request에서 playlist id, 좋아요 여부 꺼냈다는 전제 하에*/
		
		String id="joonsung14";
		int playlistId=3;
		boolean isLike=true;
		
		JSONObject json = new JSONObject();
		
		PlaylistViewDAO dao=new PlaylistViewDAO();
		response.setContentType("text/plain");
		
		if(isLike){
			//이미 좋아요 한 경우 좋아요 취소해줘야함
			
			int result=dao.deletePlaylistLike(playlistId, id);
			

			if(result==playlistId)
				json.put("likePlaylistResult",false);
			else
				json.put("error","서버에 문제가 있습니다.");
				
			
		}
		else{
			//좋아요가 아니면 좋아요 해줘야지
			int result=dao.addPlaylistLike(playlistId, id);
			
			if(result==playlistId)
				json.put("likePlaylistResult",true);
			else
				json.put("error","서버에 문제가 있습니다.");
			
		}
		
		response.getWriter().write(json.toString());
		
	}

}
