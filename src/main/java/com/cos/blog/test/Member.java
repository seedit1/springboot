package com.cos.blog.test;


import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;



//@Getter
//@Setter
@Data // @Getter + @Setter
//@AllArgsConstructor // 생성자 
@NoArgsConstructor 
public class Member {
	private int id; //final :데이터의 불변성 
	private String username;
	private String password;
	private String email;
	
	@Builder
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}	
	public Member( String username, String password, String email) {		
		this.username = username;
		this.password = password;
		this.email = email;
	}	
}
