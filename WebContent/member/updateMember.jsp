<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mvc1.member.dao.MemberDao" %>
<%@ page import="com.mvc1.member.dao.MemberDaoImpl" %>
<%@ page import="com.mvc1.member.vo.MemberVO" %>
<%@ page import="java.util.ArrayList" %>
<%
	request.setCharacterEncoding("UTF-8");

	String knum = request.getParameter("knum");
	String kname = request.getParameter("kname");
	String kid = request.getParameter("kid");
	String kpw = request.getParameter("kpw");
	String kbirth = request.getParameter("kbirth");
	String kgender = request.getParameter("kgender");
	String kemail = request.getParameter("kemail");
	String kmobile = request.getParameter("kmobile");
	String kpostnum = request.getParameter("kpostnum");
	String kaddr = request.getParameter("kaddr");
	String kupdatedate = request.getParameter("kupdatedate");
	
	MemberDao mdao = new MemberDaoImpl();
	MemberVO mvo = new MemberVO();
	
	mvo.setKnum(knum);
	mvo.setKname(kname);
	mvo.setKid(kid);
	mvo.setKpw(kpw);
	mvo.setKbirth(kbirth);
	mvo.setKgender(kgender);
	mvo.setKemail(kemail);
	mvo.setKmobile(kmobile);
	mvo.setKpostnum(kpostnum);
	mvo.setKaddr(kaddr);
	
	boolean bFlag = mdao.updateMember(mvo);
	ArrayList<MemberVO> alist = mdao.searchMember(mvo);
	
	if(bFlag){
%>
	<script type="text/javascript">
		alert("업데이트가 완료되었습니다.");
		location.href="searchMember.jsp?knum="+"<%=knum%>";
	</script>	
<%		
	}else{
%>	
	<script type="text/javascript">
		alert("업데이트가 완료되지 않았습니다.");
		location.href="/mvc1Project/member/signup.html";
	</script>	
<%		
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보수정</title>
	</head>
	<body>
	
	</body>
</html>