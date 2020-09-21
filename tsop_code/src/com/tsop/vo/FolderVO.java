package com.tsop.vo;

public class FolderVO {
	
	private int folderId;
	private String folderName;
	private int superFolderId;
	private String memberId;
	
	public FolderVO(){
		
	}
	
	public FolderVO(int folderId, String folderName, int superFolderId, String memberId) {
		super();
		this.folderId = folderId;
		this.folderName = folderName;
		this.superFolderId = superFolderId;
		this.memberId = memberId;
	}

	public int getFolderId() {
		return folderId;
	}

	public String getFolderName() {
		return folderName;
	}

	public int getSuperFolderId() {
		return superFolderId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setFolderId(int folderId) {
		this.folderId = folderId;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public void setSuperFolderId(int superFolderId) {
		this.superFolderId = superFolderId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	

}
