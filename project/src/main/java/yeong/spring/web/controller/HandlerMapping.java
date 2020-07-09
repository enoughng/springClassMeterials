package yeong.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import yeong.spring.web.board.DeleteBoardController;
import yeong.spring.web.board.GetBoardController;
import yeong.spring.web.board.GetBoardListController;
import yeong.spring.web.board.InsertBoardController;
import yeong.spring.web.board.UpdateBoardController;
import yeong.spring.web.user.LoginController;
import yeong.spring.web.user.LogoutController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		//앞으로 요청 주소(키)와 해당 요청을 처리할 컨트롤러(값)을 추가
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}	
