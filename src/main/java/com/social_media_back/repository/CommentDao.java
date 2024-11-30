package com.social_media_back.repository;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.social_media_back.entity.Comment;

@Repository
public interface CommentDao extends JpaRepository<Comment, Integer> {
	
	@Query(value = "SELECT EXISTS "
			+ " (SELECT 1 FROM comment c "
			+ " JOIN `user` u ON c.user_id = u.user_id "
			+ " WHERE c.user_id = :userId)", nativeQuery = true)
	public int existsByUserId(@Param("userId") int userId);
	
	@Query(value = "SELECT EXISTS "
			+ " (SELECT 1 FROM comment c "
			+ " JOIN post p ON c.post_id = p.post_id "
			+ " WHERE c.post_id = :postId)", nativeQuery = true)
	public int existsByPostId(@Param("postId") int postId);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO comment "
			+ " (user_id, post_id, content, created_at)"
			+ " value "
			+ " (:userId, :postId, :comContent, :comTime)", nativeQuery = true)
	public int insertComment(//
			@Param("userId") int userId,
			@Param("postId") int postId,
			@Param("comContent") String comContent,
			@Param("comTime") LocalDateTime comTime);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
