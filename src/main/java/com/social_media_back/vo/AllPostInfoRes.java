package com.social_media_back.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AllPostInfoRes {
	
	private int postId;
	
	private int userId;
	
	private String userName;
	
	private String postContent;
	
	private String postImage;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime;

	public AllPostInfoRes() {
		super();
	}

	public AllPostInfoRes(int postId, int userId, String userName, String postContent, String postImage,
			LocalDateTime createTime) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.userName = userName;
		this.postContent = postContent;
		this.postImage = postImage;
		this.createTime = createTime;
	}

	public int getPostId() {
		return postId;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getPostContent() {
		return postContent;
	}

	public String getPostImage() {
		return postImage;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}
	
}
