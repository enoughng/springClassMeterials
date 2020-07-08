<%@page import="yeong.spring.web.board.BoardVO"%>
<%@page import="yeong.spring.web.board.impl.OracleBoardDAO"%>
<%@page import="yeong.spring.web.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// 1. 사용자 정보 추출
	String seq = request.getParameter("seq");
	
	// 2. 데이터 베이스 연동
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new OracleBoardDAO();
	boardDAO.deleteBoard(vo);
	
	// 3. 화면 네비게이션
	response.sendRedirect("getBoardList.jsp");
%>