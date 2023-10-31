package com.cos.blog.test;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청 -> 응답(HTML 파일)
//@Controller

//사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {
	
	//인터넷브라우저요청은 무조건 get요청만 할수 있다. 
	//http://localhost:8080/http/get(select)
	@GetMapping("/http/get")
	public String getTest(Member m) { //id=1&username=1234&password=1234&email=ssar@nate.com
		return "get 요청 :" + m.getId() + ", " +m.getUsername() + "," + m.getPassword()+ ", " + m.getEmail();
	}
	
	//http://localhost:8080/http/post(insert)
	@PostMapping("/http/post")
	public String postTest(Member m) {
		return "post 요청 :"+ m.getId() + ", " +m.getUsername() + "," + m.getPassword()+ ", " + m.getEmail();
	}
	
	//http://localhost:8080/http/put(update)
	@PutMapping("/http/put")
	public String putTest() {
		return "put 요청";
	}
	
	//http://localhost:8080/http/delete(delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
