package com.social_media_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
public class SocialMediaBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaBackApplication.class, args);
	}

}
