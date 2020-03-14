package com.mvc1.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mvc1.board.common.BoardChaebun;
import com.mvc1.board.common.ConnProeprty;
import com.mvc1.board.sql.BoardSqlQueryMap;
import com.mvc1.board.vo.BoardVO;

public class BoardDaoImpl implements BoardDao{

	@Override
	public int insertBoard(BoardVO bvo) {
		System.out.println("insertBoard >>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			con = ConnProeprty.getConnection();
			con.getAutoCommit();
			System.out.println("(log)con >>>" + con);
			System.out.println("(log)getAutoCommit() >>" + con.getAutoCommit());
			pstmt = con.prepareStatement(BoardSqlQueryMap.getInsertQuery());
			System.out.println("(log)pstmt >>>" + pstmt);
			System.out.println("(log)BoardSqlQueryMap.getInsertQuery() >>>" + BoardSqlQueryMap.getInsertQuery());
			
			pstmt.setString(1, BoardChaebun.commonNo());
			pstmt.setString(2, bvo.getKtitle());
			pstmt.setString(3, bvo.getKname());
			pstmt.setString(4, bvo.getKpw());
			pstmt.setString(5, bvo.getKcontent());
			
			cnt = pstmt.executeUpdate();
			System.out.println("(log)cnt >>>" + cnt);
			con.commit();
			ConnProeprty.connectionClose(con, pstmt);
			
		} catch (Exception e) {
			System.out.println("error >>>" + e.getMessage());
		}finally {
			ConnProeprty.connectionClose(con, pstmt);
		}
		System.out.println("insertBoard <<<");
		return cnt;
	}

	@Override
	public ArrayList<BoardVO> selectBoard() {
		System.out.println("selectBoard >>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rss = null;
		ArrayList<BoardVO> alist = null;
		BoardVO bvo = null;
		
		try {
			con = ConnProeprty.getConnection();
			con.getAutoCommit();
			System.out.println("(log)con >>>" + con);
			System.out.println("(log)getAutoCommit() >>" + con.getAutoCommit());
			pstmt = con.prepareStatement(BoardSqlQueryMap.getSelectQuery());
			System.out.println("(log)pstmt >>>" + pstmt);
			System.out.println("(log)BoardSqlQueryMap.getSelectQuery() >>>" + BoardSqlQueryMap.getSelectQuery());
			rss = pstmt.executeQuery();
			System.out.println("(log)rss >>>" + rss);
			
			if(rss != null) {
				alist = new ArrayList<BoardVO>();
				while(rss.next()) {
					bvo = new BoardVO();
					bvo.setKno(rss.getString("KNO"));
					bvo.setKtitle(rss.getString("KTITLE"));
					bvo.setKname(rss.getString("KNAME"));
					bvo.setKpw(rss.getString("KPW"));
					bvo.setKcontent(rss.getString("KCONTENT"));
					bvo.setKdeleteyn(rss.getString("KDELETEYN"));
					bvo.setKinsertdate(rss.getString("KINSERTDATE"));
					bvo.setKupdatedate(rss.getString("KUPDATEDATE"));
					alist.add(bvo);
					
				}
				System.out.println("alist.size >>>" + alist.size());
			}
			ConnProeprty.connectionClose(con, pstmt, rss);
			
		} catch (Exception e) {
			System.out.println("error >>>" + e.getMessage());
		}finally {
			ConnProeprty.connectionClose(con, pstmt, rss);
		}
		System.out.println("selectBoard <<<");
		return alist;
	}

	@Override
	public ArrayList<BoardVO> searchBoard(BoardVO _bvo) {
		System.out.println("searchBoard >>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rss = null;
		ArrayList<BoardVO> alist = null;
		BoardVO bvo = null;
		
		try {
			con = ConnProeprty.getConnection();
			con.getAutoCommit();
			System.out.println("(log)con >>>" + con);
			System.out.println("(log)getAutoCommit() >>" + con.getAutoCommit());
			pstmt = con.prepareStatement(BoardSqlQueryMap.getSearcQuery());
			System.out.println("(log)pstmt >>>" + pstmt);
			System.out.println("(log)BoardSqlQueryMap.getSearcdQuery() >>>" + BoardSqlQueryMap.getSearcQuery());
			
			pstmt.setString(1, _bvo.getKno());
			rss = pstmt.executeQuery();
			System.out.println("rss >>>" + rss);
			
			if(rss != null) {
				alist = new ArrayList<BoardVO>();
				while(rss.next()) {
					bvo = new BoardVO();
					
					bvo.setKtitle(rss.getString("KTITLE"));
					bvo.setKname(rss.getString("KNAME"));
					bvo.setKpw(rss.getString("KPW"));
					bvo.setKcontent(rss.getString("KCONTENT"));
					bvo.setKdeleteyn(rss.getString("KDELETEYN"));
					bvo.setKinsertdate(rss.getString("KINSERTDATE"));
					bvo.setKupdatedate(rss.getString("KUPDATEDATE"));
					bvo.setKno(rss.getString("KNO"));
					alist.add(bvo);
				}
			}
			ConnProeprty.connectionClose(con, pstmt, rss);
		} catch (Exception e) {
			System.out.println("error >>>" + e.getMessage());
		}finally {
			ConnProeprty.connectionClose(con, pstmt, rss);
		}
		System.out.println("searchBoard <<<");
		return alist;
	}

	@Override
	public int updateBoard(BoardVO bvo) {
		System.out.println("updateBoard >>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			con = ConnProeprty.getConnection();
			con.getAutoCommit();
			System.out.println("(log)con >>>" + con);
			System.out.println("(log)getAutoCommit() >>" + con.getAutoCommit());
			pstmt = con.prepareStatement(BoardSqlQueryMap.getUpdateQuery());
			System.out.println("(log)pstmt >>>" + pstmt);
			System.out.println("(log)BoardSqlQueryMap.getUpdateQuery() >>>" + BoardSqlQueryMap.getUpdateQuery());
			
			pstmt.setString(1, bvo.getKtitle());
			pstmt.setString(2, bvo.getKname());
			pstmt.setString(3, bvo.getKcontent());
			pstmt.setString(4, bvo.getKno());
			
			cnt = pstmt.executeUpdate();
			System.out.println("cnt >>>" + cnt);
			con.commit();
			
		} catch (Exception e) {
			System.out.println("error >>>" + e.getMessage());
		}finally {
			ConnProeprty.connectionClose(con, pstmt);
		}
		System.out.println("updateBoard <<<");
		return cnt;
	}

	@Override
	public int deleteBoard(BoardVO bvo) {
		System.out.println("deleteBoard >>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		System.out.println(">>>"+bvo.getKno());
		
		try {
			con = ConnProeprty.getConnection();
			con.getAutoCommit();
			System.out.println("(log)con >>>" + con);
			System.out.println("(log)getAutoCommit() >>" + con.getAutoCommit());
			pstmt = con.prepareStatement(BoardSqlQueryMap.getDeleteQuery());
			System.out.println("(log)pstmt >>>" + pstmt);
			System.out.println("(log)BoardSqlQueryMap.getDeleteQuery() >>>" + BoardSqlQueryMap.getDeleteQuery());
			
			pstmt.setString(1, bvo.getKno());
			
			cnt = pstmt.executeUpdate();
			System.out.println("cnt >>>" + cnt);
			con.commit();
			
		} catch (Exception e) {
			System.out.println("error >>>" + e.getMessage());
		}finally {
			ConnProeprty.connectionClose(con, pstmt);
		}
		System.out.println("deleteBoard <<<");
		return cnt;
	}

	
	
}
