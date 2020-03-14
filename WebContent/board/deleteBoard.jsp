<%@page import="com.mvc1.member.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mvc1.board.dao.BoardDao" %>
<%@ page import="com.mvc1.board.dao.BoardDaoImpl" %>
<%@ page import="com.mvc1.board.vo.BoardVO" %>
<%@ page import="java.util.ArrayList" %>
<%
	request.setCharacterEncoding("UTF-8");

	String isudType = request.getParameter("ISUD_TYPE");
	String chkInKno = request.getParameter("chkInKno");
	String kno = request.getParameter("kno");
	String ktitle = request.getParameter("ktitle");
	String kname = request.getParameter("kname");
	String kpw = request.getParameter("kpw");
	String kcontent = request.getParameter("kcontent");
	
	if("D".equals(isudType.toUpperCase())){
		System.out.println(" ISUD_TYPE >>> : " + isudType);
		
	 	BoardDao bdao = new BoardDaoImpl();
	 	BoardVO bvo = new BoardVO();
	 	
	 	bvo.setKno(chkInKno);
	 	
	 	int cnt = bdao.deleteBoard(bvo);
	 	
	 	if(cnt == 1){
%>
		<script type="text/javascript">
			alert("삭제되었습니다.");
			location.href="/mvc1Project/board/selectBoard.jsp";
		</script>
<% 		
	 	}else{
%>
		<script type="text/javascript">
			alert("삭제되지 않았습니다.");
			location.href="/mvc1Project/board/selectBoard.jsp";
		</script>

<% 		
	 	}
	
	}
%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		</head>
	<body>
	
	</body>
</html>