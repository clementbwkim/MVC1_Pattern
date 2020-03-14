package com.mvc1.board.dao;

import java.util.ArrayList;

import com.mvc1.board.vo.BoardVO;

public interface BoardDao {

	public int insertBoard(BoardVO bvo);
	public ArrayList<BoardVO> selectBoard();
	public ArrayList<BoardVO> searchBoard(BoardVO _bvo);
	public int updateBoard(BoardVO bvo);
	public int deleteBoard(BoardVO bvo);
	
}
