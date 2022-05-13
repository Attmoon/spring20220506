package org.zerock.service.ex04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.ex02.BoardDto;
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

	public List<BoardDto> listBoard() {
		return mapper.selectBoard();
	}

	public BoardDto getBoard(int id) {
		return mapper.getBoard(id);
	}

	public boolean updateBoard(BoardDto board) {
		int cnt = mapper.updateBoard(board);
		
		return cnt == 1;
	}

	public boolean removeBoardById(int id) {
		int cnt = mapper.deleteBoard(id);
		
		return cnt == 1;
	}


}
