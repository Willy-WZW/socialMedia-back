package com.social_media_back.service.impl;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social_media_back.constant.ResMessage;
import com.social_media_back.repository.PostDao;
import com.social_media_back.repository.UserDao;
import com.social_media_back.service.ifs.PostService;
import com.social_media_back.vo.BasicRes;
import com.social_media_back.vo.NewPostReq;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDao postDao;
	
	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public BasicRes insertPost(NewPostReq req) {
		int userId = req.getUserId();
		// 發文者Id不存在
		if (userDao.existsById(userId) == 0) {
			return new BasicRes(ResMessage.USERIDNOTFOUND.getCode(),ResMessage.USERIDNOTFOUND.getMessage());
		}
		
		// 前端發文時間沒進來，設置現在時間
		if (req.getCreateTime() == null) {
			req.setCreateTime(LocalDate.now());
		}
		postDao.insertPost(userId, req.getPostContent(), req.getPostImage(), req.getCreateTime());
		return new BasicRes(ResMessage.SUCCESS.getCode(),ResMessage.SUCCESS.getMessage());
	}
	
	
	
}
