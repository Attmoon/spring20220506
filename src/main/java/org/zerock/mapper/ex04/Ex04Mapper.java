package org.zerock.mapper.ex04;

import java.util.List;

import org.zerock.domain.ex02.BoardDto;

public interface Ex04Mapper {
	
	String selectCustomerNameById(int id);

	String selectEmployeeFirstNameById(int id);
	
	List<BoardDto> selectBoard();

	BoardDto getBoard(int id);

	int updateBoard(BoardDto board);

}
