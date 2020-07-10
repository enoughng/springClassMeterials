package yeong.spring.web.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import yeong.spring.web.board.BoardDAO;
import yeong.spring.web.board.BoardVO;
import yeong.spring.web.board.impl.OracleBoardDAO;

@Controller
public class BoardController {
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		
		System.out.println("글 등록 처리");
		BoardDAO boardDAO = new OracleBoardDAO();
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) throws IOException {
		
		BoardDAO boardDAO = new OracleBoardDAO();
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) throws IOException {
		
		
		BoardDAO boardDAO = new OracleBoardDAO();
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, ModelAndView mav, Model model) throws IOException {
		System.out.println(model);
		System.out.println("글 상세 보기 처리");
		BoardDAO boardDAO = new OracleBoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		model.addAttribute("board", board);
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, ModelAndView mav, Model model, Map<String, String> map) throws IOException {
		System.out.println(model);
		System.out.println("=============================");
		System.out.println(map);
		System.out.println("글 목록 보기 처리");
		OracleBoardDAO boardDAO = new OracleBoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		model.addAttribute("boardList", boardList);
		return "getBoardList.jsp";
	}
}
