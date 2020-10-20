package com.kh.mybatis.member.model.service;

import com.kh.mybatis.member.model.vo.Member;

public interface MemberService { //모든 필드 == 상수필드, 모든메소드 == 추상메소드(미완성된 메소드)
	
	// MemberService라는 인터페이스를 실체화(implements)하는 자식 클래스에서 본격적으로 완성 시켜야됨
	
	//1. 회원가입 서브스
	/*public abstract*/ int insertMember(Member m); //abstract(추상)--> 몸통이 비어있는 // 앞에 샹략 가능 해도 추상메소드로 됨. 
		
	//2. 로그인용 서비스
	Member loginMember(Member m); // id&pwd가 담긴 Member객체 사용
	
	//3. 회원정보수정용 서비스
	int updateMember(Member m); 
	
	//4. 회원탈퇴용 서비스
	int deleteMember(Member m);
	
	//5. id찾기용 서비스
	
	
	//6. pwd변경용 서비스

}
