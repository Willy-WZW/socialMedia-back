package com.social_media_back.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "comment")
public class Comment {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "comment_id", nullable = false, updatable = false)
	private int commentId;
	
	@Column(name = "user_id", nullable = false)
	private int userId;
	
	@Column(name = "post_id", nullable = false)
	private int postId;
	
	@Column(name = "content", nullable = false)
	private String comContent;
	
	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime comTime;

	public Comment() {
		super();
	}

	public Comment(int userId, int postId, String comContent, LocalDateTime comTime) {
		super();
		this.userId = userId;
		this.postId = postId;
		this.comContent = comContent;
		this.comTime = comTime;
	}

	public int getCommentId() {
		return commentId;
	}

	public int getUserId() {
		return userId;
	}

	public int getPostId() {
		return postId;
	}

	public String getComContent() {
		return comContent;
	}

	public LocalDateTime getComTime() {
		return comTime;
	}

	public void setComTime(LocalDateTime comTime) {
		this.comTime = comTime;
	}
	
}
