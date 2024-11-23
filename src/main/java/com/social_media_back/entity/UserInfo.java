package com.social_media_back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
public class UserInfo {
	
	@Id
	@Column(name = "user_id")
	private int userId;
	
	@NotBlank(message = "User name cannot be null or empty !")
	@Column(name = "user_name")
	private String userName;
	
	@NotBlank(message = "Phone cannot be null or empty !")
	@Column(name = "phone")
	private String userPhone;
	
	@NotBlank(message = "Email cannot be null or empty !")
	@Column(name = "email")
	private String userEmail;
	
	@NotBlank(message = "Password cannot be null or empty !")
	@Column(name = "password")
	private String userPassword;
	
	@Column(name = "cover_image")
	private String coverImage;
	
	@Column(name = "biography")
	private String introduce;

	public UserInfo() {
		super();
	}

	public UserInfo(int userId, @NotBlank(message = "User name cannot be null or empty !") String userName,
			@NotBlank(message = "Phone cannot be null or empty !") String userPhone,
			@NotBlank(message = "Email cannot be null or empty !") String userEmail,
			@NotBlank(message = "Password cannot be null or empty !") String userPassword, String coverImage,
			String introduce) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.coverImage = coverImage;
		this.introduce = introduce;
	}
	
	public UserInfo(int userId, @NotBlank(message = "User name cannot be null or empty !") String userName,
			@NotBlank(message = "Phone cannot be null or empty !") String userPhone,
			@NotBlank(message = "Email cannot be null or empty !") String userEmail,
			@NotBlank(message = "Password cannot be null or empty !") String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	
	
	
}
