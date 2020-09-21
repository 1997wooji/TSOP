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
		
		/*���ǿ��� member id, request���� follow�� member id, �ȷο� ���� ���´ٴ� ���� �Ͽ�*/
		
		String id="jiwookkkk";
		String followId="leejingoo";
		boolean isFollowing=false;
		
		JSONObject json = new JSONObject();
		
		FollowViewDAO dao=new FollowViewDAO();
		response.setContentType("text/plain;charset=utf-8");
		
		if(isFollowing){
			//�̹� �ȷο� �� ��� �ȷο� ����������
			
			String result=dao.deleteFollow(followId, id);
			
			
			
			if(result==null)
				json.put("error","������ ������ �ֽ��ϴ�.");
			else
				json.put("followResult",false);
				
			
		}
		else{
			//�ȷο��� ��찡 �ƴ϶�� �ȷο� �����¡
			
			String result=dao.addFollow(followId, id);  //���� �ȷο��ϴ°� ����
			
			if(result==null)
				json.put("error","������ ������ �ֽ��ϴ�.");
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
