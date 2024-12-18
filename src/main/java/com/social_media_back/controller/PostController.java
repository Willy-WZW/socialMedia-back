package com.social_media_back.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.social_media_back.service.ifs.PostService;
import com.social_media_back.vo.AllPostInfoRes;
import com.social_media_back.vo.BasicRes;
import com.social_media_back.vo.DeletePostReq;
import com.social_media_back.vo.EditPostReq;
import com.social_media_back.vo.NewPostReq;

@RestController
public class PostController {
	
	@Autowired
	private PostService postservice;
	
	@PostMapping(value = "post/create")
	public BasicRes insertPost(@Valid @RequestBody NewPostReq req) {
		return postservice.insertPost(req);
	}
	
	@GetMapping(value = "post/all")
	public List<AllPostInfoRes> selectAll(){
		return postservice.selectAll();
	}
	
	@PostMapping(value = "post/update")
	public BasicRes editPost(@Valid @RequestBody EditPostReq req) {
		return postservice.editPost(req);
	}
	
	@PostMapping(value = "post/delete")
	public BasicRes deletePost(@Valid @RequestBody DeletePostReq req) {
		return postservice.deletePost(req);
	}
	
}
