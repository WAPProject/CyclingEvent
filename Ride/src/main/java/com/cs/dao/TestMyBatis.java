package com.cs.dao;


import com.cs.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

	@Test
	public void testDelete() {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory f = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = f.openSession();
			session.delete(User.class.getName()+".delete",105);
			session.commit();
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAdd() {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			User u = new User();
			u.setName("孙悟空");

			session.insert(User.class.getName()+".add", u);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			MybatisUtil.closeSqlSession();
		}
	}
	
	@Test
	public void testLoad() {
		SqlSession session = null;
		try{
			session = MybatisUtil.getSqlSession();
			User u = (User)session.selectOne(User.class.getName()+".load", 1);
			System.out.println(u.getName());
		} finally {
			MybatisUtil.closeSqlSession( );
		}
	}
	
	@Test
	public void testList() {
		SqlSession session = null;
		try{
			session = MybatisUtil.getSqlSession();
			List<User> us = session.selectList(User.class.getName()+".list", null);
			System.out.println(us.size());
		} finally {
			MybatisUtil.closeSqlSession( );
		}
	}
	
}
