package com.social_media_back.service.ifs;

import com.social_media_back.vo.BasicRes;
import com.social_media_back.vo.NewCommentReq;

public interface CommentService {
	
	public BasicRes insertComment(NewCommentReq req);
	
}
