package yeong.spring.web.board.service.impl;

import org.springframework.stereotype.Service;

import yeong.spring.web.board.BoardVO;
import yeong.spring.web.board.service.UpdateBoardService;

@Service
public class UpdateBoardServiceImpl implements UpdateBoardService {

	@Override
	public void update(BoardVO vo) {
		System.out.println("업데이트");
	}

}
