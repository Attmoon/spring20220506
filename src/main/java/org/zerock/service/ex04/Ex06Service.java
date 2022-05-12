package org.zerock.service.ex04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.mapper.ex04.Ex04Mapper;

@Service
public class Ex06Service {
	
	@Autowired
	private Ex04Mapper mapper;
	
	public String getCusotmerNameById(int id) {
		return mapper.selectCustomerNameById(id);
	}

	public String getEmployeeFirstNameById(int id) {
		return mapper.selectEmployeeFirstNameById(id);
	}

}
