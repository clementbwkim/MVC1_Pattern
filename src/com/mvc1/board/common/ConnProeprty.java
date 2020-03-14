package com.mvc1.board.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class ConnProeprty {

		//DATA sources
	
		//드라이버 정보 
		public static final String ORACLE11G_JDBCDRIVER = "oracle.jdbc.driver.OracleDriver";
		//URL 정보 (localhost)
		public static final String ORACLE11G_URL = "jdbc:oracle:thin:@127.0.0.1:1521:orclKBW";
		//계정정보
		public static final String ORACLE11G_USER = "CLEMENT";
		public static final String ORACLE11G_PASSWORD = "205301";
		
		public static Connection getConnection() throws Exception{
			System.out.println("getConnection() >>> ");
			
			//변수선언
			Connection con = null;
			
			//Class.forName() 사용해서 정보들  url, id, pw 연결 후 변수 con에 담기
			Class.forName(ORACLE11G_JDBCDRIVER);
			con = DriverManager.getConnection(ORACLE11G_URL, ORACLE11G_USER, ORACLE11G_PASSWORD);
			System.out.println("getConnection() <<< ");
			
			//정보를 연결한 변수 con으로 리턴 
			return con;
		}
		
		//connectionClose 연결 닫는 함수 
		public static void connectionClose(Connection con, PreparedStatement pstmt, ResultSet rss){
			System.out.println("connectionClose >>> ");
			try {
				//rss가 null이 아닐 때 실행 
				if(rss!=null)try {
					
					//rss닫기
					rss.close(); rss = null;
					} catch (Exception e) {}
				if(pstmt!=null)try {
					pstmt.close(); pstmt = null;
					} catch (Exception e) {}
				if(con!=null)try {
					con.close(); con = null;
					} catch (Exception e) {}
				
			} catch (Exception e) {
			}
			System.out.println("connectionClose <<< ");
		}
		
		//connectionClose 연결 닫는 함수 
		public static void connectionClose(Connection con, PreparedStatement pstmt){
			System.out.println("connectionClose >>> ");
			try {
				//pstmt가 null이 아닐 때 실행
				if(pstmt!=null)try {
					pstmt.close(); pstmt = null;
					} catch (Exception e) {}
				if(con!=null)try {
					con.close(); con = null;
					} catch (Exception e) {}
				
			} catch (Exception e) {
			}
			System.out.println("connectionClose <<< ");
		}
	}