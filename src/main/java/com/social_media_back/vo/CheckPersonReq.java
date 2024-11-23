package com.social_media_back.vo;

import javax.validation.constraints.NotBlank;

public class CheckPersonReq {
	
	@NotBlank(message = "Phone cannot be null or empty !")
	private String phone;
	
	@NotBlank(message = "Password cannot be null or empty !")
	private String pwd;

	public CheckPersonReq() {
		super();
	}

	public CheckPersonReq(String phone, String pwd) {
		super();
		this.phone = phone;
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public String getPwd() {
		return pwd;
	}

	
	
}
