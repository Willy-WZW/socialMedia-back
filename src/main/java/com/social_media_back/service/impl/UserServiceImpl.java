package com.social_media_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.social_media_back.constant.ResMessage;
import com.social_media_back.repository.UserDao;
import com.social_media_back.service.ifs.UserService;
import com.social_media_back.vo.BasicRes;
import com.social_media_back.vo.CreateInfoReq;

@Service
public class UserServiceImpl implements UserService {
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Autowired
	private UserDao userDao;

	@Override
	public BasicRes createAccount(CreateInfoReq req) {
		String userPhone = req.getUserPhone();
		// phone已存在，回報錯誤
		if (userDao.existsByPhone(userPhone) > 0) {
			return new BasicRes(ResMessage.PHONENUMBEREXISTS.getCode(),//
					ResMessage.PHONENUMBEREXISTS.getMessage());
		}
		// 加密
		String encodePwd = encoder.encode(req.getUserPassword());
		req.setUserPassword(encodePwd);
		userDao.insertUserInfo(req.getUserName(), userPhone, req.getUserEmail(), encodePwd);
		return new BasicRes(ResMessage.SUCCESS.getCode(),ResMessage.SUCCESS.getMessage());
	}

}
