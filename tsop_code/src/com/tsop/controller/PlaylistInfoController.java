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
import com.tsop.bean.PlaylistPrintBean2;
import com.tsop.bean.ProfileBean;
import com.tsop.dao.MemberViewDAO;
import com.tsop.dao.MusicViewDAO;
import com.tsop.dao.PlaylistViewDAO;
import com.tsop.util.HttpUtil;
import com.tsop.util.ListFileRead;
import com.tsop.vo.MemberVO;
import com.tsop.vo.MusicVO;
import com.tsop.vo.PlaylistVO;


public class PlaylistInfoController implements Controller {
	private static final long serialVersionUID = 1L;
       

    public PlaylistInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*playlist id 받았다는 전제 하에*/
		int playlistId=3;
		MemberViewDAO memberDao = new MemberViewDAO();
		playlistId = Integer.parseInt(request.getParameter("playlistId"));
		String memberId = request.getParameter("memberId");
		
		PlaylistViewDAO playlistdao=new PlaylistViewDAO();
		MusicViewDAO musicdao=new MusicViewDAO();
		
		PlaylistVO vo=playlistdao.searchPlaylist(playlistId);
		
		PlaylistBean pb=new PlaylistBean(vo.getPlaylistId(), vo.getPlaylistTitle(), vo.getImagePath(),vo.getMemberId(), vo.getMemberNickName(),vo.getTagName(),vo.getPlaylistIntro(),vo.getPlaylistDate());

		ListFileRead lfr=new ListFileRead();
		List<String> listObject=lfr.readPlaylistFile(playlistId);
		List<MusicBean> musiclist=new ArrayList<MusicBean>();

		if (listObject != null) {
			for(int i=0; i<listObject.size(); i++){
				System.out.println(listObject.get(i));
				String[] result=listObject.get(i).split("-");
				MusicVO mv=musicdao.searchMusic(Integer.parseInt(result[0]));
				
				musiclist.add(new MusicBean(mv.getMusicId(), mv.getMusicTitle(), result[1], mv.getMemberNickName(),mv.getMemberId(), mv.getImagePath()));
				
			}
		} else {
			for(int i=0; i<5; i++){
				MusicVO mv=musicdao.searchMusic(i+1);
				musiclist.add(new MusicBean(mv.getMusicId(), mv.getMusicTitle(), "tsop/audio/10.mp3", mv.getMemberNickName(),mv.getMemberId(), mv.getImagePath()));
			}
		}
		
		PlaylistPrintBean2 prb=new PlaylistPrintBean2(pb,musiclist);
		MemberVO membervo=memberDao.searchMember(memberId);
		String imagePath=memberDao.searchImagePath(memberId);
		ProfileBean pr=new ProfileBean(membervo.getMemberId(), membervo.getMemberNickName(), membervo.getMemberIntro(),imagePath);
		request.setAttribute("member", pr);
		request.setAttribute("playlist", prb.getPlaylist());
		request.setAttribute("list", prb.getMusicList());

		HttpUtil.forward(request, response, "playlistinfo.jsp");

	
		
	}

}
