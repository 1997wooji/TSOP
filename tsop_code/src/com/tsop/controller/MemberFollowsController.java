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


public class MemberFollowsController implements Controller {


	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*페이지 member id 꺼냈다는 전제 하에*/
		
		String memberId=request.getParameter("memberId");
		if (memberId == null) {
			memberId="jiwookkkk";
		}
		
		System.out.println(memberId);
		
		FollowViewDAO dao=new FollowViewDAO();
		MemberViewDAO memberDao=new MemberViewDAO();
		List<SimpleMemberBean> list=new ArrayList<SimpleMemberBean>();
		Object[] objlist=dao.searchFollow(memberId);
		if (objlist != null) {
		for(Object obj : objlist){
			
			FollowVO vo=(FollowVO)obj;
			list.add(new SimpleMemberBean(vo.getFollowId(), vo.getNickName(), vo.getImagePath()));
			
		}
		}
		
		MemberVO membervo=memberDao.searchMember(memberId);
		String imagePath=memberDao.searchImagePath(memberId);
		ProfileBean pr=new ProfileBean(membervo.getMemberId(), membervo.getMemberNickName(), membervo.getMemberIntro(),imagePath);

		request.setAttribute("follows", list);
		request.setAttribute("member", pr); //어느 멤버 페이지인지
		System.out.println(list);
		System.out.println(pr);
		RequestDispatcher rp=request.getRequestDispatcher("memberfollow.jsp");
		rp.forward(request, response);
		
	}

}
