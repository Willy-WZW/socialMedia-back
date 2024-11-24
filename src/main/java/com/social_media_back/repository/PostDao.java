package com.social_media_back.repository;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.social_media_back.entity.PostInfo;

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
			@Param("createTime") LocalDate createTime);
	
	@Query(value = "SELECT COUNT(1) FROM post WHERE user_id = :userId", nativeQuery = true)
	public int selectById(@Param("userId") int userId);
	
}
