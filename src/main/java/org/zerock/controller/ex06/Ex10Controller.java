package org.zerock.controller.ex06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.controller.ex03.Customer;

@Controller
@RequestMapping("ex10")
public class Ex10Controller {

	@RequestMapping("sub01")
	public String method01(RedirectAttributes rttr) { 
		// Model은 request에 붙여서주는건데 리다이렉트할땐 새 request로 넘어오기때문에
		// model로 줄수없고 RedirectAttributes로 줘야함
		System.out.println("ex10/sub01경로에서 일함..");
		rttr.addAttribute("address", "seoul");
		
		return "redirect:/ex10/sub02";
	}
	
	@RequestMapping("sub02")
	public void method02() {
		System.out.println("ex10/sub02경로에서 일함@@");
	}
	
	@RequestMapping("sub03")
	public String method03(RedirectAttributes rttr) {
		rttr.addAttribute("name", "sunja");
		rttr.addAttribute("age", 99);
		rttr.addAttribute("address", "seoul");
		
		return "redirect:/ex10/sub04";
	}
	
	@RequestMapping("sub04")
	public void method04() {
		
	}
	
	@RequestMapping("sub05")
	public String method05(RedirectAttributes rttr) {
		Customer c = new Customer();
		c.setAge(88);
		c.setName("captain");
		c.setAddress("ny");
		
		rttr.addFlashAttribute("customer", c); 
		// request보다 넓은범위 -> 넓은 범위를 주는 이유는 redirect시키면 처음 request는 사라지기때문에
		// request보다는 넓은 범위를 써서 redirect시켜도 객체가 남아있게 하기위함이다.
		// (redirect이후에 객체는 session에서는지워지고 model에는 남아있다.)
		
		return "redirect:/ex10/sub06";
	}
	
	@RequestMapping("sub06")
	public void method06(Model model) {
		System.out.println(model.asMap().get("customer"));
	}
	
}
