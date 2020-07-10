package yeong.spring.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yeong.spring.web.user.dao.UserDAO;
import yeong.spring.web.user.dao.impl.OracleUserDAO;

@Controller
public class LoginController {

	@RequestMapping(value = "/login.do", method=RequestMethod.GET) 
	public String loginView(UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
	}
	
	@RequestMapping(value = "/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, HttpSession session) {
		System.out.println("로그인 처리");
		// 1. 사용자 입력 정보 추출 
		UserDAO userDAO = new OracleUserDAO();
		UserVO user = userDAO.getUser(vo);
		
		// 3. 화면 네비게이션
		if (user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}
}
