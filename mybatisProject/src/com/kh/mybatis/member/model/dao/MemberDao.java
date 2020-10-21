package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {
	
	public int insertMember(SqlSession sqlSession, Member m) {
		// sqlSession 객체에서 제공하는 어떤메소드를 통해서 실행한 후 결과값 바로 받아낼꺼임!!
		// insert("실행할sql문을 찾을구문"[, 실행할 sql문을 완성시킬객체]);
		// 첫번째 인자값 : sql문이 존재하는 "매퍼의별칭.해당실행할sql문의아이디"
		// [두번쨰 인가값 : 해당 미완성된 sql문을 완성시킬 객체]
		
		// 유의할점! : 해당 mapper파일 mybatis-config문서에 등록되어야됨!!(안 그럼 찾을수 없음)
		//int result = sqlSession.insert("memberMapper.insertMember", m);
		//return result; 
		
		return sqlSession.insert("memberMapper.insertMember", m);
	}

	public Member loginMember(SqlSession sqlSession, Member m) {
		
		//Member loginUser = sqlSession.selectOne("memberMapper.loginMember", m);
		//return loginUser;
		return sqlSession.selectOne("memberMapper.loginMember", m); 
		// selectOne 만약없나면 null 반환
	}

}
