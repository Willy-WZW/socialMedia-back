package com.social_media_back.vo;

import javax.validation.constraints.NotBlank;

import com.social_media_back.entity.UserInfo;

public class CreateInfoReq extends UserInfo {

	public CreateInfoReq() {
		super();
	}

	public CreateInfoReq(int userId, @NotBlank(message = "User name cannot be null or empty !") String userName,
			@NotBlank(message = "Phone cannot be null or empty !") String userPhone,
			@NotBlank(message = "Email cannot be null or empty !") String userEmail,
			@NotBlank(message = "Password cannot be null or empty !") String userPassword) {
		super(userId, userName, userPhone, userEmail, userPassword);
	}
	
}
