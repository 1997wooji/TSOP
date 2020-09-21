package com.tsop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.dao.TestFileDAO;
import com.tsop.dao.TestFolderDAO;
import com.tsop.util.HttpUtil;
import com.tsop.vo.FileVO;
import com.tsop.vo.FolderVO;

public class ChangeNameController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String id = request.getParameter("id");

		if (type.equals("folder")) {
			FolderVO folder = TestFolderDAO.dao.searchFolderById(Integer.parseInt(id));
			folder.setFolderName(name);
		} else {
			FileVO file = TestFileDAO.dao.searchFile(Integer.parseInt(id));
			file.setFileName(name);
		}
		HttpUtil.forward(request, response, "cloud.do");
		
	}

}
