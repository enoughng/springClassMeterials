<%@page import="yeong.spring.web.board.BoardVO"%>
<%@page import="yeong.spring.web.board.impl.OracleBoardDAO"%>
<%@page import="yeong.spring.web.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// 1. ����� ���� ����
	String seq = request.getParameter("seq");
	
	// 2. ������ ���̽� ����
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new OracleBoardDAO();
	boardDAO.deleteBoard(vo);
	
	// 3. ȭ�� �׺���̼�
	response.sendRedirect("getBoardList.jsp");
%>