package org.zerock.service.ex03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.mapper.ex03.Ex03Mapper;

@Service
public class Ex05Service {

	@Autowired
	private Ex03Mapper mapper;
	
	public String getNameById(int id) {
		String name = mapper.selectNameById(id);
		
		return name;
	}
}
