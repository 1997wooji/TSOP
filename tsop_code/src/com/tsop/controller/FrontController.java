package com.tsop.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/front")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String charset = null;
	HashMap<String,Controller>list = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();

	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig sc) throws ServletException {
		charset = sc.getInitParameter("charset");
		list = new HashMap<String, Controller>();
		list.put("/cloud.do", new CloudController());
		list.put("/createfolder.do", new CreateFolderController());
		list.put("/changename.do", new ChangeNameController());
		list.put("/importantfile.do", new ImportantFileController());
		list.put("/deletefile.do", new DeleteFileController());
		list.put("/main.do", new MainController());
		list.put("/chart.do", new ChartController());
		list.put("/memberinfo.do", new MemberInfoController());
		list.put("/memberplaylist.do", new MemberPlaylistsController());
		list.put("/memberfollows.do", new MemberFollowsController());
		list.put("/memberfollowers.do", new MemberFollowersController());
		list.put("/musicinfo.do", new MusicInfoController());
		list.put("/playlistinfo.do", new PlaylistInfoController());
		list.put("/search.do", new SearchController());
		list.put("/playmusic.do", new PlayMusicController());
		list.put("/likemusic.do", new LikeMusicController());
		list.put("/memberInfo.do", new MemberInfoController());
		list.put("/searchmylist.do", new SearchMylistController());
		list.put("/addplaylistmusic.do", new AddPlaylistMusicController());
		list.put("/updatemusic.do", new UpdateMusicController());
		list.put("/deletemusic.do", new DeleteMusicController());
		list.put("/loginout.do", new LogInOutController());
		list.put("/follow.do", new FollowMemberController());
		list.put("/download.do", new DownloadFileController());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(charset);
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		System.out.println(path);
		Controller subController = list.get(path);
		if (subController == null) {
			subController = list.get("/chart.do?job=all");
		}
		subController.execute(request, response);
	}

}
