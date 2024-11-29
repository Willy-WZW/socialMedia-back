package com.social_media_back.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.social_media_back.entity.PostInfo;
import com.social_media_back.vo.AllPostInfoRes;

@Repository
public interface PostDao extends JpaRepository<PostInfo, Integer> {
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO post "
			+ " (user_id, content, post_image, created_at) "
			+ " value "
			+ " (:userId, :postContent, :postImage, :createTime)", nativeQuery = true)
	public int insertPost(//
			@Param("userId") int userId, //
			@Param("postContent") String postContent, //
			@Param("postImage") String postImage, //
			@Param("createTime") LocalDateTime createTime);
	
	@Query(value = "SELECT COUNT(1) FROM post WHERE user_id = :userId", nativeQuery = true)
	public int selectById(@Param("userId") int userId);
	
	@Query(value = "SELECT "
			+ " new com.social_media_back.vo.AllPostInfoRes( p.postId, p.userId, u.userName, p.postContent, p.postImage, p.createTime )"
			+ " FROM PostInfo p "
			+ " JOIN UserInfo u "
			+ " ON p.userId = u.userId "
			+ " ORDER BY p.createTime DESC")
	public List<AllPostInfoRes> selectAllPost();
	
	@Query(value = "SELECT EXISTS "
			+ " (SELECT 1 FROM post WHERE post_id = :postId)", nativeQuery = true)
	public int selectPostId(@Param("postId") int postId);
	
	@Query(value = "SELECT EXISTS"
			+ " (SELECT 1 "
			+ " FROM post p "
			+ " JOIN `user` u ON p.user_id = u.user_id "
			+ " WHERE p.post_id = :postId AND u.user_id = :userId)", nativeQuery = true)
	public int matchingUserId (@Param("postId") int postId, @Param("userId") int userId);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE post "
			+ " SET "
			+ " content = :postContent, "
			+ " post_image = :postImage, "
			+ " created_at = :createTime "
			+ " WHERE "
			+ " post_id = :postId", nativeQuery = true)
	public int updatePostContent (//
			@Param("postId") int postId, //
			@Param("postContent") String postContent, //
			@Param("postImage") String postImage, //
			@Param("createTime") LocalDateTime createTime);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM post WHERE post_id = :postId", nativeQuery = true)
	public int deletePost(@Param("postId") int postId);
	
}
