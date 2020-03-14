<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.mvc1.board.dao.BoardDao" %>
<%@ page import="com.mvc1.board.dao.BoardDaoImpl" %>
<%@ page import="com.mvc1.board.vo.BoardVO" %>
<%@ page import="java.util.ArrayList" %>
<%
	request.setCharacterEncoding("UTF-8");

	BoardDao bdao = new BoardDaoImpl();
	BoardVO bvo = new BoardVO();
	ArrayList<BoardVO> alist = bdao.selectBoard();
	int cnt = alist.size();
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>글목록</title>
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
		<script type="text/javascript">
		function brdFunction(val){
			var value = val;
			
			if('I' == value){
				document.slcform.action = "/mvc1Project/board/board.html";
			}
			if('S' == value){
				document.slcform.ISUD_TYPE.value = "S";
				document.slcform.action = "/mvc1Project/board/selectBoard.jsp";
			}
			if('U' == value){
				document.slcform.ISUD_TYPE.value = "U";
				document.slcform.action = "/mvc1Project/board/updateBoard.jsp";
			}
			if('D' == value){
				document.slcform.ISUD_TYPE.value = "D";
				document.slcform.action = "/mvc1Project/board/deleteBoard.jsp";
			}
			
			document.slcform.submit();
		}
		
		</script>
	</head>
	<body>
		<form id="slcform" name="slcform" method="post">
			<table border="1">
				<thead>
					<tr>
						<td colspan="10">
							<input type="button" value="글쓰기" id="ibtn" onclick="brdFunction('I')">
							<input type="button" value="글목록" id="sbtn" onclick="brdFunction('S')">
							<input type="button" value="글수정" id="ubtn" onclick="brdFunction('U')">
							<input type="button" value="글삭제" id="dbtn" onclick="brdFunction('D')">
						</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="checkall" ></td>
						<td>글번호</td>
						<td>제목</td>
						<td>이름</td>
						<td>비밀번호</td>
						<td>내용</td>
						<td>등록일</td>
						<td>수정일</td>
					</tr>
				</thead>
<%
				for(int i = 0; i < cnt; i++){
					bvo = alist.get(i);
%>
				<tbody>
					<tr>
						<td><input type="checkbox" name="chkInKno" id="" value="<%= bvo.getKno()%>" onclick="chkOnly(this)"></td>
						<td><%=bvo.getKno() %></td>
						<td><%=bvo.getKtitle() %></td>
						<td><%=bvo.getKname() %></td>
						<td><%=bvo.getKpw() %></td>
						<td><%=bvo.getKcontent() %></td>
						<td><%=bvo.getKinsertdate() %></td>
						<td><%=bvo.getKupdatedate() %></td>
					</tr>
<%					
				}
%>
					<tr>
						<td colspan="10">
							<input type="hidden" name="ISUD_TYPE">
							<input type="button" value="글쓰기" id="ibtn" onclick="brdFunction('I')">
							<input type="button" value="글목록" id="sbtn" onclick="brdFunction('S')">
							<input type="button" value="글수정" id="ubtn" onclick="brdFunction('U')">
							<input type="button" value="글삭제" id="dbtn" onclick="brdFunction('D')">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>