package com.social_media_back.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.social_media_back.service.ifs.PostService;
import com.social_media_back.vo.BasicRes;
import com.social_media_back.vo.NewPostReq;

@RestController
public class PostController {
	
	@Autowired
	private PostService postservice;
	
	@PostMapping(value = "post/create")
	public BasicRes insertPost(@Valid @RequestBody NewPostReq req) {
		return postservice.insertPost(req);
	}
	
}