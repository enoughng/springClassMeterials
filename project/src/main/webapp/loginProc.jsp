<%@page import="yeong.spring.web.user.UserVO"%>
<%@page import="yeong.spring.web.user.impl.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	//	1. 사용자의 입력 정보 추출
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	//	2. 데이터베이스 연동 처리 
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO userDAO = new yeong.spring.web.user.impl.UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	//	3. 화면 네비게이션 ( 화면 이동 )
	if(user != null) {
		response.sendRedirect("getBoardList.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
%>