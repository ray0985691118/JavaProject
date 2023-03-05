package dao;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import Model.Porder;

public class PorderDao implements ImplDao{

	public static void main(String[] args) throws IOException {
		
		List<Porder> l=new PorderDao().selectRange(1000, 2000);
		Porder[] p=l.toArray(new Porder[l.size()]);
		for(Porder o:p)
		{
			System.out.println(o.getName());
		}
		
		//新增
	    /*Porder p=new Porder("A桌",1,1,1,new Date());
		new PorderDao().add(p);*/
	}
	//查詢範圍-->只有自己才用的method就不打在ImplDao
	public static List<Porder> selectRange(Integer start,Integer end) throws IOException
	{
		SqlSession session=ImplDao.getDB();
		Map<String,Integer> m=new HashMap();
		m.put("start", start);
		m.put("end", end);
		List<Porder> l=session.selectList("porderMapper.selectRange",m);
		return l;
	}
	@Override
	public void add(Object o) throws IOException {
		SqlSession session=ImplDao.getDB();
		session.insert("porderMapper.add", o);
		session.commit();
	}

	@Override
	public List<Object> selectAll() throws IOException {
		SqlSession session=ImplDao.getDB();
		List<Object> l=session.selectList("porderMapper.selectAll");
		return l;
	}

	@Override
	public List<Object> selectAll(String msg) throws IOException {
		SqlSession session=ImplDao.getDB();
		List<Object> l=session.selectList(msg);
		return l;
	}

	@Override
	public List<Object> selectId(Integer id) throws IOException {
		SqlSession session=ImplDao.getDB();
		List<Object> l=session.selectList("porderMapper.selectId",id);
		return l;
	}

	@Override
	public void update(Object o) throws IOException {
		SqlSession session=ImplDao.getDB();
		session.update("porderMapper.update",o);
		session.commit();
	}

	@Override
	public void delete(Object o) throws IOException {
		SqlSession session=ImplDao.getDB();
		session.delete("porderMapper.delete",o);
		session.commit();
	}
	
	public static List<Porder> queryAll() throws IOException {
		SqlSession session=ImplDao.getDB();
		List<Porder> l=session.selectList("porderMapper.selectAll");
		return l;
	}

}
