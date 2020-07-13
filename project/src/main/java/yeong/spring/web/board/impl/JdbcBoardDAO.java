package yeong.spring.web.board.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;

import yeong.spring.web.board.BoardSQLStatement;
import yeong.spring.web.board.BoardVO;
import yeong.spring.web.board.dao.BoardDAO;

//@Repository
public class JdbcBoardDAO implements BoardDAO{
	
	private JdbcTemplate template;
	
	@Autowired
	public JdbcBoardDAO(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public void insertBoard(BoardVO vo) {
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(vo);
		template.update(BoardSQLStatement.BOARD_INSERT, paramSource);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("title",vo.getTitle());
		paramMap.put("content",vo.getContent());
		template.update("UPDATE myboard SET title = :title, content = :content WHERE ", paramMap);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return null;
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return null;
	}
	
	
	
}
