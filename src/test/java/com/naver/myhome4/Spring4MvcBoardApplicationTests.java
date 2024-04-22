package com.naver.myhome4;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.naver.myhome4.domain.Board;
import com.naver.myhome4.mybatis.mapper.BoardMapper;

/*
 * 1. Junit이란 Java에서 독립된 단위 테스트를 지원해주는 프레임워크입니다.
 * 2. 단위 테스트 
 * 	  단위테스트는 하나의 모듈을 기준으로 독립적으로 진행되는 가장 작은 단위의 테스트입니다.
 * 	  하나의 모듈이란 각 계층에서의 하나의 기능 또는 메소드로 이해할 수 있습니다.
 *    하나의 기능이 올바르게 동작하는지를 독립적으로 테스트하는 것입니다. 
 * */

@SpringBootTest
class Spring4MvcBoardApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(Spring4MvcBoardApplicationTests.class);

	@Autowired
	private BoardMapper dao;
	
	@Test
	public void boardDelete() {
		Board board = new Board();
		board.setBOARD_RE_REF(3);
		board.setBOARD_RE_LEV(1);
		board.setBOARD_RE_SEQ(1);
		
		int result = dao.boardDelete(board);
		if (result >= 1) {
			logger.info(result + "개 삭제되었습니다.");
		}
	}

}
