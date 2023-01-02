package Dao;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import Model.porder;

public class porderDao implements implDao{

	public static void main(String[] args) throws IOException {
		
		List<porder> l=new porderDao().queryrange(100, 1000);
		porder[] p=l.toArray(new porder[l.size()]);
		for(porder o:p)
		{
			System.out.println(o.getName());
		}
		
		//新增
	    /*porder p=new porder("apple",1,1,1,new Date());
		new porderDao().add(p);*/
	}
	//查詢範圍-->只有自己才用的method就不打在implDao
	public static List<porder> queryrange(Integer start,Integer end) throws IOException
	{
		SqlSession session=implDao.getDB();
		Map<String,Integer> m=new HashMap();
		m.put("start", start);
		m.put("end", end);
		List<porder> l=session.selectList("porderMapper.queryrange",m);
		return l;
	}
	@Override
	public void add(Object o) throws IOException {
		SqlSession session=implDao.getDB();
		session.insert("porderMapper.add", o);
		session.commit();
	}

	@Override
	public List<Object> queryAll() throws IOException {
		SqlSession session=implDao.getDB();
		List<Object> l=session.selectList("porderMapper.select");
		return l;
	}

	@Override
	public List<Object> queryAll(String msg) throws IOException {
		SqlSession session=implDao.getDB();
		List<Object> l=session.selectList(msg);
		return l;
	}

	@Override
	public List<Object> query(Integer id) throws IOException {
		SqlSession session=implDao.getDB();
		List<Object> l=session.selectList("porderMapper.select2",id);
		return l;
	}

	@Override
	public void update(Object o) throws IOException {
		SqlSession session=implDao.getDB();
		session.update("porderMapper.update",o);
		session.commit();
	}

	@Override
	public void delete(Object o) throws IOException {
		SqlSession session=implDao.getDB();
		session.delete("porderMapper.delete",o);
		session.commit();
	}
	@Override
	public List<porder> queryAll2() throws IOException {
		SqlSession session=implDao.getDB();
		List<porder> l=session.selectList("porderMapper.select");
		return l;
	}

}
