package com.social_media_back.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social_media_back.constant.ResMessage;
import com.social_media_back.repository.CommentDao;
import com.social_media_back.service.ifs.CommentService;
import com.social_media_back.vo.BasicRes;
import com.social_media_back.vo.NewCommentReq;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Override
	public BasicRes insertComment(NewCommentReq req) {
		int userId = req.getUserId();
		int postId = req.getPostId();
		String comContent = req.getComContent();
		LocalDateTime comTime = req.getComTime();
		// userId 必須存在
		if (commentDao.existsByUserId(userId) == 0) {
			return new BasicRes(ResMessage.USERIDNOTFOUND.getCode(), ResMessage.USERIDNOTFOUND.getMessage());
		}

		// postId 必須存在
		if (commentDao.existsByPostId(postId) == 0) {
			return new BasicRes(ResMessage.POSTIDNOTFOUND.getCode(), ResMessage.POSTIDNOTFOUND.getMessage());
		}

		// content 不能為空
		if (comContent == null && comContent.isBlank()) {
			return new BasicRes(ResMessage.COMMENTCANNOTBENULLORBLANK.getCode(),//
					ResMessage.COMMENTCANNOTBENULLORBLANK.getMessage());
		}

		// comTime 為 null 時，轉換成現在時間
		if (comTime == null) {
			req.setComTime(LocalDateTime.now());
		}

		// 新增資料
		commentDao.insertComment(userId, postId, comContent, comTime);
		
		return new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage());
	}

}
