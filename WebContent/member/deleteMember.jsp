<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.mvc1.member.dao.MemberDao" %>
<%@ page import="com.mvc1.member.dao.MemberDaoImpl" %>
<%@ page import="com.mvc1.member.vo.MemberVO" %>
<%@ page import="java.util.ArrayList" %>   
<%
	request.setCharacterEncoding("UTF-8");
	
	String knum = request.getParameter("knum");
	MemberDao mdao = new MemberDaoImpl();
	MemberVO mvo = new MemberVO();
	mvo.setKnum(knum);
	
	boolean bFlag = mdao.deleteMember(mvo);
	ArrayList<MemberVO> alist = null;
	
	if(bFlag){
%>
	<script type="text/javascript">
		alert("삭제되었습니다.");
		location.href="/mvc1Project/member/signup.html";
	</script>	
		
<%		
	}else{
%>
	<script type="text/javascript">
		alert("삭제되지 않았습니다.");
		location.href="/mvc1Project/member/signup.html/";
	</script>		
<%		
	}
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
	
	</body>
</html>