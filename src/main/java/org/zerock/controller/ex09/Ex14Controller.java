package org.zerock.controller.ex09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.ex01.CustomerDto;
import org.zerock.service.ex02.Ex04Service;
import org.zerock.service.ex03.Ex05Service;

@Controller
@RequestMapping("ex14")
public class Ex14Controller {
	
	@Autowired
	private Ex04Service service;
	
	@Autowired
	private Ex05Service service2;
	
	@RequestMapping("sub01")
	public void method01(int id, Model model) {
		// 1. request parameter 수집 / 가공
		// 2. bussiness 로직 처리
		String name = service.getNameById(id);
		
		// 3. model.addAttribute
		model.addAttribute("name", name);
		// 4. forward / redirect
		
	}
	
	// /ex14/sub02?id=3
	// view에서 Employee의 firstName이 출력 되도록
	
	// controller.method02
	// service에도 메소드 추가
	// mapper에도 메소드 추가
	// jsp 작성
	@RequestMapping("sub02")
	public void method02(int id, Model model) {
		String name = service2.getNameById(id);
		
		model.addAttribute("firstName", name);
	}
	
	// /ex14/sub03?id=3
	@RequestMapping("sub03")
	public void method03(int id, Model model) {
		CustomerDto dto = service.getCustomerInfoById(id);
		
		model.addAttribute("customer", dto);
	}
}
