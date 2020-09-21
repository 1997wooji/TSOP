package com.tsop.vo;

public class FileVO {
	private int fileId;
	private String fileName;
	private String memberId;
	private String memberNickname;
	private String fileUploadDate;
	private int fileSize;
	private boolean fileImportant;
	private String fileExtension;
	private int folderId;
	private int cnt;
	private int playTime;
	
	
	

	public FileVO() {
		super();
	}


	public FileVO(int fileId, String fileName, String memberId, String memberNickname, String fileUploadDate,
			int fileSize, boolean fileImportant, String fileExtension, int folderId, int cnt,int playTime) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.memberId = memberId;
		this.memberNickname = memberNickname;
		this.fileUploadDate = fileUploadDate;
		this.fileSize = fileSize;
		this.fileImportant = fileImportant;
		this.fileExtension = fileExtension;
		this.folderId = folderId;
		this.cnt = cnt;
		this.playTime = playTime;
		
	}


	public int getFileId() {
		return fileId;
	}


	public void setFileId(int fileId) {
		this.fileId = fileId;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getMemberNickname() {
		return memberNickname;
	}


	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}


	public String getFileUploadDate() {
		return fileUploadDate;
	}


	public void setFileUploadDate(String fileUploadDate) {
		this.fileUploadDate = fileUploadDate;
	}


	public int getFileSize() {
		return fileSize;
	}


	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}


	public boolean isFileImportant() {
		return fileImportant;
	}


	public void setFileImportant(boolean fileImportant) {
		this.fileImportant = fileImportant;
	}


	public String getFileExtension() {
		return fileExtension;
	}


	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}


	public int getFolderId() {
		return folderId;
	}


	public void setFolderId(int folderId) {
		this.folderId = folderId;
	}


	public int getPlayTime() {
		return playTime;
	}


	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}

	public int getCnt() {
		return cnt;
	}


	public void setCnt(int cnt) {
		this.cnt = cnt;
	}


	@Override
	public String toString() {
		return "FileVO [fileId=" + fileId + ", fileName=" + fileName + ", memberId=" + memberId + ", memberNickname="
				+ memberNickname + ", fileUploadDate=" + fileUploadDate + ", fileSize=" + fileSize + ", fileImportant="
				+ fileImportant + ", fileExtension=" + fileExtension + ", folderId=" + folderId + ", cnt=" + cnt
				+ ", playTime=" + playTime + "]";
	}


	
	
	
}
