package com.mvc1.member.sql;

public abstract class MemberSqlQueryMap {
	
	//SUBSTR 이용해서 쪼개기
	public static final String MEMBER_KNUM_CHAEBUN = 
			"SELECT NVL(MAX(SUBSTR((A.KNUM),-3)), 0) +1 COMNO FROM K_MEMBER A"; 
	
	public static String getInsertQuery() {
		
		//StringBuffer 인스턴스 후 append 사용해서 문자열을 붙인다
		StringBuffer sb = new StringBuffer();
		sb.append(" INSERT INTO K_MEMBER (   \n");
		sb.append("  KNUM					 \n");
		sb.append(" ,KNAME 					 \n");
		sb.append(" ,KID 					 \n");
		sb.append(" ,KPW 					 \n");
		sb.append(" ,KBIRTH 				 \n");
		sb.append(" ,KGENDER 				 \n");
		sb.append(" ,KEMAIL 				 \n");
		sb.append(" ,KMOBILE 				 \n");
		sb.append(" ,KPOSTNUM 				 \n");
		sb.append(" ,KADDR 					 \n");
		sb.append(" ,KDELETEYN 				 \n");
		sb.append(" ,KINSERTDATE 			 \n");
		sb.append(" ,KUPDATEDATE 			 \n");
		sb.append(" ) VALUES ( 				 \n");
		sb.append("  ?						 \n");
		sb.append(" ,? 						 \n");
		sb.append(" ,? 						 \n");
		sb.append(" ,? 						 \n");
		sb.append(" ,? 						 \n");
		sb.append(" ,? 						 \n");
		sb.append(" ,? 						 \n");
		sb.append(" ,? 						 \n");
		sb.append(" ,? 						 \n");
		sb.append(" ,? 						 \n");
		sb.append(" ,'Y' 					 \n");
		sb.append(" ,SYSDATE 				 \n");
		sb.append(" ,SYSDATE 			   ) \n");
		return sb.toString();
		//MemberSqlQueryMap getInsertQuery()
	}
	
	public static String getSelectQuery() {
		
		//StringBuffer 인스턴스 후 append 사용해서 문자열을 붙인다
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT 												\n");
		sb.append("  A.KNUM KNUM, 										\n");
		sb.append("  A.KNAME KNAME, 									\n");
		sb.append("  A.KID KID, 										\n");
		sb.append("  A.KPW KPW, 										\n");
		sb.append("  A.KBIRTH KBIRTH,									\n");
		sb.append("  A.KGENDER KGENDER, 								\n");
		sb.append("  A.KEMAIL KEMAIL, 									\n");
		sb.append("  A.KMOBILE KMOBILE, 								\n");
		sb.append("  A.KPOSTNUM KPOSTNUM,								\n");
		sb.append("  A.KADDR KADDR,	 									\n");
		sb.append("  A.KDELETEYN KDELETEYN, 							\n");
		sb.append("  A.KINSERTDATE KINSERTDATE,							\n");
		sb.append("  A.KUPDATEDATE KUPDATEDATE 							\n");
		sb.append("  FROM K_MEMBER A 									\n");
		sb.append("  WHERE A.KDELETEYN = 'Y' 							\n");
		sb.append("  ORDER BY 1 										\n");
		return sb.toString();
		//MemberSqlQueryMap getSelectQuery()
	}
	
	public static String getSearchQuery() {
		
		//StringBuffer 인스턴스 후 append 사용해서 문자열을 붙인다
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT 													\n");
		sb.append("  A.KNUM KNUM, 											\n");
		sb.append("  A.KNAME KNAME, 										\n");
		sb.append("  A.KID KID, 											\n");
		sb.append("  A.KPW KPW, 											\n");
		sb.append("  A.KBIRTH KBIRTH, 										\n");
		sb.append("  A.KGENDER KGENDER, 									\n");
		sb.append("  A.KEMAIL KEMAIL, 										\n");
		sb.append("  A.KMOBILE KMOBILE, 									\n");
		sb.append("  A.KPOSTNUM KPOSTNUM, 									\n");
		sb.append("  A.KADDR KADDR, 										\n");
		sb.append("  A.KDELETEYN KDELETEYN, 								\n");
		sb.append("  A.KINSERTDATE KINSERTDATE,								\n");
		sb.append("  A.KUPDATEDATE KUPDATEDATE 								\n");
		sb.append("  FROM K_MEMBER A 										\n");
		sb.append("  WHERE A.KNUM = ? 										\n");
		return sb.toString();
		//MemberSqlQueryMap getSearchQuery()
	}
	
	public static String getlikeSearchQuery() {
		
		//StringBuffer 인스턴스 후 append 사용해서 문자열을 붙인다
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT 													\n");
		sb.append("  A.KNUM KNUM, 											\n");
		sb.append("  A.KNAME KNAME, 										\n");
		sb.append("  A.KID KID, 											\n");
		sb.append("  A.KPW KPW, 											\n");
		sb.append("  A.KBIRTH KBIRTH, 										\n");
		sb.append("  A.KGENDER KGENDER, 									\n");
		sb.append("  A.KEMAIL KEMAIL, 										\n");
		sb.append("  A.KMOBILE KMOBILE, 									\n");
		sb.append("  A.KPOSTNUM KPOSTNUM, 									\n");
		sb.append("  A.KADDR KADDR, 										\n");
		sb.append("  A.KDELETEYN KDELETEYN, 								\n");
		sb.append("  TO_CHAR(A.KINSERTDATE, 'YYYY-MM-DD') KINSERTDATE, 	\n");
		sb.append("  TO_CHAR(A.KUPDATEDATE, 'YYYY-MM-DD') KUPDATEDATE 	\n");
		sb.append("  FROM K_MEMBER A 										\n");
		sb.append("  WHERE A.KNAME = '%' || ? || '%' 						\n");
		return sb.toString();
		//MemberSqlQueryMap getlikeSearchQuery()
	}
	
	public static String getUpdateQuery() {
		
		//StringBuffer 인스턴스 후 append 사용해서 문자열을 붙인다
		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE K_MEMBER A			\n");
		sb.append("  SET 						\n");
		sb.append("  A.KNAME = ?, 					\n");
		sb.append("  A.KID = ?, 						\n");
		sb.append("  A.KPW = ?, 						\n");
		sb.append("  A.KBIRTH = ?, 					\n");
		sb.append("  A.KGENDER = ?, 					\n");
		sb.append("  A.KEMAIL = ?, 					\n");
		sb.append("  A.KMOBILE = ?, 					\n");
		sb.append("  A.KPOSTNUM = ?, 					\n");
		sb.append("  A.KADDR = ?, 					\n");
		sb.append("  A.KUPDATEDATE = SYSDATE 		\n");
		sb.append("  WHERE A.KNUM = ? 			\n");
		sb.append("  AND A.KDELETEYN = 'Y' 		\n");
		return sb.toString();
		//MemberSqlQueryMap getUpdateQuery()
	}
	
	public static String getDeleteQuery() {
		
		//StringBuffer 인스턴스 후 append 사용해서 문자열을 붙인다
		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE K_MEMBER 			\n");
		sb.append("  SET 						\n");
		sb.append("  KDELETEYN = 'N', 			\n");
		sb.append("  KUPDATEDATE = SYSDATE 		\n");
		sb.append("  WHERE KNUM = ? 			\n");
		sb.append("  AND KDELETEYN = 'Y' 		\n");
		return sb.toString();
		//MemberSqlQueryMap getDeleteQuery()
	}
	
	public static String getLoginQuery() {
		
		//StringBuffer 인스턴스 후 append 사용해서 문자열을 붙인다
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT 												\n");
		sb.append("  A.KNUM KNUM, 											\n");
		sb.append("  A.KNAME KNAME, 										\n");
		sb.append("  A.KID KID, 											\n");
		sb.append("  A.KPW KPW, 											\n");
		sb.append("  A.KBIRTH KBIRTH, 										\n");
		sb.append("  A.KGENDER KGENDER, 									\n");
		sb.append("  A.KEMAIL KEMAIL, 										\n");
		sb.append("  A.KMOBILE KMOBILE, 									\n");
		sb.append("  A.KPOSTNUM KPOSTNUM, 									\n");
		sb.append("  A.KADDR KADDR, 										\n");
		sb.append("  A.KDELETEYN KDELETEYN, 								\n");
		sb.append("  TO_CHAR(A.KINSERTDATE, 'YYYY-MM-DD') KINSERTDATE, 	\n");
		sb.append("  TO_CHAR(A.KUPDATEDATE, 'YYYY-MM-DD') KUPDATEDATE 	\n");
		sb.append("  FROM K_MEMBER 											\n");
		sb.append("  WHERE A.KID = ? 										\n");
		sb.append("  AND A.KPW = ? 											\n");
		sb.append("  AND A.KDELETEYN = 'Y' 									\n");
		return sb.toString();
		//MemberSqlQueryMap getLoginQuery()
	}
}
