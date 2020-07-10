package yeong.spring.web.user;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController{

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) throws IOException {
		System.out.println("로그아웃 처리");
		session.invalidate();

		// 2. 세션 종료 후 메인 화면으로 이동
		return "login.jsp";
	}

}
