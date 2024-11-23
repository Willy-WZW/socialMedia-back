package com.social_media_back.service.ifs;

import com.social_media_back.vo.BasicRes;
import com.social_media_back.vo.CheckPersonReq;
import com.social_media_back.vo.CreateInfoReq;

public interface UserService {
	
	public BasicRes createAccount(CreateInfoReq req);
	
	public BasicRes checkPwdByPhone(CheckPersonReq req);
	
}
