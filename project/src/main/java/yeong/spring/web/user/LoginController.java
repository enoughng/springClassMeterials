package yeong.spring.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yeong.spring.web.controller.Controller;
import yeong.spring.web.user.dao.UserDAO;
import yeong.spring.web.user.dao.impl.OracleUserDAO;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("로그인 처리");
		// 1. 사용자 입력 정보 추출 
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		// 2. 데이터베이스 연동 처리 
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		UserDAO userDAO = new OracleUserDAO();
		UserVO user = userDAO.getUser(vo);
		// 3. 화면 네비게이션
		if (user != null) {
			return "getBoardList.do";
		} else {
			return "login";
		}

	}
}
