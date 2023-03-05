
package dao.member;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Model.Member;
import dao.DbConnection;

public class ImplMemberDao implements MemberDao{

	    private static boolean reset = true;
	    private static int number = 0;
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Member m =new Member("good","g123","4422","台北","567","888");
		new ImplMemberDao().add(m);*/
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

	@Override
	public void add(Member m) { //void?
		
		Connection con = DbConnection.getDB();
		/*String SQL = "insert into Member(name,username,password,address,phone,mobile)"
				+ "value(?,?,?,?,?,?)";*/
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement("insert into Member(name,username,password,address,phone,email)"
					+ "value(?,?,?,?,?,?)");
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getPhone());
			ps.setString(6, m.getEmail());
			
			ps.executeUpdate();
			con.commit();
			con.rollback();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Member> selectAll() {
		Connection con = DbConnection.getDB();
		//String SQL = "select * from Member";
		try {
			PreparedStatement ps = con.prepareStatement("select * from Member");
			ResultSet rs = ps.executeQuery(); //?
			
			while(rs.next()) {
				System.out.println(rs.getString("name")+"\t"+rs.getString("username")
				+"\t"+rs.getString("password")+"\t"+rs.getString("address")
				+"\t"+rs.getString("phone")+"\t"+rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean selectUser(String username) {
		Connection con = DbConnection.getDB();
		//String SQL = "select * from Member where username=?";
		boolean ans = true;
		try {
			PreparedStatement ps = con.prepareStatement("select * from Member where username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next() && rs.getInt(1)>0) ans=false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public List<Member> selectUser(String username, String password) {
		Connection con = DbConnection.getDB();
		//String SQL = "select * from Member where username=? and password=?";
		List<Member> l = new ArrayList();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from Member where username=? and password=?");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Member m = new Member();
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Member selectUser2(String username, String password) {
		Connection con = DbConnection.getDB();
		//String SQL = "select * from Member where username=? and password=?";
		Member m = null;
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from Member where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				m = new Member();
				//m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				//m.setAddress(rs.getString("address"));
				//m.setPhone(rs.getString("phone"));
				//m.setEmail(rs.getString("email"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public int sendEmail(String email) {
		
		final String sender = "ray0985691118@gmail.com"; // The sender email
        final String urpass = "juilucjunhyqnxib"; //keep it secure
        int number = new ImplMemberDao().generate();
        
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
            mes.setContent("This is your code,please keep it safe!!<br/>" + number,"text/html; charset=utf-8");
            Transport.send(mes);
            System.out.println(number+"ImplMemberDao");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return number;
	}
}
