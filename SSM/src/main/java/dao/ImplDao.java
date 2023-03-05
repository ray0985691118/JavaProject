package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import Model.Porder;

public interface ImplDao {
	//連線-->java8.0以後才能有body
	public static SqlSession getDB() throws IOException
	{
		InputStream res=Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf=new SqlSessionFactoryBuilder().build(res);
		SqlSession se=sf.openSession();
		return se;
	}
	
	void add(Object o) throws IOException;
	
	
	List<Object> selectAll()throws IOException;
	List<Object> selectAll(String msg)throws IOException;
	List<Object> selectId(Integer id)throws IOException;
	
	
	void update(Object o)throws IOException;
	
	
	void delete(Object o)throws IOException;
	
	
}
