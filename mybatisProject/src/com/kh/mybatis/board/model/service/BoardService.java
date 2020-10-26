package com.kh.mybatis.board.model.service;

import java.util.ArrayList;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.board.model.vo.SearchCondition;
import com.kh.mybatis.common.vo.PageInfo;

public interface BoardService {

	//1. 게시판리스트 조회용서비스
	//1-1. 총 게시글 개수 조회
	int selectListCount();
	
	//1-2. 사용자가 요청한 페이지에 뿌려줄 게시글리스트 조회
	ArrayList<Board> selectList(PageInfo pi); 
	
	//2. 게시판 검색용 서비스
	//2-1. 검색 결과에 해당하는 게시글 갯수 조회
	int selectSearchListCount(SearchCondition sc);
	//2-2. 검색결과 페이지에 뿌려줄 게시글 리스트 조회 
	ArrayList<Board> selectSearchList(SearchCondition sc, PageInfo pi);
	
	// 3.게시판 상세조회용 서비스
	// 3_1. 해당 게시글 조회수 증가
		int updateCount(int bno);
	// 3_2. 해당 게시글 조회
		Board selectBoard(int bno);
	// 3_3. 해당 게시글에 딸려있는 댓글리스트 조회 
		ArrayList<Reply> selectReplyList(int bno);
	
}
