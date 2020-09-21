package com.tsop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tsop.util.HttpUtil;

public class LogInOutController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String job = request.getParameter("job");
		String loginId = request.getParameter("loginId");
		loginId="qhdl0224";
		
		if (job.equals("login")) {
			HttpSession session = request.getSession(true);
			if (!session.isNew()) {
				session.invalidate();
			}
			session = request.getSession(true);
			session.setAttribute("loginId", loginId);
			session.setAttribute("loginNickname", "지우공주");
			session.setAttribute("isFollow", false);
			Cookie co = new Cookie("loginNickname", "삼보일락");
			response.addCookie(co);
		} else if (job.equals("logout")) {
			HttpSession session = request.getSession(true);
			session.invalidate();
		}
		HttpUtil.forward(request, response, "/chart.do?job=all");
	}

}
