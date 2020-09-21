package com.tsop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.bean.ProfileBean;
import com.tsop.bean.SimpleMemberBean;
import com.tsop.dao.FollowViewDAO;
import com.tsop.dao.MemberViewDAO;
import com.tsop.vo.FollowVO;
import com.tsop.vo.MemberVO;

public class MemberFollowersController implements Controller {
	private static final long serialVersionUID = 1L;

    public MemberFollowersController() {
        super();

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/*������ member id ���´ٴ� ���� �Ͽ�*/
		
		String memberId=request.getParameter("memberId");
		if (memberId == null) {
			memberId="jiwookkkk";
		}
		
		FollowViewDAO dao=new FollowViewDAO();
		MemberViewDAO memberDao=new MemberViewDAO();
		
		List<SimpleMemberBean> list=new ArrayList<SimpleMemberBean>();
		Object[] objlist=dao.searchFollower(memberId);
		
		for(Object obj : objlist){
			
			FollowVO vo=(FollowVO)obj;
			list.add(new SimpleMemberBean(vo.getFollowerId(), vo.getNickName(), vo.getImagePath()));
			
		}
		
		MemberVO membervo=memberDao.searchMember(memberId);
		String imagePath=memberDao.searchImagePath(memberId);
		ProfileBean pr=new ProfileBean(membervo.getMemberId(), membervo.getMemberNickName(), membervo.getMemberIntro(),imagePath);

		request.setAttribute("followers", list);
		request.setAttribute("member", pr); //��� ��� ����������
		
		RequestDispatcher rp=request.getRequestDispatcher("memberfollower.jsp");
		rp.forward(request, response);
		
	}

}
