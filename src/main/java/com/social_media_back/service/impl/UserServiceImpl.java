package com.social_media_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.social_media_back.constant.ResMessage;
import com.social_media_back.entity.UserInfo;
import com.social_media_back.repository.UserDao;
import com.social_media_back.service.ifs.UserService;
import com.social_media_back.vo.BasicRes;
import com.social_media_back.vo.CheckPersonReq;
import com.social_media_back.vo.CreateInfoReq;
import com.social_media_back.vo.UpdateUserReq;
import com.social_media_back.vo.UserInfoReq;

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

	@Override
	public BasicRes checkPwdByPhone(CheckPersonReq req) {
		String userPhone = req.getPhone();
		// 手機沒被註冊
		if (userDao.existsByPhone(userPhone) == 0) {
			return new BasicRes(ResMessage.PHONENUMBERNOTFOUND.getCode(),//
					ResMessage.PHONENUMBERNOTFOUND.getMessage());
		}
		// 比對密碼
		String pwd = userDao.checkPwd(userPhone);
		// 密碼錯誤情況
		if (!encoder.matches(req.getPwd(), pwd)) {
			return new BasicRes(ResMessage.WRONGPASSWORD.getCode(),//
					ResMessage.WRONGPASSWORD.getMessage());
		}
		return new BasicRes(ResMessage.SUCCESS.getCode(),ResMessage.SUCCESS.getMessage());
	}

	@Override
	public UserInfo selectUser(UserInfoReq req) {
		return userDao.selectUser(req.getUserPhone());
	}

	@Override
	public BasicRes updateUserInfo(UpdateUserReq req) {
		int userId = req.getUserId();
		// userId 不存在
		if (userDao.existsById(userId) == 0) {
			return new BasicRes(ResMessage.USERIDNOTFOUND.getCode(),//
					ResMessage.USERIDNOTFOUND.getMessage());
		}
		
		userDao.updateUserInfo(userId, req.getUserName(), req.getCoverImage(), req.getIntroduce());
		return new BasicRes(ResMessage.SUCCESS.getCode(),ResMessage.SUCCESS.getMessage());
	}

}
