package com.kh.mybatis.board.model.service;

import java.util.ArrayList;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.vo.PageInfo;

public interface BoardService {

	//1. 게시판리스트 조회용서비스
	//1-1. 총 게시글 개수 조회
	int selectListCount();
	
	//1-2. 사용자가 요청한 페이지에 뿌려줄 게시글리스트 조회
	ArrayList<Board> selectList(PageInfo pi); 
	
}
