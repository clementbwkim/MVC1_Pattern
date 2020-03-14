<%@page import="com.mvc1.member.vo.MemberVO"%>
<%@page import="org.apache.catalina.tribes.membership.MemberImpl"%>
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
	
	if(isudType != null){
		System.out.println("isudType >>>" + isudType);
		boolean b = "U".equals(isudType.toUpperCase());
		
		if(b){
			BoardDao bdao = new BoardDaoImpl();
			BoardVO bvo = new BoardVO();
			bvo.setKno(chkInKno);
			
			ArrayList<BoardVO> alist = bdao.searchBoard(bvo);
			int cnt = alist.size();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>글수정</title>
		<script type="text/javascript">
			function brdupdateFunction(val){
				var value = val;
				
				if('UOK' == value){
					document.brdupdate.action="/mvc1Project/board/updateOKBoard.jsp";
				}
				if('S' == value){
					document.brdupdate.action="/mvc1Project/board/selectBoard.jsp";
				}
				document.brdupdate.submit();
			}
		</script>
	</head>
	<body>
		<form name="brdupdate" id="brdupdate" method="post">
<%
	if(cnt > 0){
		for(int i = 0; i < cnt; i++){
			bvo = alist.get(i);
%>
			<table border="1">
				<tr>
					<td colspan="2">글수정</td>
				</tr>
				<tr>
					<td>글번호</td>
					<td><input type="text" name="kno" id="kno" readonly="readonly" value="<%=bvo.getKno() %>"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="ktitle" id="ktitle" value="<%=bvo.getKtitle() %>"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="kname" id="kname" value="<%=bvo.getKname() %>"></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td><input type="text" name="kinsertdate" id="kinsertdate" readonly="readonly" value="<%=bvo.getKinsertdate() %>"></td>
				</tr>
				<tr>
					<td>수정일</td>
					<td><input type="text" name="kupdatedate" id="kupdatedate" readonly="readonly" value="<%=bvo.getKupdatedate() %>"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><input type="text" name="kcontent" id="kcontent"  value="<%=bvo.getKcontent() %>"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="kpw" id="kpw" value="<%=bvo.getKpw() %>">
						<input type="button" id="rkpw" name="rkpw" value="비밀번호 확인">
					</td>
				</tr>
<%
				}	
%>
				<tr>
					<td colspan="2">
					<input type="hidden" name="ISUD_TYPE" value="UOK">
					<input type="button" value="수정하기" onclick="brdupdateFunction('UOK')">
					<input type="button" value="글목록" onclick="brdupdateFunction('S')">
					</td>
				</tr>
						
			</table>
		</form>


<%	
	}
%>			
<%		
		}
	}
%>
	</body>
</html>