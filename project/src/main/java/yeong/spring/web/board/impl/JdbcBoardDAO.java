package yeong.spring.web.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import yeong.spring.web.board.BoardDAO;
import yeong.spring.web.board.BoardVO;

@Repository
public class JdbcBoardDAO implements BoardDAO{
	
	private JdbcTemplate template;
	
	@Autowired
	public JdbcBoardDAO(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public void insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
