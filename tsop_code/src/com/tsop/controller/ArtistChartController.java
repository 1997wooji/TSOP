package com.tsop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.dto.MemberDTO;
import com.tsop.util.HttpUtil;

public class ArtistChartController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<MemberDTO> members = new ArrayList<MemberDTO>();

		MemberDTO mem1 = new MemberDTO();
		members.add(mem1);
		MemberDTO mem2 = new MemberDTO();
		members.add(mem2);
		MemberDTO mem3 = new MemberDTO();
		members.add(mem3);
		MemberDTO mem4 = new MemberDTO();
		members.add(mem4);
		MemberDTO mem5 = new MemberDTO();
		members.add(mem5);
		MemberDTO mem6 = new MemberDTO();
		members.add(mem6);
		MemberDTO mem7 = new MemberDTO();
		members.add(mem7);
		MemberDTO mem8 = new MemberDTO();
		members.add(mem8);
		MemberDTO mem9 = new MemberDTO();
		members.add(mem9);
		MemberDTO mem10 = new MemberDTO();
		members.add(mem10);

		request.setAttribute("members", members);
		HttpUtil.forward(request, response, "./artist.jsp");
	}

}
