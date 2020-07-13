package yeong.spring.web.board.dao;

import java.util.List;

import yeong.spring.web.board.BoardVO;

public interface  BoardDAO{
	
	public void updateBoard(BoardVO vo);
	public void insertBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public BoardVO getBoard(BoardVO vo);
	public List<BoardVO> getBoardList(BoardVO vo);
}
