package com.social_media_back.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.social_media_back.entity.UserInfo;

@Repository
public interface UserDao extends JpaRepository<UserInfo, Integer> {
	
	@Query(value = "SELECT COUNT(1) FROM user WHERE phone = :userPhone", nativeQuery = true)
	public int existsByPhone(@Param("userPhone") String userPhone);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO user "
			+ " (user_name, phone, email, password)"
			+ " values "
			+ " (:userName, :userPhone, :userEmail, :userPassword)", nativeQuery = true)
	public int insertUserInfo(//
			@Param("userName") String userName,//
			@Param("userPhone") String userPhone,//
			@Param("userEmail") String userEmail,//
			@Param("userPassword") String userPassword);
}
