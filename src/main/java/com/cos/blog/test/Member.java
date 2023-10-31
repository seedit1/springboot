package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
@Data // @Getter + @Setter
@AllArgsConstructor // 생성자 
@NoArgsConstructor 
public class Member {
	private int id; //final :데이터의 불변성 
	private String username;
	private String password;
	private String email;	
}
