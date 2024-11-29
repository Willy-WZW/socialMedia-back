package com.social_media_back.service.ifs;

import java.util.List;

import com.social_media_back.vo.AllPostInfoRes;
import com.social_media_back.vo.BasicRes;
import com.social_media_back.vo.DeletePostReq;
import com.social_media_back.vo.EditPostReq;
import com.social_media_back.vo.NewPostReq;

public interface PostService {
	
	public BasicRes insertPost(NewPostReq req);
	
	public BasicRes editPost(EditPostReq req);
	
	public BasicRes deletePost(DeletePostReq req);
	
	public List<AllPostInfoRes> selectAll();
	
}
