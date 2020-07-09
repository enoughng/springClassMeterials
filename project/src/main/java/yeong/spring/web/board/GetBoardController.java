package yeong.spring.web.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yeong.spring.web.board.impl.OracleBoardDAO;
import yeong.spring.web.controller.Controller;

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("글 상세 보기 처리");
		// 1. 검색할 게시글 번호 추출
		String seq = request.getParameter("seq");

		// 2. 데이터베이스 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));

		BoardDAO boardDAO = new OracleBoardDAO();
		BoardVO board = boardDAO.getBoard(vo);

		// 3. 화면 네비게이션
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		return "getBoard";
	}

}
