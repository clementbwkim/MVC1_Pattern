<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mvc1.member.dao.MemberDao" %>
<%@ page import="com.mvc1.member.dao.MemberDaoImpl" %>
<%@ page import="com.mvc1.member.vo.MemberVO" %>
<%@ page import="java.util.ArrayList" %>
<%
	request.setCharacterEncoding("UTF-8");

	String kname = request.getParameter("kname");
	String kid = request.getParameter("kid");
	String kpw = request.getParameter("kpw");
	String kbirth = request.getParameter("kbirth");
	String kgender = request.getParameter("kgender");
	String kemail = request.getParameter("kemail");
	String kmobile = request.getParameter("kmobile");
	String kpostnum = request.getParameter("kpostnum");
	String kaddr = request.getParameter("kaddr");

	MemberDao mdao = new MemberDaoImpl();
	MemberVO mvo = new MemberVO();
	mvo.setKname(kname);
	mvo.setKid(kid);
	mvo.setKpw(kpw);
	mvo.setKbirth(kbirth);
	mvo.setKgender(kgender);
	mvo.setKemail(kemail);
	mvo.setKmobile(kmobile);
	mvo.setKpostnum(kpostnum);
	mvo.setKaddr(kaddr);
	
	boolean bFlag = mdao.insertMember(mvo);
	
	if(bFlag){
%>
	<script type="text/javascript">
		alert("등록되었습니다.");
		location.href = "/mvc1Project/login.html";
	</script>
<%
	}else{
		%>
	<script type="text/javascript">
		alert("등록을 실패하였습니다. 다시 시도해주세요.");
		location.href = "/mvc1Project/member/signup.html";
	</script>
		<%
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert</title>
	</head>
	<body>
	</body>
</html>