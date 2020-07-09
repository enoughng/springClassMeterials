package yeong.spring.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yeong.spring.web.board.BoardDAO;
import yeong.spring.web.board.BoardVO;
import yeong.spring.web.board.impl.OracleBoardDAO;
import yeong.spring.web.user.UserVO;
import yeong.spring.web.user.impl.UserDAO;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(name = "action", urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;

	@Override
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1. 클라이언트(사용자)의 요청 정보 추출
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		//2. HanddlerMapping을 통해 경로(path)에 해당하는 Controller를 검색
		Controller controller = handlerMapping.getController(path);
		
		//3. 검색된 Controller를 실행한다.
		String viewName = controller.handleRequest(request, response);
		
		//4. viewResolver를 통해 viewName에 해당하는 화면을 검색한다.
		String view = null;
		
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		} else {
			view = viewName;
		}
		
		// 5. 검색 된 화면으로 이동한다. 원래대로 라면 포워딩!
		response.sendRedirect(view);
	}

}
