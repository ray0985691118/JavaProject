package Dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import Model.member;
import Model.porder;

public class memberDao implements implDao{

	public static void main(String[] args) throws IOException {
		System.out.println(implDao.getDB());
		
		//新增
		/*member m=new member("abc","def","8585","456123","台北",false);
		new memberDao().add(m);*/
		
		//查詢多筆
		/*List<Object> l=new memberDao().queryAll();
        member[] m=l.toArray(new member[l.size()]);
        for(member o:m) 
        	{
        	System.out.println(o.getName());
        	}*/
		
		//查詢多筆
        /*List<Object> l=new memberDao().queryAll();
		for(Object m:l)
		{
			System.out.println(((member) m).getId()+"\t"+((member) m).getName());
		}*/
        
		//查詢單筆
		/*List<Object> l=new memberDao().query(2);
        member[] m=l.toArray(new member[l.size()]);
        for(member o:m) {
        	System.out.println(o.getName());*/
		
		//修改
		/*List<Object> l=new memberDao().query(1);
		member[] m=l.toArray(new member[l.size()]);
		m[0].setName("ted");
		m[0].setPhone("232");
		new memberDao().update(m[0]);*/
		
		//刪除
		/*List<Object>l=new memberDao().query(2);
        member[] m=l.toArray(new member[l.size()]);
        new memberDao().delete(m[0]);*/
	}
	//判斷帳密-->只有自己才有就不打在implDao
	public static List<Object> queryuser(String username,String password) throws IOException
	{
		SqlSession session=implDao.getDB();
		Map<String ,String> m=new HashMap();
		m.put("username",username);
		m.put("password",password);
		List<Object> l=session.selectList("memberMapper.loginuser",m);
		return l;
	}
	
	//判斷帳號是否重複
		public static  List<Object> queryuser2(String username)throws Exception{
			SqlSession session=implDao.getDB();
			Map<String,String>m=new HashMap();
			m.put("username", username);
			List<Object> l=session.selectList("memberMapper.loginuser2", m);
			return l;			
		}
		
	@Override
	public void add(Object o) throws IOException{
		SqlSession session=implDao.getDB();
		session.insert("memberMapper.add",o);
		session.commit();
	}

	@Override
	public List<Object> queryAll() throws IOException {
		SqlSession session=implDao.getDB();
		List<Object> l=session.selectList("memberMapper.select");
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
		List<Object> l=session.selectList("memberMapper.select2",id);
		return l;
	}

	@Override
	public void update(Object o) throws IOException {
		SqlSession session=implDao.getDB();
		session.update("memberMapper.update",o);
		session.commit();
	}

	@Override
	public void delete(Object o) throws IOException {
		SqlSession session=implDao.getDB();
		session.delete("memberMapper.delete",o);
		session.commit();
	}
	@Override
	public List<porder> queryAll2() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
