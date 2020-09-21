package com.tsop.bean;

public class FileBean {
	private int fileId;
	private String fileName;
	private String fileUpload;
	private String fileSize;
	private boolean fileImportant;
	private String fileImage;
	
	public FileBean() {
	}
	
	
	
	public FileBean(int fileId, String fileName, String fileUpload, String fileSize, boolean fileImportant, String fileImage) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.fileUpload = fileUpload;
		this.fileSize = fileSize;
		this.fileImportant = fileImportant;
		this.fileImage = fileImage;
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
	public String getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public boolean isFileImportant() {
		return fileImportant;
	}
	public void setFileImportant(boolean fileImportant) {
		this.fileImportant = fileImportant;
	}
	public String getFileImage() {
		return fileImage;
	}
	public void setFileImage(String fileImage) {
		this.fileImage = fileImage;
	}
	
	
}
