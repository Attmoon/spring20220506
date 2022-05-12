package org.zerock.controller.ex09;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ex01.CustomerDto;
import org.zerock.domain.ex01.EmployeeDto;
import org.zerock.domain.ex01.PageInfoDto;
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
	
	// /ex14/sub04?id=7
	// 직원의 FirstName, LastName이 모두 jsp 출력 되도록
	
	// controller에 새 메소드 작성
	// service에 새 메소드 작성
	// mapper에 새 메소드 작성
	// 새 jsp파일 작성
	// EmployeeDto 새로 작성
	@RequestMapping("sub04")
	public void method04(int id, Model model) {
		EmployeeDto dto = service.getEmployeeInfoById(id);
		
		model.addAttribute("employee", dto);
	}
	
	@GetMapping("sub05")
	public void method05() {
		// form 있는 jsp로 forward
	}
	
	@PostMapping("sub05")
	public String method06(CustomerDto customer, RedirectAttributes rttr) {
		// 1.
		System.out.println(customer);
		// 2.
		boolean ok = service.addCustomer(customer);
		// 3.
		if (ok) {
			rttr.addFlashAttribute("message", "등록 완료");
		} else {
			rttr.addFlashAttribute("message", "등록 실패");
		}
		// 4.
		
		return "redirect:/ex14/sub05";
	}
	
	@GetMapping("sub06")
	public void method07() {
		
	}
	
	@PostMapping("sub06")
	public String method08(EmployeeDto employee, RedirectAttributes rttr) {
		
		boolean ok = service.addEmployee(employee);
		
		if (ok) {
			rttr.addFlashAttribute("message", "등록 완료");
		} else {
			rttr.addFlashAttribute("message", "등록 실패");
		}
		
		return "redirect:/ex14/sub06";
	}
	
	@GetMapping("sub07")
	public void method09(Model model) {
		List<EmployeeDto> list = service.listEmployee();
		
		model.addAttribute("employees", list);
	}
	
	@GetMapping("sub08")
	public void method10(Model model) {
		List<CustomerDto> list = service.listCustomer();
		
		model.addAttribute("customers", list);
	}
	
	// /ex14/sub09/page=3
	@GetMapping("sub09")
	public String method11(@RequestParam(name = "page", defaultValue = "1")int page, Model model) {
		int rowPerPage = 5; // 한페이지에 몇개를 보여줄건지
		
		List<CustomerDto> list = service.listCustomerPage(page, rowPerPage);
		int totalRecords = service.countCustomers();
		
		int end = (totalRecords - 1) / rowPerPage + 1;
		
		PageInfoDto pageInfo = new PageInfoDto();
		pageInfo.setCurrent(page);
		pageInfo.setEnd(end);
		
		model.addAttribute("customers", list);
		model.addAttribute("pageInfo", pageInfo);
		
		return "/ex14/sub09";
	}
}
