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
		

		/*session���� member id, request���� playlist id, ������Ʈ ���� ���´ٴ� ���� �Ͽ�*/
		
		String id="jiwookkkk";
		int playlistId=3;
		boolean isRepost=true;
		
		JSONObject json = new JSONObject();
		
		PlaylistViewDAO dao=new PlaylistViewDAO();
		response.setContentType("text/plain");
		
		if(isRepost){
			//�̹� ���ƿ� �� ��� ���ƿ� ����������
			
			int result=dao.deletePlaylistRepost(playlistId, id);

			
			if(result==playlistId)
				json.put("repostPlaylistResult",false); //������Ʈ ���
			else
				json.put("error","������ ������ �ֽ��ϴ�.");
				
			
		}
		else{
			//������Ʈ�� �ƴϸ� ������Ʈ �������
			int result=dao.addPlaylistRepost(playlistId, id);
			
			if(result==playlistId)
				json.put("repostPlaylistResult",true);
			else
				json.put("error","������ ������ �ֽ��ϴ�.");
			
		}
		
		response.getWriter().write(json.toString());
		
		
	}

}
