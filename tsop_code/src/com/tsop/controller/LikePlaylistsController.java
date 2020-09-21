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
		
		/*���ǿ��� member id, request���� playlist id, ���ƿ� ���� ���´ٴ� ���� �Ͽ�*/
		
		String id="joonsung14";
		int playlistId=3;
		boolean isLike=true;
		
		JSONObject json = new JSONObject();
		
		PlaylistViewDAO dao=new PlaylistViewDAO();
		response.setContentType("text/plain");
		
		if(isLike){
			//�̹� ���ƿ� �� ��� ���ƿ� ����������
			
			int result=dao.deletePlaylistLike(playlistId, id);
			

			if(result==playlistId)
				json.put("likePlaylistResult",false);
			else
				json.put("error","������ ������ �ֽ��ϴ�.");
				
			
		}
		else{
			//���ƿ䰡 �ƴϸ� ���ƿ� �������
			int result=dao.addPlaylistLike(playlistId, id);
			
			if(result==playlistId)
				json.put("likePlaylistResult",true);
			else
				json.put("error","������ ������ �ֽ��ϴ�.");
			
		}
		
		response.getWriter().write(json.toString());
		
	}

}
