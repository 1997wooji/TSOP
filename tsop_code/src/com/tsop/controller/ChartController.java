package com.tsop.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.bean.MemberBean;
import com.tsop.bean.MusicBean;
import com.tsop.bean.PlaylistPrintBean;
import com.tsop.bean.PlaylistPrintBean2;
import com.tsop.dao.FollowViewDAO;
import com.tsop.dao.MusicViewDAO;
import com.tsop.dao.PlaylistViewDAO;
import com.tsop.vo.FollowVO;
import com.tsop.vo.MusicVO;
import com.tsop.vo.PlaylistVO;

public class ChartController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String job = request.getParameter("job");
		ArrayList<PlaylistPrintBean> playlists = null;
		ArrayList<MusicBean> musics = null;
		ArrayList<MemberBean> members = null;
		MusicViewDAO musicViewDAO = new MusicViewDAO();
		FollowViewDAO followViewDAO = new FollowViewDAO(); 
		PlaylistViewDAO playlistViewDAO = new PlaylistViewDAO();
		Object[] viewLists;
		RequestDispatcher rd;
		
		switch(job){
		case "playlist" : 	
			playlists = new ArrayList<PlaylistPrintBean>();
			viewLists = playlistViewDAO.searchTopLikePlaylist();
			
			
			//-------------------1.PlayList목록을 읽어 들여서 List에 추가하는 부분--------------
			for(Object playlist : viewLists){
				PlaylistVO playlistVO = (PlaylistVO)playlist;
				PlaylistPrintBean playlistBean = new PlaylistPrintBean();
				playlistBean.setImagePath(playlistVO.getImagePath());
				playlistBean.setMemberId(playlistVO.getMemberId());
				playlistBean.setMemberNickName(playlistVO.getMemberNickName());
				playlistBean.setPlaylistId(playlistVO.getPlaylistId());
				System.out.println("plyalistId=" + playlistVO.getPlaylistId());
				playlistBean.setPlaylistTitle(playlistVO.getPlaylistTitle());
				String filePath = playlistViewDAO.searchPlaylistFilePath(playlistVO.getPlaylistId());
			
				//---------------------2.PlayList에서 FilePath받아와서 Music ID 목록 추가하기 바꿔야댐---
				ArrayList<Integer> musicIds = new ArrayList<Integer>();
				musics = new ArrayList<MusicBean>();
				File file = new File(filePath);
				if(file.canRead()){
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					String line = br.readLine();
					while(line != null){
						StringTokenizer st = new StringTokenizer(line,"/");
						while(st.hasMoreTokens()){
							String token = st.nextToken();
							musicIds.add(Integer.parseInt(token));
						}
						line = br.readLine();
					}
				}//-----------------------2 End
				
				//----------------3.FilePath에서 읽어온 MusicID로 MusicBean추가하는 부분---------
				for(int musicId: musicIds){
					 MusicVO music = musicViewDAO.searchMusic(musicId);
					 MusicBean musicTemp = new MusicBean();
					 musicTemp.setMusicImagePath(music.getImagePath());
					 musicTemp.setMemberNickName(music.getMemberNickName());
					 musicTemp.setMemberId(music.getMemberId());
					 musicTemp.setMusicTitle(music.getMusicTitle());
					 musicTemp.setMusicId(music.getMusicId());
					 musics.add(musicTemp);
				}//---------------3 End
				playlistBean.setMusicList(musics);
				playlists.add(playlistBean);
			}//----------------1 End
			request.setAttribute("playlists", playlists);
			rd = request.getRequestDispatcher("playlistchart.jsp");
			rd.forward(request, response);
			break;
		case "track" :
			Object[] musicVOs = musicViewDAO.searchTopLikeMusic();
			musics = new ArrayList<MusicBean>();
	         boolean check = true;
	         
	         MusicBean temp = new MusicBean();
	         MusicVO tmp = (MusicVO)musicVOs[0]; 
	         temp.setMemberId(tmp.getMemberId());
	         temp.setMemberNickName(tmp.getMemberNickName());
	         temp.setMusicId(tmp.getMusicId());
	         temp.setMusicImagePath(tmp.getImagePath());
	         temp.setMusicTitle(tmp.getMusicTitle());
	         musics.add(temp);
	         
	         for(Object music : musicVOs){
	            check = true;
	            MusicVO musicVO = (MusicVO)music;
	            MusicBean musicBean = new MusicBean();
	            musicBean.setMemberId(musicVO.getMemberId());
	            musicBean.setMemberNickName(musicVO.getMemberNickName());
	            musicBean.setMusicId(musicVO.getMusicId());
	            musicBean.setMusicImagePath(musicVO.getImagePath());
	            musicBean.setMusicTitle(musicVO.getMusicTitle());
	            for(int i=0; i < musics.size(); i++){
	               if(musicBean.getMusicId() == musics.get(i).getMusicId()){
	                  check = false;
	               }
	            }
	            if(check) musics.add(musicBean);
	         }
			
			request.setAttribute("musics", musics);
			rd = request.getRequestDispatcher("musicchart.jsp");
			rd.forward(request, response);
			break;
			
		case "artist" :
			Object[] followVOs = followViewDAO.searchTopMember();
			
			members = new ArrayList<MemberBean>();
			if (followVOs != null) {
				for(Object followObj : followVOs){
					FollowVO followVO = (FollowVO)followObj;
					MemberBean memberBean = new MemberBean();
					memberBean.setImagePath(followVO.getImagePath());
					memberBean.setMemberId(followVO.getFollowId());
					memberBean.setMemberNickName(followVO.getNickName());
					members.add(memberBean);
				}
			}
			
			request.setAttribute("members", members);
			rd = request.getRequestDispatcher("artist.jsp");
			rd.forward(request, response);
			break;
			
		case "all" :
			playlists = new ArrayList<PlaylistPrintBean>();
			viewLists = playlistViewDAO.searchTopLikePlaylist();
			//-------------------1.PlayList목록을 읽어 들여서 List에 추가하는 부분--------------
			for(Object playlist : viewLists){
				PlaylistVO playlistVO = (PlaylistVO)playlist;
				PlaylistPrintBean playlistBean = new PlaylistPrintBean();
				playlistBean.setImagePath(playlistVO.getImagePath());
				playlistBean.setMemberId(playlistVO.getMemberId());
				playlistBean.setMemberNickName(playlistVO.getMemberNickName());
				playlistBean.setPlaylistId(playlistVO.getPlaylistId());
				System.out.println("plyalistId=" + playlistVO.getPlaylistId());
				playlistBean.setPlaylistTitle(playlistVO.getPlaylistTitle());
				playlists.add(playlistBean);
			}
			
			request.setAttribute("playlists", playlists);
			
			musicVOs = musicViewDAO.searchTopLikeMusic();
			
			musics = new ArrayList<MusicBean>();
			
			for(Object music : musicVOs){
				MusicVO musicVO = (MusicVO)music;
				MusicBean musicBean = new MusicBean();
				musicBean.setMemberId(musicVO.getMemberId());
				musicBean.setMemberNickName(musicVO.getMemberNickName());
				musicBean.setMusicId(musicVO.getMusicId());
				musicBean.setMusicImagePath(musicVO.getImagePath());
				musicBean.setMusicTitle(musicVO.getMusicTitle());
				musics.add(musicBean);
			}
			
			request.setAttribute("musics", musics);
			
			followVOs = followViewDAO.searchTopMember();
			
			members = new ArrayList<MemberBean>();
			
			for(Object followObj : followVOs){
				FollowVO followVO = (FollowVO)followObj;
				MemberBean memberBean = new MemberBean(); 
				memberBean.setImagePath(followVO.getImagePath());
				memberBean.setMemberId(followVO.getFollowId());
				memberBean.setMemberNickName(followVO.getNickName());
				members.add(memberBean);
			}
			
			request.setAttribute("members", members);
			
			rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
