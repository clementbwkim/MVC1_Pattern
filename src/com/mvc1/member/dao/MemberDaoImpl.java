package com.mvc1.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mvc1.member.common.ConnProperty;
import com.mvc1.member.common.MemberChaebun;
import com.mvc1.member.sql.MemberSqlQueryMap;
import com.mvc1.member.vo.MemberVO;

public class MemberDaoImpl implements MemberDao{

	//insert
	@Override
	public boolean insertMember(MemberVO mvo) {
		System.out.println("(log)insertMember >>>");
		
		//초기화
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			
			//DB연결
			con = ConnProperty.getConnection();
			con.getAutoCommit();
			System.out.println("(log)con >>> " + con);
			
			//쿼리가져오기
			System.out.println("(log)con.getAutoCommit >>> " + con.getAutoCommit());
			pstmt = con.prepareStatement(MemberSqlQueryMap.getInsertQuery());
			System.out.println("(log)pstmt >>> " + pstmt);
			System.out.println("(log)MemberSqlQueryMap.getInsertQuery() >>> " + MemberSqlQueryMap.getInsertQuery());
			
			//set으로 초기화 후 get으로 리턴
			pstmt.setString(1, MemberChaebun.commonNo());
			pstmt.setString(2, mvo.getKname());
			pstmt.setString(3, mvo.getKid());
			pstmt.setString(4, mvo.getKpw());
			pstmt.setString(5, mvo.getKbirth());
			pstmt.setString(6, mvo.getKgender());
			pstmt.setString(7, mvo.getKemail());
			pstmt.setString(8, mvo.getKmobile());
			pstmt.setString(9, mvo.getKpostnum());
			pstmt.setString(10, mvo.getKaddr());
			
			//cnt에 결과값 담기 
			cnt = pstmt.executeUpdate();
			System.out.println("cnt >>> " + cnt);
			
			//결과값을 담았으니 commit을 true로 변경 
			boolean b = !con.getAutoCommit();
			System.out.println("b >>> " + b);
			
			//DB커밋 
			if(!con.getAutoCommit()) con.commit();
			
			//DB연결 닫기
			ConnProperty.connectionClose(con, pstmt);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error >>> " + e.getMessage());
		}finally {
			
			//연결닫기 
			ConnProperty.connectionClose(con, pstmt);
		}
		
		//리턴값이 0일 경우 false를 리턴한다
		if(cnt == 0) return false;
		System.out.println("(log)insertMember <<<");

		return true;
		
	}

	
	//update
	@Override
	public boolean updateMember(MemberVO mvo) {
		System.out.println("(log) >>> updateMember");
		
		//초기화
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			
			//연결하기
			con = ConnProperty.getConnection();
			con.getAutoCommit();
			System.out.println("(log)con >>> " + con);
			System.out.println("(log)con.getAutoCommit >>> " + con.getAutoCommit());
			
			//pstmt에 해당 쿼리문을 불러와서 담는다
			pstmt = con.prepareStatement(MemberSqlQueryMap.getUpdateQuery());
			System.out.println("(log)pstmt >>> " + pstmt);
			System.out.println("(log)MemberSqlQueryMap.getUpdateQuery() >>> " + MemberSqlQueryMap.getUpdateQuery());
			
			//set으로 초기화 후 get으로 리턴 > 수정할 항목들을 셋
			pstmt.setString(1, mvo.getKname());
			pstmt.setString(2, mvo.getKid());
			pstmt.setString(3, mvo.getKpw());
			pstmt.setString(4, mvo.getKbirth());
			pstmt.setString(5, mvo.getKgender());
			pstmt.setString(6, mvo.getKemail());
			pstmt.setString(7, mvo.getKmobile());
			pstmt.setString(8, mvo.getKpostnum());
			pstmt.setString(9, mvo.getKaddr());
			
			//쿼리문에서 작성한 것처럼 해당 knum으로 데이터를 찾고 위 항목들을 수정한다.
			pstmt.setString(10, mvo.getKnum());
			System.out.println("mvo.toString >>> " + mvo.toString());
			
			//cnt에 결과값 담기
			cnt = pstmt.executeUpdate();
			System.out.println("(log)cnt >>> " + cnt);
			boolean b = !con.getAutoCommit(); con.commit();
			
			//연결닫기 
			ConnProperty.connectionClose(con, pstmt);
			
		} catch (Exception e) {
			System.out.println("error >>> " + e.getMessage());
		}finally {
			
			//연결닫기 
			ConnProperty.connectionClose(con, pstmt);
		}
		
		//결과값이 0일 경우 false를 리턴한다
		if(cnt == 0) return false;
		
		System.out.println("(log)updateMember <<< ");
		return true;
	}

	//delete
	@Override
	public boolean deleteMember(MemberVO _mvo) {
		System.out.println("(log)deleteMember>>> ");
		
		//초기화
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			
			//DB연결하기
			con = ConnProperty.getConnection();
			con.getAutoCommit();
			System.out.println("(log)con >>> " + con);
			System.out.println("(log)con.getAutoCommit >>> " + con.getAutoCommit());
			
			//pstmt에 해당쿼리문을 불러와서 담는다
			pstmt = con.prepareStatement(MemberSqlQueryMap.getDeleteQuery());
			System.out.println("(log)pstmt >>> " + pstmt);
			System.out.println("(log)MemberSqlQueryMap.getDeleteQuery() >>> " + MemberSqlQueryMap.getDeleteQuery());
			
			//set으로 초기화하고 get으로 리턴한다 > 쿼리문에 작성된 대로 knum으로 데이터를 찾아올 것이므로 플레이스 홀더가 있는 항목만 set, get한다 
			pstmt.setString(1, _mvo.getKnum());
			
			//결과값을 cnt에 담는다
			cnt = pstmt.executeUpdate();
			System.out.println("(log)cnt >>> " + cnt);
			boolean b = !con.getAutoCommit(); con.commit();
			
			//연결닫기
			ConnProperty.connectionClose(con, pstmt);
			
		} catch (Exception e) {
			System.out.println("error >>> " + e.getMessage());
		}finally {
			
			//연결닫기
			ConnProperty.connectionClose(con, pstmt);
		}
		if(cnt ==0) return false;
		System.out.println("(log)deleteMember<<< ");
		return true;
	}

	//select
	@Override
	public ArrayList<MemberVO> selectMember() { 
		System.out.println("(log)selectMember >>> ");
		
		//초기화
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rss = null;
		ArrayList<MemberVO> alist = null;
		MemberVO mvo = null;
		
		try {
			
			//DB연결
			con = ConnProperty.getConnection();
			System.out.println("con >>> " + con);
			
			//pstmt에 해당쿼리문을 불러오고 담는다
			pstmt = con.prepareStatement(MemberSqlQueryMap.getSelectQuery());
			System.out.println("pstmt >>> " + pstmt);
			
			//rss에 결과값을 담는다
			rss = pstmt.executeQuery();
			System.out.println("rss >>> " + rss);
			
			//rss가 null이 아니면 실행
			if(rss !=null) {
				
				//alist를 인스턴스한다
				alist = new ArrayList<MemberVO>();
				
				//while문, 무한반복문으로  rss에 담긴 값들을 불러온다
				while(rss.next()) {
					
				//값을 담기위해 mvo를 인스턴스한다
				mvo = new MemberVO();
				
				//mvo에 set으로 초기화 후 get으로 담는다
				mvo.setKnum(rss.getString("KNUM"));
				mvo.setKname(rss.getString("KNAME"));
				mvo.setKid(rss.getString("KID"));
				mvo.setKpw(rss.getString("KPW"));
				mvo.setKbirth(rss.getString("KBIRTH"));
				mvo.setKgender(rss.getString("KGENDER"));
				mvo.setKemail(rss.getString("KEMAIL"));
				mvo.setKmobile(rss.getString("KMOBILE"));
				mvo.setKpostnum(rss.getString("KPOSTNUM"));
				mvo.setKaddr(rss.getString("KADDR"));
				mvo.setKdeleteyn(rss.getString("KDELETEYN"));
				mvo.setKinsertdate(rss.getString("KINSERTDATE"));
				mvo.setKupdatedate(rss.getString("KUPDATEDATE"));
				alist.add(mvo);
				}
				System.out.println("(log) alist.size >>> " + alist.size());
			}
		} catch (Exception e) {
			System.out.println("error >>> " + e.getMessage());
		}finally {
			
			//연결닫기
			ConnProperty.connectionClose(con, pstmt, rss);
		}
		System.out.println("(log)selectMember <<< ");
		
		//결과값을 alist으로 리턴한다
		return alist;
	}

	//search
	@Override
	public ArrayList<MemberVO> searchMember(MemberVO _mvo) {
		System.out.println("(log)searchMember >>> ");
		
		//초기화
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rss = null;
		ArrayList<MemberVO> alist = null;
		MemberVO mvo = null;
		
		try {
			
			//DB연결
			con = ConnProperty.getConnection();
			System.out.println("(log)con >>> " + con);
			
			//pstmt에 해당쿼리문을 불러오고 담는다
			pstmt = con.prepareStatement(MemberSqlQueryMap.getSearchQuery());
			System.out.println("(log)pstmt >>> " + pstmt);
			System.out.println("(log)MemberSqlQueryMap.getSearchQuery() >>> " + MemberSqlQueryMap.getSearchQuery());
			
			//쿼리문에 작성한 검색할 항목을 pstmt에 set으로 초기화 후 get으로 리턴한다
			pstmt.setString(1, _mvo.getKnum());
			
			//rss에 결과값을 담는다
			rss = pstmt.executeQuery();
			System.out.println("(log)rss >>> " + rss);
			
			//rss가 null이 아니면 실행
			if(rss != null) {
				
				//alist를 인스턴스한다.
				alist = new ArrayList<MemberVO>();
				System.out.println("(log)alist >>> " + alist);
				
				//무한 반복문을 통해 담긴 모든 값을 불러온다
				while(rss.next()) {
					
					//값을 담기위해 mvo를 인스턴스한다
					mvo = new MemberVO();
					
					//set으로 초기화 후 get으로 리턴한다
					mvo.setKnum(rss.getString("KNUM"));
					mvo.setKname(rss.getString("KNAME"));
					mvo.setKid(rss.getString("KID"));
					mvo.setKpw(rss.getString("KPW"));
					mvo.setKbirth(rss.getString("KBIRTH"));
					mvo.setKgender(rss.getString("KGENDER"));
					mvo.setKemail(rss.getString("KEMAIL"));
					mvo.setKmobile(rss.getString("KMOBILE"));
					mvo.setKpostnum(rss.getString("KPOSTNUM"));
					mvo.setKaddr(rss.getString("KADDR"));
					mvo.setKdeleteyn(rss.getString("KDELETEYN"));
					mvo.setKinsertdate(rss.getString("KINSERTDATE"));
					mvo.setKupdatedate(rss.getString("KUPDATEDATE"));
					
					//alist에 담는다
					alist.add(mvo);
				}
			}
			
			//연결닫기
			ConnProperty.connectionClose(con, pstmt, rss);
		} catch (Exception e) {
			System.out.println("error >>> " + e.getMessage());
		}finally {
			
			//연결닫기
			ConnProperty.connectionClose(con, pstmt, rss);
		}
		System.out.println("(log)searchMember <<< ");
		
		//결과값을 alist로 리턴한다
		return alist;
	}

	//likeSearch
	@Override
	public ArrayList<MemberVO> likeSearchMember(MemberVO _mvo) {
		System.out.println("(log)likeSearchMember >>> ");
		
		//초기화
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rss = null;
		ArrayList<MemberVO> alist = null;
		MemberVO mvo = null;
		
		try {
			
			//DB연결
			con = ConnProperty.getConnection();
			System.out.println("(log)con >>> " + con);
			
			//pstmt에 쿼리문을 불러오고 담는다
			pstmt = con.prepareStatement(MemberSqlQueryMap.getlikeSearchQuery());
			System.out.println("(log)pstmt >>> " + pstmt);
			System.out.println("(log)MemberSqlQueryMap.getlikeSearchQuery() >>> " + MemberSqlQueryMap.getlikeSearchQuery());
			
			//쿼리문에 작성된 WHERE, 이름으로 검색하기 위해 mvo.getKname()을 set으로 초기화하고 get으로 리턴한다
			pstmt.setString(1, _mvo.getKname());
			rss = pstmt.executeQuery();
			System.out.println("(log)rss >>> " + rss);
			
			if(rss != null) {
				
				//alist를 인스턴스한다
				alist = new ArrayList<MemberVO>();
				while(rss.next()) {
					
					//값을 담기위해 mvo를 인스턴스한다
					mvo = new MemberVO();
					mvo.setKnum(rss.getString("KNUM"));
					mvo.setKname(rss.getString("KNAME"));
					mvo.setKid(rss.getString("KID"));
					mvo.setKpw(rss.getString("KPW"));
					mvo.setKbirth(rss.getString("KBIRTH"));
					mvo.setKgender(rss.getString("KGENDER"));
					mvo.setKemail(rss.getString("KEMAIL"));
					mvo.setKmobile(rss.getString("KMOBILE"));
					mvo.setKpostnum(rss.getString("KPOSTNUM"));
					mvo.setKaddr(rss.getString("KADDR"));
					mvo.setKdeleteyn(rss.getString("KDELETEYN"));
					mvo.setKinsertdate(rss.getString("KINSERTDATE"));
					mvo.setKupdatedate(rss.getString("KUPDATEDATE"));
					
					//alist에 담을 값을 담는다
					alist.add(mvo);
				}
				System.out.println("alist.size() >>> " + alist.size());
			}
		} catch (Exception e) {
			System.out.println("error >>> " + e.getMessage());
		}finally {
			
			//연결닫기
			ConnProperty.connectionClose(con, pstmt, rss);
		}
		System.out.println("(log)likeSearchMember <<< ");
		
		//alist를 리턴한다
		return alist;
	}

	//login
	@Override
	public ArrayList<MemberVO> loginMember(MemberVO _mvo) {
		System.out.println("(log)loginMember >>> ");
		
		//초기화
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rss = null;
		ArrayList<MemberVO> alist = null;
		MemberVO mvo = null;
		
		try {
			
			//DB연결
			con = ConnProperty.getConnection();
			System.out.println("(log)con >>>" + con);
			
			//pstmt에 해당쿼리문을 불러오고 담는다
			pstmt = con.prepareStatement(MemberSqlQueryMap.getLoginQuery());
			System.out.println("(log)pstmt >>> " + pstmt);
			System.out.println("(log)MemberSqlQueryMap.getLoginQuery() >>> " + MemberSqlQueryMap.getLoginQuery());
			
			//로그인에 필요한 id와 pw를 set으로 초기화하고 get으로 리턴한다
			pstmt.setString(1, _mvo.getKid());
			pstmt.setString(2, _mvo.getKpw());
			
			//결과값을 담는다
			rss = pstmt.executeQuery();
			System.out.println("(log)rss >>> " + rss);
			
			//rss 결과값이 null이 아닐 떄 실행
			if(rss != null) {
				
				//alist를 인스턴스한다
				alist = new ArrayList<MemberVO>();
				while(rss.next()) {
					
					//값을 담기위해 mvo를 인스턴스한다
					mvo = new MemberVO();
					mvo.setKnum(rss.getString("KNUM"));
					mvo.setKname(rss.getString("KNAME"));
					mvo.setKid(rss.getString("KID"));
					mvo.setKpw(rss.getString("KPW"));
					mvo.setKbirth(rss.getString("KBIRTH"));
					mvo.setKgender(rss.getString("KGENDER"));
					mvo.setKemail(rss.getString("KEMAIL"));
					mvo.setKmobile(rss.getString("KMOBILE"));
					mvo.setKpostnum(rss.getString("KPOSTNUM"));
					mvo.setKaddr(rss.getString("KADDR"));
					mvo.setKdeleteyn(rss.getString("KDELETEYN"));
					mvo.setKinsertdate(rss.getString("KINSERTDATE"));
					mvo.setKupdatedate(rss.getString("KUPDATEDATE"));
					
					//alist에 값은 담는다
					alist.add(mvo);
				}
				System.out.println("alist.size() >>> " + alist.size());
			}
		} catch (Exception e) {
			System.out.println("error >>> " + e.getMessage());
		}finally {
			
			//연결닫기
			ConnProperty.connectionClose(con, pstmt, rss);
		}
		System.out.println("(log)loginMember <<< ");
		
		//alist를 리턴한다
		return alist;
	}
}
