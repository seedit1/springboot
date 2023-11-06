package com.cos.blog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

	@Autowired //DummyControllerTest 가 메모리에 뜰때  UserRepository 도  메모리에 띄워준다. 
	
	private UserRepository userRepository; // IoC( 의존성 주입)
	
	//{id}주소로 파라미터를 전달받을 수 있음.
	//http://localhost:8000/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		//user/4를 찾으면 내가 데이터베이스에서 못찾아오게 되면 user가 null  될것아냐?
		//그럼 return null이 리턴이 되자나.  그럼 프로그램에 문제가 있지 않겠니?
		//optional로 너의 User  객체를 감싸서 가져올테니 null인지 아닌지 판단해ㅐ서 return 해 !
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다. id : " + id);
            }
        });		
		return user;
	}
	
	//http://localhost:8000/blog/dummy/join(요청)
	//http의 body에 username, password, email 데이터를 가지고 요청
	@PostMapping("/dummy/join")
	public String join( User user) { /// key=value(약속된 규칙)
		System.out.println("id :"+ user.getId());
		System.out.println("username :"+ user.getUsername());
		System.out.println("password :"+ user.getPassword());
		System.out.println("email :"+ user.getEmail());
		System.out.println("role :"+ user.getRoll());
		System.out.println("createDate :"+ user.getCreateDate());
		
		user.setRoll(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
		
	}
}
