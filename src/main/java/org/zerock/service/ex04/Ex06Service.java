package org.zerock.service.ex04;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.ex02.BoardDto;
import org.zerock.mapper.ex04.Ex04Mapper;
import org.zerock.mapper.ex04.Ex05Mapper;

@Service
public class Ex06Service {
	
	@Autowired
	private Ex04Mapper mapper;
	
	@Autowired
	private Ex05Mapper replyMapper;
	
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
	
	@Transactional // 댓글지우기와 게시물지우기가 동시에 일어나는일이라고 명시함
	public boolean removeBoardById(int id) {
		// 댓글 먼저 지우기
		replyMapper.deleteReplyByBoard(id);
		
		// exception
//		int i = 3 / 0;
		
		// 게시물 지우기
		int cnt = mapper.deleteBoard(id);
		
		return cnt == 1;
	}

	public boolean addBoard(BoardDto board) {
		board.setInserted(LocalDateTime.now());
		
		int cnt = mapper.insertBoard(board);
		
		return cnt == 1;
	}


}
