package com.tsop.bean;

public class StorageBean {
	private String maxSize;
	private String currentSize;
	private Integer sizePercent;
	private String memberId;
	
	public StorageBean() {
		maxSize = "10GB";
		currentSize = "1GB";
		sizePercent = 10;
		memberId = "gnsdl12396";
	}
	
	public String getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public String getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(String maxSize) {
		this.maxSize = maxSize;
	}
	public String getCurrentSize() {
		return currentSize;
	}
	public void setCurrentSize(String currentSize) {
		this.currentSize = currentSize;
	}

	public Integer getSizePercent() {
		return sizePercent;
	}

	public void setSizePercent(Integer sizePercent) {
		this.sizePercent = sizePercent;
	}
	
	
}
