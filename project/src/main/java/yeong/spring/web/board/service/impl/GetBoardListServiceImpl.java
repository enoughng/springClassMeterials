package yeong.spring.web.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeong.spring.web.board.BoardDAO;
import yeong.spring.web.board.BoardVO;
import yeong.spring.web.board.service.GetBoardListService;

@Service
public class GetBoardListServiceImpl implements GetBoardListService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}
