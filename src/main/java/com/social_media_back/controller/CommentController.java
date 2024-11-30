package com.social_media_back.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.social_media_back.service.ifs.CommentService;
import com.social_media_back.vo.BasicRes;
import com.social_media_back.vo.NewCommentReq;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping(value = "comment/insert")
	public BasicRes insertComment(@Valid @RequestBody NewCommentReq req) {
		return commentService.insertComment(req);
	}

}
