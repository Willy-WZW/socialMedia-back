package com.social_media_back.constant;

public enum ResMessage {
	
	SUCCESS(200, "Success!"),//
	PHONENUMBEREXISTS(400, "Phone number exists !"),//
	PHONENUMBERNOTFOUND(404, "Phone number not found !"),//
	USERIDNOTFOUND(404, "User id not found !"),//
	WRONGPASSWORD(400, "Wrong password !"),//
	POSTIDNOTFOUND(404, "Post id not found !"),//
	PERMISSIONDENIED(403, "Permission Denied !"),//
	COMMENTCANNOTBENULLORBLANK(400, "Comment cannot be null or blank !");
	
	private int code;
	
	private String message;

	private ResMessage(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
}
