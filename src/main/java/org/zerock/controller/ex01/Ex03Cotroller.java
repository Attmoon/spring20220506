package org.zerock.controller.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex03")
public class Ex03Cotroller {
	
	@RequestMapping("sub01")
	public void method01() {
		System.out.println("/ex03/sub01 일함");
	}
	
	@RequestMapping(value = "sub01", params = "name") // 쿼리스트링으로 name파라미터 있을시에 실행됨
	public void method02() {
		System.out.println("/ex03/sub01 경로, name 파라미터 있음");
	}
	
	@RequestMapping(value = "sub01", params = {"name", "age"}) // 쿼리스트링으로 name과 age파라미터가 둘다 있으면 실행됨
	public void method03() {
		System.out.println("같은 경로, name, age 파라미터 있음");
	}
}
