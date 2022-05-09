package org.zerock.controller.ex02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex04")
public class Ex04Controller {
	
	@RequestMapping("sub01")
	public void method1(HttpServletRequest request) {
		System.out.println("/ex05/sub01 요청");
		// 1. request parameter 수집 / 가공
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("age"));
		// 2. 비즈니스 로직 실행
		// 3. add attribute
		// 4. forward / redirect
		
	}
	// Handler method : @RequestMapping 어노테이션이 붙은 메소드
	// @RequestParam
	@RequestMapping("sub02")
	public void method02(@RequestParam("name") String n) { 
		System.out.println(n); // name파라미터값인 donald를 출력
	}
	
	@RequestMapping("sub03")
	public void method03(@RequestParam("name") String n, @RequestParam("age") String age) {
		System.out.println(n);
		System.out.println(age);
		int a = Integer.parseInt(age);
	}
	
	@RequestMapping("sub04")
	public void method04(@RequestParam("age") int age) {
		System.out.println(age);
	}
	
}
