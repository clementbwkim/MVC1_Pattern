package com.mvc1.member.dao;

import java.util.ArrayList;

import com.mvc1.member.vo.MemberVO;

public interface MemberDao {
	//insert, update, delete
	public boolean insertMember(MemberVO mvo);
	public boolean updateMember(MemberVO mvo);
	public boolean deleteMember(MemberVO mvo);
	
	//select, search, likeSearch
	public ArrayList<MemberVO> selectMember();
	public ArrayList<MemberVO> searchMember(MemberVO mvo);
	public ArrayList<MemberVO> likeSearchMember(MemberVO mvo);
	
	//login
	public ArrayList<MemberVO> loginMember(MemberVO mvo);
	
	
}
