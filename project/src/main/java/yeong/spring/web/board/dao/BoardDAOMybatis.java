package yeong.spring.web.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import yeong.spring.web.board.BoardDAO;
import yeong.spring.web.board.BoardVO;

@Repository
public class BoardDAOMybatis implements BoardDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public void insertBoard(BoardVO vo) {
		Object[] obj = { vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getRegDate(), vo.getCnt()};
		sqlSession.insert("boardDAO.insertBoard", vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		Object[] obj = { vo.getTitle(), vo.getContent(), vo.getSeq()};
		sqlSession.update("boardDAO.updateBoard", vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		sqlSession.delete("boardDAO.deleteBoard", vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return sqlSession.selectOne("boardDAO.getBoard", vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return sqlSession.selectList("boardDAO.getBoardList", vo);
	}
	
	
}
