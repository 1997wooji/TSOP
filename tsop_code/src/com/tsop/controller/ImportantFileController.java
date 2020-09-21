package com.tsop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.dao.TestFileDAO;
import com.tsop.vo.FileVO;

public class ImportantFileController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fileId = request.getParameter("fileId");
		boolean important = Boolean.valueOf(request.getParameter("important"));
		System.out.println(fileId);
		System.out.println(important);
		response.setContentType("text/html;charset=utf-8");
		important = !important;
		FileVO file = TestFileDAO.dao.searchFile(Integer.parseInt(fileId));
		file.setFileImportant(important);
		response.getWriter().println("{'important' : '" + important + "'}");
		response.getWriter().close();
	}

}
