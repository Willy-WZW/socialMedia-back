package com.social_media_back.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.social_media_back.service.ifs.UserService;
import com.social_media_back.vo.BasicRes;
import com.social_media_back.vo.CheckPersonReq;
import com.social_media_back.vo.CreateInfoReq;

@RestController
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping(value = "user/create")
	public BasicRes createAccount(@Valid @RequestBody CreateInfoReq req) {
		return userservice.createAccount(req);
	}
	
	@PostMapping(value = "user/login")
	public BasicRes checkPwdByPhone(@Valid @RequestBody CheckPersonReq req) {
		return userservice.checkPwdByPhone(req);
	}
	
}
