package com.minsub.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Main {

	public static void main(String[] args) {
	
//		test1();
//		test2();
		test3();
	}
	
	public static void test1() {
		SqlSession session = null;
		try {
			
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory  = new SqlSessionFactoryBuilder().build(reader);
             
            session = sqlSessionFactory.openSession();
            
            List<Item> list = session.selectList("Test.selectOneByDept", 30);
            
            System.out.println("cnt: " + list.size());
            for(Item u : list) {
                System.out.println(u.getId() + ", " +u.getName() + ", " + u.getJob() + ", " + u.getSalary());
            }
            
             
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	if (session != null) session.close();
        }
	}
	
	public static void test2() {
		SqlSession session = null;
		try {
			
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory  = new SqlSessionFactoryBuilder().build(reader);
             
            session = sqlSessionFactory .openSession();
            
            
            		
            AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
            List<Item> list = mapper.selectByDept(30);
            
            System.out.println("cnt: " + list.size());
            for(Item u : list) {
                System.out.println(u.getId() + ", " +u.getName() + ", " + u.getJob() + ", " + u.getSalary());
            }
            
             
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	if (session != null) session.close();
        }
		
	}
	
	public static void test3() {
		SqlSession session = null;
		try {
			
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory  = new SqlSessionFactoryBuilder().build(reader);
             
            session = sqlSessionFactory .openSession();
            
            
            		
            AnnotationMapper2 mapper = session.getMapper(AnnotationMapper2.class);
            List<NationVO> list = mapper.selectNationAll();
            
            System.out.println("cnt: " + list.size());
            for(NationVO u : list) {
                System.out.println(u.getCode() + ", " +u.getName() + ", " + u.getContinent() + ", " + u.getCapital());
            }
            
             
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	if (session != null) session.close();
        }
		
	}

}
