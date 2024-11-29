package com.social_media_back.vo;

public class DeletePostReq {

	private int postId;
	
	private int userId;

	public DeletePostReq() {
		super();
	}

	public DeletePostReq(int postId, int userId) {
		super();
		this.postId = postId;
		this.userId = userId;
	}

	public int getPostId() {
		return postId;
	}

	public int getUserId() {
		return userId;
	}
	
}
