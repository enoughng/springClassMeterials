package yeong.spring.web.board.service;

import java.util.List;

import yeong.spring.web.board.BoardVO;

public interface GetBoardListService {
	List<BoardVO> getBoardList(BoardVO vo);
}
