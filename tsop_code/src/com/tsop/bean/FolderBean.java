package com.tsop.bean;

public class FolderBean {
	private int folderId;
	private String folderName;
	private String folderPath;
	private String folderImage;
	
	public FolderBean() {
		
	}
	
	public FolderBean(int folderId, String folderName, String folderPath, String folderImage) {
		super();
		this.folderId = folderId;
		this.folderName = folderName;
		this.folderPath = folderPath;
		this.folderImage = folderImage;
	}
	
	
	
	public int getFolderId() {
		return folderId;
	}

	public void setFolderId(int folderId) {
		this.folderId = folderId;
	}

	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public String getFolderPath() {
		return folderPath;
	}
	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}
	public String getFolderImage() {
		return folderImage;
	}
	public void setFolderImage(String folderImage) {
		this.folderImage = folderImage;
	}
	
	
}
