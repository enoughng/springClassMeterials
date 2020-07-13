package yeong.spring.web.board.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import yeong.spring.web.board.BoardVO;
import yeong.spring.web.board.service.BoardService;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new LinkedHashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		
		System.out.println("글 등록 처리");
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board")  BoardVO vo) throws IOException {
		System.out.println("글 수정 처리");
		System.out.println("번호 : " + vo.getSeq());
		System.out.println("제목 : " + vo.getTitle());
		System.out.println("작성자 이름 :  " + vo.getWriter());
		System.out.println("내용 : " + vo.getContent());
		System.out.println("작성일 : " + vo.getRegDate());
		System.out.println("조회수 : " + vo.getCnt());
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) throws IOException {
		
		
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, ModelAndView mav, Model model) throws IOException {
		System.out.println("글 상세 보기 처리");
		BoardVO board = boardService.getBoard(vo);
		model.addAttribute("board", board);
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo,	 ModelAndView mav, Model model, Map<String, String> map) throws IOException {
		System.out.println("글 목록 보기 처리");
		System.out.println("검색조건: "  + vo.getSearchCondition());
		System.out.println("검색단어: " + vo.getSearchKeyword());
		List<BoardVO> boardList = boardService.getBoardList(vo);
		model.addAttribute("boardList", boardList);
		return "getBoardList.jsp";
	}
}
