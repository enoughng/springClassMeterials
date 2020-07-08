<%@page import="yeong.spring.web.board.BoardDAO"%>
<%@page import="yeong.spring.web.board.impl.OracleBoardDAO"%>
<%@page import="yeong.spring.web.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

	// 1. ����� �Է� ���� ����
	request.setCharacterEncoding("utf-8");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String seq = request.getParameter("seq");
	
	// 2. ������ ���̽� ���� ó��
	BoardVO vo = new BoardVO();
	vo.setTitle(title);
	vo.setContent(content);
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new OracleBoardDAO();
	boardDAO.updateBoard(vo);
	
	// 3. ȭ�� �׺���̼�
	response.sendRedirect("getBoardList.jsp");
%>