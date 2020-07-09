package yeong.spring.web.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import yeong.spring.web.board.BoardVO;
import yeong.spring.web.board.service.DeleteBoardService;
import yeong.spring.web.board.service.GetBoardListService;
import yeong.spring.web.board.service.GetBoardService;
import yeong.spring.web.board.service.InsertBoardService;
import yeong.spring.web.board.service.UpdateBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	InsertBoardService InsertBoardService;
	
	@Autowired
	UpdateBoardService updateBoardService;
	
	@Autowired
	DeleteBoardService deleteBoardService;
	
	@Autowired
	GetBoardListService getBoardListService;
	
	@Autowired
	GetBoardService getBoardService;
	
	
	@RequestMapping(value = "/getBoardList", method= {RequestMethod.GET})
	public String getBoardList(Model model) {
		List<BoardVO> articleList = getBoardListService.getBoardList(new BoardVO());
		model.addAttribute("boardList", articleList);
		return "getBoardList";
	}
	@RequestMapping(path ="/insertForm")
	public void insertForm() {}
	
	@RequestMapping(value= "/insert", method = {RequestMethod.POST})
	public String insert(@ModelAttribute BoardVO vo) {
		InsertBoardService.insert(vo);
		return "redirect:/board/getBoardList";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.POST})
	public String delete(@RequestParam int seq) {
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		deleteBoardService.delete(vo);
		return "redirect:/board/getBoardList";
	}
	@RequestMapping(path ="/getBoard")
	public String getBoardForm(Model model, @RequestParam("seq") int seq) {
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		getBoardService.getBoard(vo);
		model.addAttribute("board", vo);
		return "getBoard";
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST})
	public String update(
			@RequestParam(value = "title", required=false, defaultValue="0") String title,
			@RequestParam(value = "content") String content, 
			@RequestParam("seq") int seq) {	
		BoardVO vo = new BoardVO();	
		vo.setSeq(seq);
		vo.setTitle(title);
		vo.setContent(content);
		updateBoardService.update(vo);
		return "redirect:/board/getBoardList";
	}
	
	
}
