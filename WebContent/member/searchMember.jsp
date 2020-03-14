<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mvc1.member.dao.MemberDao" %>
<%@ page import="com.mvc1.member.dao.MemberDaoImpl" %>
<%@ page import="com.mvc1.member.vo.MemberVO" %>
<%@ page import="java.util.ArrayList" %>
<%
	request.setCharacterEncoding("UTF-8");
	
	String knum = request.getParameter("knum");
	MemberDao mdao = new MemberDaoImpl();
	MemberVO _mvo = new MemberVO();
	_mvo.setKnum(knum);
	
	
	ArrayList<MemberVO> alist = mdao.searchMember(_mvo);
	
	if(alist.size() == 0){
%>
	<script type="text/javascript">
		alert("조회를 실패했습니다.");
		location.href="/mvc1Project/member/signup.html";
	</script>
<%		
	}else{
%>
	<script type="text/javascript">
		alert("조회를 완료했습니다.");
	</script>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보 검색</title>
	</head>
	<body>
		<table border="1">
			<tr>
				<th colspan="13"><h3>회원정보</h3></th>
			</tr>
			<tr>
				<td>회원번호</td>
				<td>이름</td>
				<td>ID</td>
				<td>생년월일</td>
				<td>성별</td>
				<td>EMAIL</td>
				<td>연락처</td>
				<td>우편번호</td>
				<td>주소</td>
				<td>삭제여부</td>
				<td>등록일</td>
				<td>수정일</td>
			</tr>
<%				for(int i = 0; i < alist.size(); i++){
				MemberVO mvo = alist.get(i);
%>
		<tr>
			<td><%=mvo.getKnum() %></td>
			<td><%=mvo.getKname() %></td>
			<td><%=mvo.getKid() %></td>
			<td><%=mvo.getKbirth() %></td>
			<td><%=mvo.getKgender() %></td>
			<td><%=mvo.getKemail() %></td>
			<td><%=mvo.getKmobile() %></td>
			<td><%=mvo.getKpostnum() %></td>
			<td><%=mvo.getKaddr() %></td>
			<td><%=mvo.getKdeleteyn() %></td>
			<td><%=mvo.getKinsertdate() %></td>
			<td><%=mvo.getKupdatedate() %></td>
		</tr>
<%	
	}
}
%>	
		</table>
	</body>
</html>