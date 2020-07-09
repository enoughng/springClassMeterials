package yeong.spring.web.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("로그아웃 처리");
		HttpSession session = request.getSession(false);
		// 1. 브라우저와 연결된 세션 객체를 종료
		session.invalidate();

		// 2. 세션 종료 후 메인 화면으로 이동
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login.jsp");
		return mav;
	}

}
