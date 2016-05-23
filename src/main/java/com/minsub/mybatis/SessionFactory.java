package com.minsub.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	private static SqlSession session =null;
	
	static {
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
		    sqlSessionFactory  = new SqlSessionFactoryBuilder().build(reader);
	        session = sqlSessionFactory .openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession() {
		return session;
	}
	
}
