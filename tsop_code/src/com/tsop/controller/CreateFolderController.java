package com.tsop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.dao.TestFolderDAO;
import com.tsop.util.HttpUtil;
import com.tsop.vo.FolderVO;

public class CreateFolderController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String folderName = request.getParameter("folderName");
		String folderId = request.getParameter("folderId");
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println(folderName);
//		out.println(folderId);
		TestFolderDAO dao = TestFolderDAO.dao;
		FolderVO folder = new FolderVO();
		folder.setFolderId(2);
		folder.setFolderName(folderName);
		folder.setMemberId("qhdl0224");
		folder.setSuperFolderId(Integer.parseInt(folderId));
		dao.list.add(folder);
		HttpUtil.forward(request, response, "cloud.do");
	}

}
