<%@page import="yeong.spring.web.board.impl.OracleBoardDAO"%>
<%@page import="yeong.spring.web.board.dao.BoardDAO"%>
<%@page import="yeong.spring.web.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardVO board = (BoardVO) session.getAttribute("board");
%>
<!DOCTYPE>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>Board Article Content</title>
	</head>
	<body>
		<h1>글 상세보기</h1>
		<a href="logout.do">Log out</a><hr>
		<form action="updateBoard.do" method="post">
		<% System.out.println(board.getSeq()); %>
			<input type="hidden" name="seq" value="<%=board.getSeq() %>"/>
			<table border="1">
				<tr>
					<th>제목</th>
					<td><input name="title" type="text" value="<%=board.getTitle()%>"/></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=board.getWriter() %></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content"><%=board.getContent()%></textarea></td>
				</tr>
				<tr>
					<th>등록일</th>
					<td><%=board.getRegDate() %></td>
				</tr>
				<tr>
					<th>조회수</th>
					<td><%=board.getCnt() %></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="글수정" /></td>
				</tr>
			</table>
		</form><hr>
		<a href="insertBoard.do">글등록</a>&nbsp;&nbsp;&nbsp;
		<a href="deleteBoard.do?seq=<%=board.getSeq()%>">글삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.do">글목록</a>
	</body>
</html>
