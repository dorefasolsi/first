package com.mira.first.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	

	private String userId;
	private String userPw;
	private String userName;
	private String role;

	

}
