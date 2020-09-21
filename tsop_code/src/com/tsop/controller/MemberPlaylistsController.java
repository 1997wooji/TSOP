package com.tsop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.bean.MusicBean;
import com.tsop.bean.PlaylistBean;
import com.tsop.bean.PlaylistPrintBean;
import com.tsop.bean.PlaylistPrintBean2;
import com.tsop.bean.ProfileBean;
import com.tsop.dao.MemberViewDAO;
import com.tsop.dao.MusicViewDAO;
import com.tsop.dao.PlaylistViewDAO;
import com.tsop.util.ListFileRead;
import com.tsop.vo.MemberVO;
import com.tsop.vo.MusicVO;
import com.tsop.vo.PlaylistVO;


public class MemberPlaylistsController implements Controller {
	private static final long serialVersionUID = 1L;
       

    public MemberPlaylistsController() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		/*member Id 받았다는 전제 하에*/
		String memberId=request.getParameter("memberId");
		if (memberId == null) {
			memberId = "qhdl0224";
		}
		
		PlaylistViewDAO playlistdao=new PlaylistViewDAO();
		MusicViewDAO musicdao=new MusicViewDAO();
		MemberViewDAO memberDao=new MemberViewDAO();
		
		Object[] objlist=playlistdao.searchPlaylist(memberId);
		List<PlaylistPrintBean2> list=new ArrayList<PlaylistPrintBean2>();
		
		System.out.println(objlist.length);
		
		for(Object obj : objlist){
			PlaylistVO vo=(PlaylistVO)obj;
			PlaylistBean pb=new PlaylistBean(vo.getPlaylistId(), vo.getPlaylistTitle(), vo.getImagePath(),vo.getMemberId(), vo.getMemberNickName(),vo.getTagName(),vo.getPlaylistIntro(),vo.getPlaylistDate());
			
			System.out.println(vo.getPlaylistId());
			
			ListFileRead lfr=new ListFileRead();
			List<String> listObject=lfr.readPlaylistFile(vo.getPlaylistId());
			List<MusicBean> musiclist=new ArrayList<MusicBean>();
			
			System.out.println(listObject.size());
			
			for(int i=0; i<listObject.size(); i++){
				System.out.println(listObject.get(i));
				String[] result=listObject.get(i).split("-");
				MusicVO mv=musicdao.searchMusic(Integer.parseInt(result[0]));
				
				musiclist.add(new MusicBean(mv.getMusicId(), mv.getMusicTitle(), result[1], mv.getMemberNickName(),mv.getMemberId(), mv.getImagePath()));
				
			}
			
			list.add(new PlaylistPrintBean2(pb,musiclist));
			
		}
		
		MemberVO membervo=memberDao.searchMember(memberId);
		String imagePath=memberDao.searchImagePath(memberId);
		ProfileBean pr=new ProfileBean(membervo.getMemberId(), membervo.getMemberNickName(), membervo.getMemberIntro(),imagePath);


		request.setAttribute("member", pr); //어느 멤버 페이지인지
		request.setAttribute("playlists", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("memberplaylist.jsp");
		rd.forward(request, response);

		
	}

}
