package com.social_media_back.service.ifs;

import java.util.List;

import com.social_media_back.entity.PostInfo;
import com.social_media_back.vo.BasicRes;
import com.social_media_back.vo.NewPostReq;

public interface PostService {
	
	public BasicRes insertPost(NewPostReq req);
	
	public List<PostInfo> selectAll();
	
}
