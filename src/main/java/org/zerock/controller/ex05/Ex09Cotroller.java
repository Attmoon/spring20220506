package org.zerock.controller.ex05;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.controller.ex03.Customer;
import org.zerock.controller.ex03.Employee;

@Controller
@RequestMapping("ex09")
public class Ex09Cotroller {
	
	@RequestMapping("sub01")
	public void method01(String name, Model model) {
		// 1. request 파라미터 수집/가공
		System.out.println(name);
		
		// 3. model에 attribute 추가
		model.addAttribute("name", name);
		
		// 4. view forward : ex09/sub01.jsp
	}
	
	// /ex09/sub02?name=sunja
	@RequestMapping("sub02")
	public String method02(@ModelAttribute("name") String name) { 
		// model에 attribute를 더해주는일을 어노테이션이 대신해줌
		// model.addAttribute("name", name);
		
		return "ex09/sub01";
	}
	
	// /ex09/sub03?address=seoul&email=gmail.com
	@RequestMapping("sub03")
	public void method03(@ModelAttribute("address") String address, 
			             @ModelAttribute("email") String email) {
		
	}
	
	// /ex09/sub04?name=trump&age=40&address=newyork
	@RequestMapping("sub04")
	public void method04(@ModelAttribute("customer") Customer cus) {
		// ModelAttribute에 customer라는 이름으로 Customer빈의 모든걸 넣겠다
		// 리턴타입 void로 쓰면 경로가 view이름으로 됨
	}
	
	// /ex09/sub05?name=trump&age=40&address=newyork
	@RequestMapping("sub05")
	public String method05(@ModelAttribute Customer cus) { // @modelattribute의 이름 생략
		return "ex09/sub04"; // 리턴타입 string으로 써주면 view경로를 설정해주기위함이고
	}
	
	@RequestMapping("sub06")
	public String method06(Customer cus) { // @modelattribute 생략
		return "ex09/sub04";
	}
	
	// 요청경로 : /ex09/sub07
	// 쿼리스트링 : ?name=sunja&salary=50000&email=sunja@gmail.com
	
	// method07 작성
	// Employee 객체가
	// 쿼리스트링으로 넘어온 파라미터값들을 세팅해서
	// model에 "employee"라는 이름의 attribute로 추가되고
	// /ex09/sub07 뷰로 포워드 되도록
	@RequestMapping("sub07")
	public void method07(Employee emp) {
		
	}
	
}
