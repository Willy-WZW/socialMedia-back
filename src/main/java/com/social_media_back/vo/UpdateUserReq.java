package com.social_media_back.vo;

public class UpdateUserReq {
	
	private int userId;
	
	private String userName;
	
	private String coverImage;
	
	private String introduce;

	public UpdateUserReq() {
		super();
	}

	public UpdateUserReq(int userId, String userName, String coverImage, String introduce) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.coverImage = coverImage;
		this.introduce = introduce;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public String getIntroduce() {
		return introduce;
	}
	
}
