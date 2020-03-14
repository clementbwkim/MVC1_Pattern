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
	
	System.out.println(isudType + " : "
					  + chkInKno + " : "
					  + kno + " : "
					  + ktitle + " : "
					  + kname + " : "
					  + kpw + " : "
					  + kcontent + " : ");

	if(isudType != null){
		boolean b = "I".equals(isudType.toUpperCase());
		
		if(b){
			BoardDao bdao = new BoardDaoImpl();
			BoardVO bvo = new BoardVO();
			int cnt = 0;
			
			bvo.setKtitle(ktitle);
			bvo.setKname(kname);
			bvo.setKpw(kpw);
			bvo.setKcontent(kcontent);
			bvo.setKdeleteyn("Y");
			
			cnt = bdao.insertBoard(bvo);
			
			if(cnt > 0){
%>
		<script type="text/javascript">
			alert("등록되었습니다.");
			location.href="/mvc1Project/board/selectBoard.jsp ";
		</script>
<%			
			}else{
%>
		<script type="text/javascript">
			alert("등록이 완료되지 않았습니다.");
			location.href="/mvc1Project/board/board.html";
		</script>
<%				
			}
			
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