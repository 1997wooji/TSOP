package com.tsop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.dao.TestFileDAO;
import com.tsop.dao.TestFolderDAO;
import com.tsop.util.HttpUtil;

public class DeleteFileController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		System.out.println(type);
		if (type.equals("folder")) {
			TestFolderDAO.dao.deleteFolder(Integer.parseInt(id));
		} else {
			TestFileDAO.dao.deleteFile(Integer.parseInt(id));
		}
		HttpUtil.forward(request, response, "cloud.do");
	}

}
