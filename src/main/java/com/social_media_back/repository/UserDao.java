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
	
	// 手機是否被註冊過
	@Query(value = "SELECT COUNT(1) FROM `user` WHERE phone = :userPhone", nativeQuery = true)
	public int existsByPhone(@Param("userPhone") String userPhone);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO `user` "
			+ " (user_name, phone, email, password)"
			+ " values "
			+ " (:userName, :userPhone, :userEmail, :userPassword)", nativeQuery = true)
	public int insertUserInfo(//
			@Param("userName") String userName,//
			@Param("userPhone") String userPhone,//
			@Param("userEmail") String userEmail,//
			@Param("userPassword") String userPassword);
	
	// 用手機找對應密碼
//	@Query(value = "SELECT password FROM user WHERE phone = :userPhone", nativeQuery = true)
//	public String checkPwd(@Param("userPhone") String userPhone);
	
	// Stored Procedure 做法
	@Query(value = "CALL GetPasswordByPhone(:phoneNumber)", nativeQuery = true)
	public String checkPwd(@Param("phoneNumber") String userPhone);
	
	// 取得 User 資料
	@Query(value = "SELECT * FROM `user` WHERE phone = :userPhone", nativeQuery = true)
	public UserInfo selectUser(@Param("userPhone")String userPhone);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE `user` "
			+ " SET "
			+ " user_name = :userName, "
			+ " cover_image = :coverImage, "
			+ " biography = :introduce "
			+ " WHERE "
			+ " user_id = :userId", nativeQuery = true)
	public int updateUserInfo(//
			@Param("userId") int userId,//
			@Param("userName") String userName,//
			@Param("coverImage") String coverImage, //
			@Param("introduce") String introduce);
	
	@Query(value = "SELECT COUNT(1) FROM `user` WHERE user_id = :userId", nativeQuery = true)
	public int existsById(@Param("userId") int userId);
	
	
	
	
	
	
	
	
	
	
}
