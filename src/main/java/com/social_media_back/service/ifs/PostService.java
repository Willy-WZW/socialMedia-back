package com.social_media_back.service.ifs;

import com.social_media_back.vo.BasicRes;
import com.social_media_back.vo.NewPostReq;

public interface PostService {
	
	public BasicRes insertPost(NewPostReq req);
	
}
