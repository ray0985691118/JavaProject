package dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.ibatis.session.SqlSession;

import Model.Member;
import Model.Porder;


public class MemberDao implements ImplDao{
	
	private static boolean reset = true;
    private static int number = 0;
	
	public static void main(String[] args) throws IOException {
		System.out.println(ImplDao.getDB());
		
		//List<Object> l = new MemberDao().selectUser("rrrr", "1111");	
		
		//新增
		/*Member m=new Member("rraa","abc","123","456123","台北",false);
		new MemberDao().add(m);*/
		
		//查詢多筆
		/*List<Object> l=new MemberDao().queryAll();
        Member[] m=l.toArray(new Member[l.size()]);
        for(Member o:m) 
        	{
        	System.out.println(o.getName());
        	}*/
		
		//查詢多筆
        /*List<Object> l=new MemberDao().queryAll();
		for(Object m:l)
		{
			System.out.println(((Member) m).getId()+"\t"+((Member) m).getName());
		}*/
        
		//查詢單筆
		/*List<Object> l=new MemberDao().query(2);
        Member[] m=l.toArray(new Member[l.size()]);
        for(Member o:m) {
        	System.out.println(o.getName());*/
		
		//修改
		/*List<Object> l=new MemberDao().query(1);
		Member[] m=l.toArray(new Member[l.size()]);
		m[0].setName("ted");
		m[0].setPhone("232");
		new MemberDao().update(m[0]);*/
		
		//刪除
		/*List<Object>l=new MemberDao().query(2);
        Member[] m=l.toArray(new Member[l.size()]);
        new MemberDao().delete(m[0]);*/
	}
	//判斷帳密-->只有自己才有就不打在ImplDao
	public static List<Object> selectUser(String username,String password) throws IOException
	{
		SqlSession session=ImplDao.getDB();
		Map<String ,String> m = new HashMap();
		m.put("username",username);
		m.put("password",password);
		List<Object> l=session.selectList("memberMapper.selectUser",m);
		return l;
	}
	
	//判斷帳號是否重複
		public static  List<Object> selectUser2(String username)throws Exception{
			SqlSession session = ImplDao.getDB();
			Map<String,String>m = new HashMap();
			m.put("username", username);
			List<Object> l = session.selectList("memberMapper.selectUser2", m);
			return l;			
		}
		
	@Override
	public void add(Object o) throws IOException{
		SqlSession session = ImplDao.getDB();
		session.insert("memberMapper.add",o);
		session.commit();
	}

	@Override
	public List<Object> selectAll() throws IOException {
		SqlSession session = ImplDao.getDB();
		List<Object> l = session.selectList("memberMapper.selectAll");
		return l;
	}

	@Override
	public List<Object> selectAll(String msg) throws IOException {
		SqlSession session = ImplDao.getDB();
		List<Object> l=session.selectList(msg);
		return l;
	}

	@Override
	public List<Object> selectId(Integer id) throws IOException {
		SqlSession session = ImplDao.getDB();
		List<Object> l=session.selectList("memberMapper.selectId",id);
		return l;
	}

	@Override
	public void update(Object o) throws IOException {
		SqlSession session=ImplDao.getDB();
		session.update("memberMapper.update",o);
		session.commit();
	}

	@Override
	public void delete(Object o) throws IOException {
		SqlSession session=ImplDao.getDB();
		session.delete("memberMapper.delete",o);
		session.commit();
	}
	
	public static int generate(){
        if (reset){
            number = (int) (Math.random() * 10000);
            reset  = false;
        }        
        return number;
    }
    
	public static void reset(){
        reset = true;
    }
	
	public int sendEmail(String email) {
		
		final String sender = "ray0985691118@gmail.com"; // The sender email
        final String urpass = "juilucjunhyqnxib"; //keep it secure
        int number = new MemberDao().generate();
        
        Properties set = new Properties();
        //Set values to the property
        set.put("mail.smtp.starttls.enable", "true");
        set.put("mail.smtp.auth", "true");
        set.put("mail.smtp.host", "smtp.gmail.com");
        set.put("mail.smtp.port", "587");
        Session session = Session.getInstance(set,new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, urpass);
        }});

        try {
            //email extends Java's Message Class, check out javax.mail.Message class to read more
            Message mes = new MimeMessage(session);
            mes.setFrom(new InternetAddress("ray0985691118@gmail.com")); //sender email address here
            mes.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email)); //Receiver email address here
            mes.setSubject("Check your email and rturn cod!!"); //Email Subject and message
            mes.setText("This is your code,please keep it safe!!" + "\t " + number);
            Transport.send(mes);
            System.out.println(number+"ImplMemberDao");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return number;
	}

}
