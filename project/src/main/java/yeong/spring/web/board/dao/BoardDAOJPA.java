package yeong.spring.web.board.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import yeong.spring.web.board.BoardDAO;
import yeong.spring.web.board.BoardVO;


@Repository
public class BoardDAOJPA implements BoardDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public void insertBoard(BoardVO vo) {
		manager.persist(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		manager.merge(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		manager.remove(manager.find(BoardVO.class, vo.getSeq()));
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO) manager.find(BoardVO.class, vo.getSeq());
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return manager.createQuery("select vo from BoardVO vo ORDER BY vo.seq desc", BoardVO.class).getResultList();
	}
}
