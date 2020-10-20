package com.kh.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import static com.kh.mybatis.common.Template.*;
import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

public class MemberServiceImpl implements MemberService {
	
	//기존에는 사용자가 요청할때마다 new MemberDao()를 했었다!!
	// 왜? MemberDao기본생성자에 기술되어있는 내용(sql문들을 담는 파일을 읽어들이는 구문)을 
	// 실시간으로 매번 실행하기 위해서!!
	// 근데 이제부터는 안할꺼기 때문에 new MemberDao() 객체 생성구문자체를 전역변수로 한번만 정의해두자!
	
	private MemberDao mDao = new MemberDao(); 

	@Override
	public int insertMember(Member m) {
		SqlSession sqlSession = /*Template.*/getSqlSession(); 
		
		int result = mDao.insertMember(sqlSession, m);
		
		if(result>0) {
			sqlSession.commit(); 
		}
		sqlSession.close(); 
		
		return result;
	}

	@Override
	public Member loginMember(Member m) {
		SqlSession sqlSession = getSqlSession();
		
		Member loginUser = mDao.loginMember(sqlSession, m); 
		
		sqlSession.close(); 
		return loginUser;
	}

	@Override
	public int updateMember(Member m) {
		return 0;
	}

	@Override
	public int deleteMember(Member m) {
		return 0;
	}

}
