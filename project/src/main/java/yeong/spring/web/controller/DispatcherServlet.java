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
//@WebServlet(name = "action", urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 클라이언트 정보를 추출한다.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);

		// 2. 처리 : 데이터베이스 연동 처리
		if (path.equals("/login.do")) {
			System.out.println("로그인 처리");
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			// 2. 데이터베이스 연동 처리
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);

			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);

			// 3. 화면 네비게이션 ( 화면 이동 )
			if (user != null) {
				response.sendRedirect("getBoardList.do");
			} else {
				response.sendRedirect("login.jsp");
			}
		} else if (path.equals("/logout.do")) {
			
			HttpSession session = request.getSession(false);
			// 1. 브라우저와 연결된 세션 객체를 종료
			session.invalidate();

			// 2. 세션 종료 후 메인 화면으로 이동
			response.sendRedirect("login.jsp");
			
			
		} else if (path.equals("/insertBoard.do")) {
			
//			request.setCharacterEncoding("utf-8");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");

			// 2. 데이터베이스 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new OracleBoardDAO();
			boardDAO.insertBoard(vo);
			
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/updateBoard.do")) {

//			request.setCharacterEncoding("utf-8");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			System.out.println(seq);
			
			// 2. 데이터 베이스 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new OracleBoardDAO();
			boardDAO.updateBoard(vo);
			
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/deleteBoard.do")) {
			
			String seq = request.getParameter("seq");
			
			// 2. 데이터 베이스 연동
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new OracleBoardDAO();
			boardDAO.deleteBoard(vo);
			
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
			
			
		} else if (path.equals("/getBoard.do")) {

			System.out.println("글 상세 보기 처리");
			// 1. 검색할 게시글 번호 추출
			String seq = request.getParameter("seq");

			// 2. 데이터베이스 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));

			BoardDAO boardDAO = new OracleBoardDAO();
			BoardVO board = boardDAO.getBoard(vo);

			// 3. 화면 네비게이션
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
		} else if (path.equals("/getBoardList.do")) {

			System.out.println("글 목록 보기 처리");
			// 1. 사용자의 입력 정보 추출
			// 2. 데이터베이스 연동 처리
			BoardVO vo2 = new BoardVO();
			OracleBoardDAO boardDAO = new OracleBoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo2);
			// 3. 화면 네비게이션
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		} else {
			System.out.println("잘못된 경로입니다 : " + path);
		}
	}

}
