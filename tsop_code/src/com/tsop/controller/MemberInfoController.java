package com.tsop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.bean.MusicBean;
import com.tsop.bean.ProfileBean;
import com.tsop.dao.FileViewDAO;
import com.tsop.dao.MemberViewDAO;
import com.tsop.dao.MusicViewDAO;
import com.tsop.vo.MemberVO;
import com.tsop.vo.MusicVO;


public class MemberInfoController implements Controller {
	private static final long serialVersionUID = 1L;
       

    public MemberInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*member Id 받았다는 전제 하에*/
		
		String memberId=request.getParameter("memberId");
		if (memberId == null) {
			memberId="jiwookkkk";
		}
		
		MusicViewDAO musicdao=new MusicViewDAO();
		MemberViewDAO memberDao=new MemberViewDAO();
		FileViewDAO filedao=new FileViewDAO();
		
		Object[] objlist=musicdao.searchMusic(memberId);
		List<MusicBean> list=new ArrayList<MusicBean>();
		int fileId=0;
		
		for(Object obj : objlist){
			MusicVO vo=(MusicVO)obj;
			fileId=musicdao.searchMusicFileId(vo.getMusicId());
			String filePath=filedao.searchFilePath(fileId);
			MusicBean mb=new MusicBean(vo.getMusicId(),vo.getMusicTitle(), filePath,vo.getMemberNickName(),vo.getMemberId(),vo.getImagePath());
			list.add(mb);
		}
		

		MemberVO membervo=memberDao.searchMember(memberId);
		String imagePath=memberDao.searchImagePath(memberId);
		ProfileBean pr=new ProfileBean(membervo.getMemberId(), membervo.getMemberNickName(), membervo.getMemberIntro(),imagePath);
		request.setAttribute("member", pr); //어느 멤버 페이지인지
		request.setAttribute("musics", list);
		
		
		RequestDispatcher rd=request.getRequestDispatcher("membermusic.jsp");
		rd.forward(request, response);
	}

}
