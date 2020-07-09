package yeong.spring.web.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yeong.spring.web.board.impl.OracleBoardDAO;
import yeong.spring.web.controller.Controller;

public class DeleteBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String seq = request.getParameter("seq");
		
		// 2. 데이터 베이스 연동
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new OracleBoardDAO();
		boardDAO.deleteBoard(vo);
		
		return "getBoardList.do";
	}

}
