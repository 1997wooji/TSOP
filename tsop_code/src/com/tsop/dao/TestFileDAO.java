package com.tsop.dao;

import java.util.ArrayList;
import java.util.List;

import com.tsop.vo.FileVO;

public class TestFileDAO {
	public static TestFileDAO dao = new TestFileDAO();
	public List<FileVO> list;
	private TestFileDAO() {
		list = new ArrayList<FileVO>();
		
		FileVO file1 = new FileVO();
		file1.setFileId(1);
		file1.setFileExtension("mp3");
		file1.setFileImportant(true);
		file1.setFileName("intro");
		file1.setFileSize(3000);
		file1.setFileUploadDate("2018-07-19");
		file1.setFolderId(0);
		file1.setMemberId("qhdl0224");
		file1.setMemberNickname("¿ì¿èÆÐÆ®¸¯");
		
		FileVO file2 = new FileVO();
		file2.setFileId(2);
		file2.setFileExtension("mp3");
		file2.setFileImportant(false);
		file2.setFileName("ABC");
		file2.setFileSize(2800);
		file2.setFileUploadDate("2018-07-16");
		file2.setFolderId(0);
		file2.setMemberId("qhdl0224");
		file2.setMemberNickname("¿ì¿èÆÐÆ®¸¯");
		
		FileVO file3 = new FileVO();
		file3.setFileId(2);
		file3.setFileExtension("mp3");
		file3.setFileImportant(false);
		file3.setFileName("Hppay birth day");
		file3.setFileSize(2000);
		file3.setFileUploadDate("2018-07-12");
		file3.setFolderId(1);
		file3.setMemberId("qhdl0224");
		file3.setMemberNickname("¿ì¿èÆÐÆ®¸¯");
		
		list.add(file1);
		list.add(file2);
		list.add(file3);
	}
	
	public FileVO[] searchFiles(int folderId) {
		List<FileVO> result = new ArrayList<FileVO>();
		for (FileVO file : list) {
			if (file.getFolderId() == folderId) {
				result.add(file);
			}
		}
		FileVO[] files = new FileVO[result.size()];
		return result.toArray(files);
	}
	
	public FileVO searchFile(int fileId) {
		for (FileVO file : list) {
			if (file.getFileId() == fileId) {
				return file;
			}
		}
		return null;
	}
	
	public void deleteFile(int fileId) {
		int index = 0;
		for (FileVO file: list) {
			if (file.getFileId() == fileId) {
				list.remove(index);
				return;
			}
			index++;
		}
	}
}
