package com.tsop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.bean.MusicInfo;
import com.tsop.dto.MusicDTO;
import com.tsop.util.HttpUtil;

public class MusicChartController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MusicDTO dto =  MusicDTO.getInstance();
		MusicInfo music = new MusicInfo(dto.getMusicId(), dto.getMusicTitle(), dto.getMusicIntro(), 
				dto.getTagName(), dto.getGenreName(), dto.getMemberId(), dto.getMemberNickName(), 
				dto.getImagePath(), dto.getLikeCnt(), dto.getPlayCnt(), dto.isVisibility(), dto.isDownloadAccept());
		List<MusicInfo> musics = new ArrayList<MusicInfo>();
		musics.add(music);
		musics.add(music);
		musics.add(music);
		musics.add(music);
		musics.add(music);
		musics.add(music);
		musics.add(music);
		request.setAttribute("musics", musics);
		request.setAttribute("selectedMenu", "chart");
		HttpUtil.forward(request, response, "./musicchart.jsp");
	}

}
