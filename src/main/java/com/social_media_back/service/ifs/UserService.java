package com.social_media_back.service.ifs;

import com.social_media_back.entity.UserInfo;
import com.social_media_back.vo.BasicRes;
import com.social_media_back.vo.CheckPersonReq;
import com.social_media_back.vo.CreateInfoReq;
import com.social_media_back.vo.UpdateUserReq;
import com.social_media_back.vo.UserInfoReq;

public interface UserService {
	
	public BasicRes createAccount(CreateInfoReq req);
	
	public BasicRes checkPwdByPhone(CheckPersonReq req);
	
	public UserInfo selectUser(UserInfoReq req);
	
	public BasicRes updateUserInfo(UpdateUserReq req);
	
}
