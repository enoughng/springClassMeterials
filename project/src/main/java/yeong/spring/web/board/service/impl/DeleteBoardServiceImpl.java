package yeong.spring.web.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeong.spring.web.board.BoardDAO;
import yeong.spring.web.board.BoardVO;
import yeong.spring.web.board.service.DeleteBoardService;

@Service
public class DeleteBoardServiceImpl implements DeleteBoardService {
		
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
		public void delete(BoardVO vo) {
			boardDAO.deleteBoard(vo);
		}
}
