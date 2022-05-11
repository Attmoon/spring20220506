package org.zerock.service.ex02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.ex01.CustomerDto;
import org.zerock.mapper.ex02.Ex02Mapper;

@Service
public class Ex04Service {
	
	@Autowired
	private Ex02Mapper mapper;
	
	public String getNameById(int id) {
		String name = mapper.selectNameById(id);
		
		return name;
	}

	public CustomerDto getCustomerInfoById(int id) {
		return mapper.selectCustomerById(id);
	}
}