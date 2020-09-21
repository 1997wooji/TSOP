package com.tsop.vo;

public class ImageVO {
	private int imageId;
	private String imagePath;
	
	public ImageVO(){
		
	}
	
	public ImageVO(int imageId, String imagePath) {
		super();
		this.imageId = imageId;
		this.imagePath = imagePath;
	}

	public int getImageId() {
		return imageId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "ImageVO [imageId=" + imageId + ", imagePath=" + imagePath + "]";
	}	
	
	
	
}
