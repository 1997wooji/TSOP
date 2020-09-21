package com.tsop.dao;

import java.util.ArrayList;
import java.util.List;

import com.tsop.vo.FolderVO;

public class TestFolderDAO {
	public static TestFolderDAO dao = new TestFolderDAO();
	public List<FolderVO> list;
	private TestFolderDAO() {
		list = new ArrayList<FolderVO>();
		FolderVO folder1 = new FolderVO();
		folder1.setFolderId(1);
		folder1.setFolderName("좋은 노래");
		folder1.setMemberId("qhdl0224");
		folder1.setSuperFolderId(0);
		list.add(folder1);
	}
	
	public FolderVO[] searchFolder(int folderId) {
		List<FolderVO> result = new ArrayList<FolderVO>();
		for(FolderVO folder : list) {
			if(folder.getSuperFolderId() == folderId) {
				result.add(folder);
			}
		}
		
		FolderVO[] folders = new FolderVO[result.size()];
		return result.toArray(folders);
	}
	
	public FolderVO searchFolderById(int folderId) {
		for(FolderVO folder : list) {
			if (folder.getFolderId() == folderId) {
				return folder;
			}
		}
		return null;
	}
	
	public void deleteFolder(int folderId) {
		int index = 0;
		for (FolderVO folder: list) {
			if (folder.getFolderId() == folderId) {
				list.remove(index);
				return;
			}
			index++;
		}
	}
}
