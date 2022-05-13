package org.zerock.controller.ex10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.ex02.ReplyDto;
import org.zerock.service.ex04.Ex07Service;

@Controller
@RequestMapping("ex16")
public class Ex16Controller {
	
	@Autowired
	private Ex07Service service;
	
	@PostMapping("reply/add")
	public String addReply(ReplyDto reply) {
		boolean success = service.addReply(reply);
		
		return "redirect:/ex15/board/" + reply.getBoardId();
	}
}