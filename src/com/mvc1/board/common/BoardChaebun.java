package com.mvc1.board.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mvc1.board.sql.BoardSqlQueryMap;
import com.mvc1.member.common.ConnProperty;

public abstract class BoardChaebun {
	
	public static String commonNo() {
		System.out.println("commonNo() >>> ");
		
		//DB와 쿼리문을 연결할 변수들을 null로 초기화
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rss = null;
		
		String comNo = "";
		
		try {
			
			//DB연결
			con = ConnProperty.getConnection();
			System.out.println("connected >>>");
			
			//pstmt에 MemberSqlQueryMap.MEMBER_KNUM_CHAEBUNd 함수호출
			pstmt = con.prepareStatement(BoardSqlQueryMap.BOARD_KNO_CHAEBUNN);
			System.out.println("BoardSqlQueryMap.BOARD_KNO_CHAEBUNN >>> " + pstmt);
			
			//결과값을 rss에 담기
			rss = pstmt.executeQuery();
			System.out.println(" chaebun >>> " + BoardSqlQueryMap.BOARD_KNO_CHAEBUNN);
			System.out.println("rss >>> " + rss);
			
			//DATA null값 체크
			if(rss != null) {
				while(rss.next()) {
					comNo = rss.getString("comNo");
				}
			}
			System.out.println("comNo >>>" + comNo);
			System.out.println("comNo.length >>> " + comNo.length());
			
			if(1 == comNo.length()) {
				comNo = "00" + comNo;
			}
			if(2 == comNo.length()) {
				comNo = "0" + comNo;
			}
			System.out.println("comNo >>> " + comNo);
			
			//참조변수 b 선언 후 인스턴스 
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			System.out.println("sdf >>> " + sdf);
			
			//변수 선언 후 함수 
			String date = sdf.format(d);
			System.out.println("date >>> " + date);
			
			comNo = "B" + date + comNo;
			
			System.out.println("comNo >>>" + comNo);
			
			//연결 닫기
			ConnProperty.connectionClose(con, pstmt);
	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error >>> " + e.getMessage());
		}finally {
			try {
				
				//연결닫기 
				ConnProperty.connectionClose(con, pstmt);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		System.out.println("commonNo() <<< ");
		
		//조합된 채번 리던하기
		return comNo;
		
	}
	
	 public static void main(String args[]) { BoardChaebun.commonNo();
	 	System.out.println("commonNo >> " + BoardChaebun.commonNo()); }
}