package com.tsop.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.bean.MusicBean;
import com.tsop.bean.PlaylistPrintBean2;
import com.tsop.bean.SimpleMemberBean;
import com.tsop.dto.LikeMusicDTO;
import com.tsop.dto.LikePlaylistDTO;
import com.tsop.dto.MemberDTO;
import com.tsop.util.HttpUtil;
import com.tsop.util.ListFileRead;

public class MemberLikesController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
System.out.println(request.getParameter("id")+"likes");
		
		MemberDTO memt=new MemberDTO();
		SimpleMemberBean smb=new SimpleMemberBean(memt.getMemberId(),memt.getMemberNickName(),memt.getImagePath(),memt.getMemberIntro());;
		request.setAttribute("member", smb);
		

		LikeMusicDTO lm=new LikeMusicDTO();
		System.out.println(lm.getMemberId()+"����"+lm.getMusicId()+"�� ���ƿ� �ϼ̽��ϴ�");
		LikePlaylistDTO lp=new LikePlaylistDTO();
		System.out.println(lp.getMemberId()+"����"+lp.getPlaylistId()+"�� ���ƿ� �ϼ̽��ϴ�");

		MusicBean mb=new MusicBean(lm.getMusicId(),"music title","./image/4.png", "�Խ��� ���̵�", "�г���",
			"�帣","�±׳���",5);
		
		List<MusicBean> musiclists= new ArrayList<MusicBean>();
		musiclists.add(mb);
		musiclists.add(mb);
		musiclists.add(mb);
		musiclists.add(mb);
		musiclists.add(mb);
		request.setAttribute("musiclists",musiclists);
		
		List<PlaylistPrintBean2> playlists=new ArrayList<PlaylistPrintBean2>();
		
		for(int i=1;i<=2;i++)
		{	PlaylistPrintBean2 plb=new PlaylistPrintBean2(i, "title", "./image/3.png","����� ID", "����� nickName","tag","introduction",LocalDateTime.now(),null);
			ListFileRead lfr=new ListFileRead();
			List<String> listObject=lfr.readPlaylistFile(i);
			List<MusicBean> musiclist=new ArrayList<MusicBean>();
			
			if(listObject != null){
				for(int j=0; j<listObject.size(); j++){
					System.out.println(listObject.get(j));
					String[] result=listObject.get(j).split("-");
					musiclist.add(new MusicBean(Integer.parseInt(result[0]),"title","./image/2.png","memberId","member","genre","tag",1));
					System.out.println(result[1]);
				}
			}
			plb.setMusicList(musiclist);
			playlists.add(plb);
	
		}
		
		/*���� �б�*/
		
		request.setAttribute("playlists", playlists);
		
		
		HttpUtil.forward(request, response, "./memberlike.jsp");
	}

}
