package yeong.spring.web.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeong.spring.web.board.BoardDAO;
import yeong.spring.web.board.BoardVO;
import yeong.spring.web.board.service.GetBoardService;

@Service
public class GetBoardServiceImpl implements GetBoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public BoardVO getBoard(BoardVO vo) {
		
		
		
		return null;
	}

}
