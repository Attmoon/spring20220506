package org.zerock.domain.ex02;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReplyDto {
	// table과 구조가 비슷
	private int id;
	private int boardId; // board_id column과 매칭 -> 별칭줘서 맞춰야함
	private String content;
	private LocalDateTime inserted;
}
