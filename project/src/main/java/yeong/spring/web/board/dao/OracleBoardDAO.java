package yeong.spring.web.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import yeong.spring.web.board.BoardDAO;
import yeong.spring.web.board.BoardVO;

public class OracleBoardDAO implements BoardDAO{

	private JdbcTemplate template;
	
	@Autowired
	public OracleBoardDAO(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		Object[] obj = { vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getRegDate(), vo.getCnt()};
		template.update("INSERT INTO myboard VALUES(board_seq.nextval, ?,?,?,?,?)", obj);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		Object[] obj = { vo.getTitle(), vo.getContent(), vo.getSeq()};
		template.update("UPDATE myboard SET title = ?, content = ? WHERE seq = ?", obj);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		Object[] obj = {vo.getSeq()};
		template.update("DELETE FROM myboard WHERE seq = ?", obj);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		Object[] obj = {vo.getSeq()};
		return template.queryForObject("SELECT * FROM myboard WHERE seq = ?", obj, new BoardRowMapper());
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		
		if(vo.getSearchCondition().equals("TITLE"))
			return template.query("SELECT * FROM myboard WHERE title LIKE '%'||?||'%' ORDER BY seq DESC", new Object[] {vo.getSearchKeyword()},new BoardRowMapper());
		else if(vo.getSearchCondition().equals("CONTENT"))
			return template.query("SELECT * FROM myboard WHERE content LIKE '%'||?||'%' ORDER BY seq DESC", new Object[] {vo.getSearchKeyword()},new BoardRowMapper());
		else 
			return null;
	}
	
	/**
	 * rowMapper
	 * @author Yeong
	 *
	 */
	private static class BoardRowMapper implements RowMapper<BoardVO> {
		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO retVO = new BoardVO();
			retVO.setSeq(rs.getInt("seq"));
			retVO.setTitle(rs.getString("title"));
			retVO.setWriter(rs.getString("writer"));
			retVO.setContent(rs.getString("content"));
			retVO.setRegDate(rs.getDate("regDate"));
			retVO.setCnt(rs.getInt("cnt"));
			
			return retVO;
		}
	}
	
}
