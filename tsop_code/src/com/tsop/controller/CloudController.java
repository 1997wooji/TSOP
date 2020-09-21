package com.tsop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsop.bean.FileBean;
import com.tsop.bean.FolderBean;
import com.tsop.bean.StorageBean;
import com.tsop.dao.FolderDAO;
import com.tsop.dao.StorageViewDAO;
import com.tsop.dao.TestFileDAO;
import com.tsop.dao.TestFolderDAO;
import com.tsop.util.HttpUtil;
import com.tsop.vo.FileVO;
import com.tsop.vo.FolderVO;
import com.tsop.vo.StorageVO;

public class CloudController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberId = "qhdl0224";
		
		String folderId = request.getParameter("folderId");
		String job = request.getParameter("job");
		if (folderId != null) {
			folderId =folderId.trim();
		}
		
		if (job != null) {
			job = job.trim();
		}

		if (job == null || job.equals("")) {
			job = "down";
		}
		
		int id = 0;		
		if (job.equals("down")) {
			if (folderId != null || id < 0) {
				id = Integer.valueOf(folderId);
			}
		}
			
		else if (job.equals("up")) {
			FolderDAO fd = new FolderDAO();
			FolderVO fv = fd.searchFolder(id);
			id = fv.getSuperFolderId();
		}
		
		TestFileDAO fvd = TestFileDAO.dao;
		FileVO[] natureFiles = (FileVO[])fvd.searchFiles(id);
		System.out.println(Arrays.deepToString(natureFiles));
		System.out.println(natureFiles[0]);
		FileBean[] files = new FileBean[natureFiles.length];
		for (int i = 0; i < natureFiles.length; i++) {
			FileBean file = new FileBean();
			FileVO origin = natureFiles[i];
			if (origin == null) {
				continue;
			}
			System.out.println(origin);
			file.setFileId(origin.getFileId());
			file.setFileImportant(origin.isFileImportant());
			file.setFileName(origin.getFileName());
			double size = origin.getFileSize();
			String fileSize = null;
			if (size >999999) {
				size = size / 1000000;
				fileSize = String.valueOf(size) + "GB";
			} else if(size > 999) {
				size = size / 1000;
				fileSize = String.valueOf(size) + "MB";
			} else {
				fileSize = String.valueOf(size) + "KB";
			}
			
			file.setFileSize(fileSize);
			file.setFileUpload(origin.getFileUploadDate());
			files[i] = file;
		}
		
		request.setAttribute("files", files);
		
		TestFolderDAO fd =  TestFolderDAO.dao;
		Object[] originFolders = fd.searchFolder(id);
		List<FolderBean> folders = new ArrayList<FolderBean>();
		for (int i = 0; i < originFolders.length; i++) {					
			FolderVO origin = (FolderVO)originFolders[i];
			if (origin.getSuperFolderId() == id) {
				FolderBean folder = new FolderBean();
				folder.setFolderId(origin.getFolderId());
				folder.setFolderName(origin.getFolderName());
				folders.add(folder);
			}
		}
		
		FolderBean[] result = new FolderBean[folders.size()];
		request.setAttribute("folders", folders.toArray(result));
		
		StorageViewDAO svd = new StorageViewDAO();
		StorageVO storageOrigin = svd.searchStorage(memberId);
		StorageBean sb = new StorageBean();
		int totalSize = storageOrigin.getTotalFileSize();
		double currentSize = totalSize;
		String currentSizeStr = null; 
		if (currentSize > 999999) {
			currentSize = currentSize / 1000000;
			currentSizeStr = String.valueOf(currentSize) + "GB";
		} else if (currentSize > 999) {
			currentSize = currentSize / 1000;
			currentSizeStr = String.valueOf(currentSize) + "MB";
		} else {
			currentSizeStr = String.valueOf(currentSize) + "KB";
		}
		
		sb.setCurrentSize(currentSizeStr);
		sb.setMaxSize(String.valueOf(storageOrigin.getMaxStoreSize()) + "GB");
		sb.setMemberId(memberId);
		int percentage = storageOrigin.getTotalFileSize() / (storageOrigin.getMaxStoreSize() * 1000000);
		sb.setSizePercent(percentage);
		
		request.setAttribute("storageInfo", sb);
		request.setAttribute("pathId", id);
		
		
		HttpUtil.forward(request, response, "./cloud.jsp");
	}
}