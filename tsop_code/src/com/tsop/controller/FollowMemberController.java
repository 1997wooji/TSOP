package com.tsop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.tsop.dao.FollowViewDAO;


public class FollowMemberController implements Controller {
	private static final long serialVersionUID = 1L;

    public FollowMemberController() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*세션에서 member id, request에서 follow할 member id, 팔로우 여부 꺼냈다는 전제 하에*/
		
		String id="jiwookkkk";
		String followId="leejingoo";
		boolean isFollowing=false;
		
		JSONObject json = new JSONObject();
		
		FollowViewDAO dao=new FollowViewDAO();
		response.setContentType("text/plain;charset=utf-8");
		
		if(isFollowing){
			//이미 팔로우 한 경우 팔로우 취소해줘야함
			
			String result=dao.deleteFollow(followId, id);
			
			
			
			if(result==null)
				json.put("error","서버에 문제가 있습니다.");
			else
				json.put("followResult",false);
				
			
		}
		else{
			//팔로우한 경우가 아니라면 팔로우 해줘야징
			
			String result=dao.addFollow(followId, id);  //내가 팔로우하는거 ㅇㅇ
			
			if(result==null)
				json.put("error","서버에 문제가 있습니다.");
			else
				json.put("followResult",true);
			
		}
		
//		response.getWriter().write(json.toString());
		String isFollow = request.getParameter("isFollow");
		System.out.println(isFollow);
		if (isFollow.equals("true")) {
			HttpSession session = request.getSession(false);
			if (session != null) {
			session.setAttribute("isFollow", false);
			response.getWriter().println("false");
			}
		} else {
			HttpSession session = request.getSession(false);
			if (session != null) {
			session.setAttribute("isFollow", true);
			response.getWriter().println("true");
			}
		}
	}

}
