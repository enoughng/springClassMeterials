<%@page import="yeong.spring.web.user.UserVO"%>
<%@page import="yeong.spring.web.user.impl.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//	1. ������� �Է� ���� ����
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	//	2. �����ͺ��̽� ���� ó�� 
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO userDAO = new yeong.spring.web.user.impl.UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	//	3. ȭ�� �׺���̼� ( ȭ�� �̵� )
	if(user != null) {
		response.sendRedirect("getBoardList.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
%>