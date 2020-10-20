package com.kh.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {

	//기존의 JDBCTemplate 같은 존재
	
	//DB와 접속된 객체를 반환해주는 메소드
	/*
	public static Connection getConnection() {
		
	}
	*/
	
	public static SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		
		/*
		 * 어떤 DBMS에, 어떤 url에, 어떤 계정에, 어떤 비밀번호에 접속할건지에 대한 애용을 기존에 driver.properties 문서에 정의했다면
		 * 기존에는 src/sql/driver/driver.properties 문서에 정의했다면
		 * 
		 * myBatis 프래임워크를 쓰고자 할때는 그 내용을 resources/mybatis-config.xml이라는 문서에 정의할꺼임 
		 * 환경설정파일이라고 해서 주로 config파일이라고 함
		 * 
		 */
		
		//읽어 들이고자하는 외부문서(mybatis-config.xml)와의 통로
		// 마이바티스에서 제공하는 util성 클래스인 Resources라는 클래스를 가지고 파일 불러오기  ** / 가 가리 키는게 src folder
		try {
			InputStream stream = Resources.getResourceAsStream("/mybatis-config.xml");
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false); 
			//transaction 우리기 직접 수동으로 하기 때문 .openSession(false) 주어야 한다
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession; 
	}
	
	// commit(), rollback(), close() 메소드는 안 만드나요
	// YES!! -> 왜? SqlSession객체에서 제공하고 있는 메소드 호출만으로 해결가능
}
