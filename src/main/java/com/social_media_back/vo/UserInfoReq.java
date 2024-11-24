package com.social_media_back.vo;

import javax.validation.constraints.NotBlank;

public class UserInfoReq {
	
	@NotBlank(message = "User name cannot be null or empty !")
	private String userPhone;

	public String getUserPhone() {
		return userPhone;
	}
	
}
