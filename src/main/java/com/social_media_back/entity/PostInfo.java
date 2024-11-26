package com.social_media_back.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "post")
public class PostInfo {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "post_id")
	private int postId;
	
	@NotNull(message = "User Id cannot be null !")
	@Column(name = "user_id")
	private int userId;
	
	@NotBlank(message = "Content cannot be null or empty!")
	@Column(name = "content")
	private String postContent;
	
	@Column(name = "pos_image")
	private String postImage;
	
	@Column(name = "create_at")
	private LocalDate createTime;

	public PostInfo() {
		super();
	}

	public PostInfo(int userId, String postContent, String postImage, LocalDate createTime) {
		super();
		this.userId = userId;
		this.postContent = postContent;
		this.postImage = postImage;
		this.createTime = createTime;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostImage() {
		return postImage;
	}

	public void setPostImage(String postImage) {
		this.postImage = postImage;
	}

	public LocalDate getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDate createTime) {
		this.createTime = createTime;
	}

	
	
}
