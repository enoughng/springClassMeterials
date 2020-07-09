package yeong.spring.web.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import yeong.spring.web.board.impl.OracleBoardDAO;

public class GetBoardListController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.out.println("글 목록 보기 처리");
		// 1. 사용자의 입력 정보 추출
		// 2. 데이터베이스 연동 처리
		BoardVO vo = new BoardVO();
		OracleBoardDAO boardDAO = new OracleBoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		// 3. 화면 네비게이션
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList");
		mav.addObject("boardList", boardList);
		return mav;
	}
}
