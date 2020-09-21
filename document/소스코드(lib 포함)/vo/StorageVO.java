package com.tsop.vo;

public class StorageVO {
	
	private String memberId;
	private int maxStoreSize;
	private int totalFileSize;
	
	public StorageVO(){
		
	}

	public StorageVO(String memberId, int maxStoreSize, int totalFileSize) {
		super();
		this.memberId = memberId;
		this.maxStoreSize = maxStoreSize;
		this.totalFileSize = totalFileSize;
	}

	public String getMemberId() {
		return memberId;
	}

	public int getMaxStoreSize() {
		return maxStoreSize;
	}

	public int getTotalFileSize() {
		return totalFileSize;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setMaxStoreSize(int maxStoreSize) {
		this.maxStoreSize = maxStoreSize;
	}

	public void setTotalFileSize(int totalFileSize) {
		this.totalFileSize = totalFileSize;
	}

	@Override
	public String toString() {
		return "StorageVO [memberId=" + memberId + ", maxStoreSize=" + maxStoreSize + ", totalFileSize=" + totalFileSize
				+ "]";
	}
	
	
	
	
}
